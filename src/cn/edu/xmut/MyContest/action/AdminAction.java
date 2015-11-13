package cn.edu.xmut.MyContest.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xmut.MyContest.model.Apply;
import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.service.AdminService;
import cn.edu.xmut.MyContest.service.QueryService;

public class AdminAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private QueryService queryService;
	private AdminService adminService;
	
	//更新指定教师的资料
	public String update_teacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();	
		
		Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));
		String teacherno = request.getParameter("teacherno");
		String teachername = request.getParameter("teachername");
		String password = request.getParameter("password");
		String profession = request.getParameter("profession");
		String phone = request.getParameter("phone");
		String identity = request.getParameter("identity");
		
		Teacher newTea = (Teacher) queryService.querySingle(Teacher.class, teacherId);
		newTea.setTeacherno(teacherno);
		newTea.setTeachername(teachername);
		newTea.setPassword(password);
		newTea.setProfession(profession);
		newTea.setPhone(phone);
		newTea.setNote(identity);
		if (identity.equals("竞赛负责人"))
			newTea.setLevel("1");
		else
			newTea.setLevel("0");
		adminService.update(newTea);
		//System.out.println(newTea.getTeacherno() + " " + newTea.getTeachername() + " " + newTea.getNote());
		//new QueryAction().teacherList();
		
		List<Object> teacherList = queryService.queryList(Teacher.class);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("teacherList",teacherList);		
		return "update_teacher";
		
	}
	
	public String ratify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		validate_admin();
		
		String applyName = request.getParameter("apply_name");
		if (applyName.equals("竞赛负责人")) {
			Integer teacherId = Integer.parseInt(request.getParameter("apply_detail"));
			Teacher upTea = queryService.queryTeacher(teacherId);	
			upTea.setLevel("1");
			upTea.setNote("竞赛负责人");
			adminService.update(upTea);
			rebut();
		} else if (applyName.equals("经费申请")) {
			//TODO
		}
		return "ratifyOrRebut";
	}
	
	public String rebut() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		Integer applyId = Integer.parseInt(request.getParameter("apply_id"));
		Apply delete_app = (Apply) queryService.querySingle(Apply.class, applyId);
		adminService.delete(delete_app);
		
		String applyName = request.getParameter("apply_name");
		if (applyName.equals("竞赛负责人")) {
			List<Object> applyList = (ArrayList<Object>) queryService.queryList(Apply.class);
			//去除经费申请列表，保留负责人申请
			for (int i = 0; i < applyList.size(); i++)
				if (((Apply) applyList.get(i)).getApplyname().equals("申请经费")) {
					applyList.remove(i);
					i--;
				}
			session.setAttribute("applyList",applyList);		
		} else if (applyName.equals("申请经费")) {
			List<Object> applyList = (ArrayList<Object>) queryService.queryList(Apply.class);
			//去除负责人申请列表，保留经费申请
			for (int i = 0; i < applyList.size(); i++)
				if (((Apply) applyList.get(i)).getApplyname().equals("竞赛负责人")) {
					applyList.remove(i);
					i--;
				}
			session.setAttribute("applyList",applyList);			
		}
		return "ratifyOrRebut";
	}
	
	public String add_teacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();	
			
		String teacherno = request.getParameter("add_teacherno");
		String teachername = request.getParameter("add_teachername");
		String password = request.getParameter("add_password");
		String profession = request.getParameter("add_profession");
		String phone = request.getParameter("add_phone");
		String identity = request.getParameter("add_identity");	
		
		Teacher add_teacher = new Teacher();
		/*
		int id;
		if ((id = count_teacher()) != -1)
			add_teacher.setId(id + 1);		
		else
			add_teacher.setId(1);	
		*/
		add_teacher.setTeacherno(teacherno);
		add_teacher.setTeachername(teachername);
		add_teacher.setPassword(password);
		add_teacher.setProfession(profession);
		add_teacher.setPhone(phone);
		add_teacher.setNote(identity);		
		if (identity.equals("竞赛负责人"))
			add_teacher.setLevel("1");
		else
			add_teacher.setLevel("0");
		adminService.save(add_teacher);	
		List<Object> teacherList = queryService.queryList(Teacher.class);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("teacherList",teacherList);		
		return "add_teacher";		
	}
	
	public int count_teacher() {
		return queryService.count_entity(Teacher.class);
	}
	
	public String exit() {
		//销毁session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("admin");
		return "exit";
		
	}
	
	public String delete_fund() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		Integer fund_id = Integer.parseInt(request.getParameter("fund_id"));
		Fund delete_fund = (Fund) queryService.querySingle(Fund.class, fund_id);
		Fund total_fund = (Fund) queryService.querySingle(Fund.class, 1);
		Double newSpend = total_fund.getSpend() - delete_fund.getSpend();
		total_fund.setSpend(newSpend);
		adminService.delete(delete_fund);
		adminService.update(total_fund);	

		Double spend, total;
		ArrayList<Object> fundList = (ArrayList<Object>) queryService.queryList(Fund.class);
		spend = ((Fund) (fundList.get(0))).getSpend();
		total = ((Fund) (fundList.get(0))).getTotal();
		fundList.remove(0);
		session.setAttribute("fundList", fundList);	
		session.setAttribute("spend", spend);
		session.setAttribute("total", total);	
		return "delete_fund";
	}	
	
	public String delete_teacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		Integer delete_id = Integer.parseInt(request.getParameter("delete_id"));
		Teacher delete_tea = (Teacher) queryService.querySingle(Teacher.class, delete_id);
		adminService.delete(delete_tea);

		List<Object> teacherList = queryService.queryList(Teacher.class);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("teacherList",teacherList);		
		return "delete_teacher";
	}
	
	//验证当前管理员身份是否合法
	public void validate_admin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//检测是否登陆
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("admin") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='login_admin.jsp';</script>");
			out.flush();
			out.close();
			return ;
		}		
		return ;
	}
	
	public QueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


}
