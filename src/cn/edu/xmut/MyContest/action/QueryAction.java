package cn.edu.xmut.MyContest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xmut.MyContest.model.Apply;
import cn.edu.xmut.MyContest.model.Contestant;
import cn.edu.xmut.MyContest.model.Events;
import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.service.QueryService;

public class QueryAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private List<Object> teacherList;
	private List<Object> applyPowerList;
	private List<Object> applyFundList;
	private List<Object> fundList;
	private QueryService queryService;
	private int teacher_id;
	private int event_id;
	
	public String contestInfoList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_leader();	
		
		session = ServletActionContext.getRequest().getSession();
		List<Object> contestantList = (ArrayList<Object>) queryService.queryList(Contestant.class);
		List<Object> teacherList = (ArrayList<Object>) queryService.queryList(Teacher.class);
		List<Object> eventsList = (ArrayList<Object>) queryService.queryList(Events.class);
		session.setAttribute("contestantList",contestantList);
		session.setAttribute("teacherList",teacherList);
		session.setAttribute("eventsList",eventsList);
		return "contestInfoList";
	}
	
	public String applyFundList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		applyFundList = (ArrayList<Object>) queryService.queryList(Apply.class);
		//去除经费申请列表，保留负责人申请
		for (int i = 0; i < applyFundList.size(); i++)
			if (((Apply) applyFundList.get(i)).getApplyname().equals("竞赛负责人")) {
				applyFundList.remove(i);
				i--;
			}
		session.setAttribute("applyFundList",applyFundList);			
		return "applyFundList";
	}	
	
	public String fundList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		Double spend, total;
		fundList = (ArrayList<Object>) queryService.queryList(Fund.class);
		spend = ((Fund) (fundList.get(0))).getSpend();
		total = ((Fund) (fundList.get(0))).getTotal();
		fundList.remove(0);
		session.setAttribute("fundList", fundList);	
		session.setAttribute("spend", spend);
		session.setAttribute("total", total);
		return "fundList";
	}		
	
	public String applyPowerList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();
		
		applyPowerList = (ArrayList<Object>) queryService.queryList(Apply.class);
		//去除经费申请列表，保留负责人申请
		for (int i = 0; i < applyPowerList.size(); i++)
			if (((Apply) applyPowerList.get(i)).getApplyname().equals("申请经费")) {
				applyPowerList.remove(i);
				i--;
			}
		session.setAttribute("applyPowerList",applyPowerList);	
		return "applyPowerList";
	}
	
	public String contestantList() throws Exception {
		// 解决乱码，用于页面输出
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_leader();	
		
		session = ServletActionContext.getRequest().getSession();
		List<Object> contestantList = (ArrayList<Object>) queryService.queryList(Contestant.class);
		session.setAttribute("contestantList",contestantList);
		return "contestantList";		
		
	}
	
	public String eventsList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_leader();		
		
		session = ServletActionContext.getRequest().getSession();
		List<Object> eventsList = (ArrayList<Object>) queryService.queryList(Events.class);
		session.setAttribute("eventsList",eventsList);
		return "eventsList";
		
	}
	
	public String teacherList() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_admin();	
		
		teacherList = (ArrayList<Object>) queryService.queryList(Teacher.class);
		session.setAttribute("teacherList",teacherList);
		/*
		System.out.println(teacherList.size());
		for (int i = 0; i < teacherList.size(); i++) {
			System.out.println(teacherList.get(i).getTeacherno() + " " + teacherList.get(i).getTeachername() + " " +
					teacherList.get(i).getPassword() + " " + 
					teacherList.get(i).getProfession() + " " + teacherList.get(i).getNote());
		}		
		*/
		return "teacherList";
	}
	
	//获取赛事列表中指定赛事对象
	public String queryEvents() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		Events event = (Events) queryService.querySingle(Events.class, event_id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("event", event);
		return "query_event";
	}
	
	//获取教师表中指定教师对象
	public String queryTeacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		Teacher teacher = (Teacher) queryService.querySingle(Teacher.class, teacher_id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("teacher",teacher);
		//System.out.println(teacher.getTeacherno() + " " + teacher.getTeachername());
		return "query_teacher";
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
	
	//验证当前管理员身份是否合法
	public void validate_leader() {
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
		if (session.getAttribute("teacher") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='login_teacher.jsp';</script>");
			out.flush();
			out.close();
			return ;
		} else if (session.getAttribute("leader") == null) {
			out.print("<script language='javascript'>alert('你不是竞赛负责人，无法管理竞赛信息！');javascript:window.history.back();</script>");
			out.flush();
			out.close();			
		}		
		return ;
	}	
	
	public List<Object> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Object> teacherList) {
		this.teacherList = teacherList;
	}
	
	public QueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}	
	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}	
}
