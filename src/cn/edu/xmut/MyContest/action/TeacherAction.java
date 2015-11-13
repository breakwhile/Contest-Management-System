package cn.edu.xmut.MyContest.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import cn.edu.xmut.MyContest.model.Apply;
import cn.edu.xmut.MyContest.model.Awards;
import cn.edu.xmut.MyContest.model.Contestant;
import cn.edu.xmut.MyContest.model.Events;
import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.service.QueryService;
import cn.edu.xmut.MyContest.service.TeacherService;

import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private QueryService queryService;
	private TeacherService teacherService;
	
	public String apply_fund() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_teacher();	
		
		String applyFund = request.getParameter("applyFund");
		Apply apply_fund = new Apply();
		apply_fund.setApplyname("申请经费");
		apply_fund.setDetail(applyFund);
		apply_fund.setPlus(((Teacher) (session.getAttribute("teacher"))).getTeachername());
		teacherService.save(apply_fund);
		return "apply_fund";
	}
	
	public String apply_power() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
			
		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		
		//检测是否登陆
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("teacher") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='login_teacher.jsp';</script>");
			out.flush();
			out.close();
			return null;
		} else if (session.getAttribute("leader") != null) {
			out.print("<script language='javascript'>alert('你已经是竞赛负责人，不必重复申请！');javascript:window.history.back();</script>");
			out.flush();
			out.close();			
		}	
		
		Apply apply_power = new Apply();
		apply_power.setApplyname("竞赛负责人");
		apply_power.setDetail(((Teacher) (session.getAttribute("teacher"))).getTeacherno());
		apply_power.setPlus(((Teacher) (session.getAttribute("teacher"))).getTeachername());
		
		teacherService.save(apply_power);
		return "apply_power";
	}
	
	public String query_fund() throws Exception {
		Double per;
		// 解决乱码，用于页面输出
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		validate_leader();		
		
		Fund fund = (Fund) queryService.querySingle(Fund.class, 1);
		List<Object> eventsList = (ArrayList<Object>) queryService.queryList(Events.class);
		session = ServletActionContext.getRequest().getSession();
		per = fund.getSpend() / fund.getTotal() * 100;
		DecimalFormat df = new DecimalFormat(".##");
		String pers = df.format(per);
		session.setAttribute("pers", pers);
		session.setAttribute("fund", fund);
		session.setAttribute("eventsList", eventsList);
		return "query_fund";
	}
	
	public String add_award() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");	
		
		String contestant_id = request.getParameter("contestant_id");	
		String teacher_id = request.getParameter("teacher_id");
		String event_id = request.getParameter("event_id");
		String contest_date = request.getParameter("contest_date");				
		String clevel = request.getParameter("clevel");			
		Awards award = new Awards();
		award.setStudentid(Integer.parseInt(contestant_id));
		award.setTeacherid(Integer.parseInt(teacher_id));
		award.setEventid(Integer.parseInt(event_id));
		award.setYear(contest_date);
		award.setLevel(clevel);
		
		//保存到数据库
		teacherService.save(award);
		return "add_cinfo";
	}
	
	public String add_contestant() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");		
		
		String cnumber = request.getParameter("cnumber");	
		String cname = request.getParameter("cname");
		String cgender = request.getParameter("cgender");		
		String cpassword = request.getParameter("cpassword");	
		String cgrade = request.getParameter("cgrade");
		String cmajor = request.getParameter("cmajor");		
		
		Contestant contestant = new Contestant();
		contestant.setNumber(cnumber);
		contestant.setUsername(cname);
		contestant.setGender(cgender);
		contestant.setPassword(cpassword);
		contestant.setGrade(cgrade);
		contestant.setMajor(cmajor);
		
		//保存到数据库
		teacherService.save(contestant);
		return "add_cinfo";
	}
	
	public String add_event() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");		
		
		String ContestName = request.getParameter("ContestName");	
		String ContestScope = request.getParameter("ContestScope");
		String Organizer = request.getParameter("Organizer");
		
		Events event = new Events();
		/*
		int id;
		if ((id = queryService.count_entity(Events.class)) != -1)
			event.setId(id + 1);		
		else
			event.setId(1);			
		*/
		event.setContestname(ContestName);
		event.setScope(ContestScope);
		event.setOrganizer(Organizer);
		
		//保存到数据库
		teacherService.save(event);
		return "add_cinfo";
	}
	
	public String add_spend() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		Double addSpend = Double.parseDouble(request.getParameter("addSpend"));
		String event_id = request.getParameter("event_id");	
		String spendNote = request.getParameter("spendNote");
		spendNote = new String(spendNote.getBytes("iso-8859-1"), "UTF-8");		
		//获取总经费，计算该新增支出是否超过经费额度
		Fund total_spend = (Fund) queryService.querySingle(Fund.class, 1);
		double balance = total_spend.getTotal() - total_spend.getSpend();
		if (balance < addSpend) {
			String tips = "经费余额不足，上笔经费添加失败！请修改新增经费或申请增加经费！";
			request.setAttribute("tips",tips);
			return ERROR;
		}
		
		Fund add_spend = (Fund) queryService.queryFundEventId(Integer.parseInt(event_id));
		if (add_spend == null) {
			add_spend = new Fund();
			add_spend.setSpend(addSpend);
			add_spend.setEventId(event_id);
			Events fundEvent = (Events) queryService.querySingle(Events.class, Integer.parseInt(event_id));
			add_spend.setNote(fundEvent.getContestname());
			teacherService.save(add_spend);
		} else {
			Double spend = addSpend + add_spend.getSpend();
			add_spend.setSpend(spend);
			teacherService.update(add_spend);
		}		
		
		//将新的支出更新到总支出中
		total_spend.setSpend(total_spend.getSpend() + addSpend);
		//保存/更新到数据库
		
		teacherService.update(total_spend);
		
		//重新载入经费管理页面
		Fund fund = (Fund) queryService.querySingle(Fund.class, 1);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Double per = fund.getSpend() / fund.getTotal() * 100;
		session.setAttribute("pers",per);
		session.setAttribute("fund",fund);		
		return "add_spend";
		
	}
	
	public String delete_event() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");	
		
		Integer event_id = Integer.parseInt(request.getParameter("event_id"));
		Events delete_eve = (Events) queryService.querySingle(Events.class, event_id);
		teacherService.delete(delete_eve);

		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Object> eventsList = (ArrayList<Object>) queryService.queryList(Events.class);
		session.setAttribute("eventsList",eventsList);
		return "delete_event";		
	}
	
	public String update_event() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");	
		
		Integer eventId = Integer.parseInt(request.getParameter("eventId"));
		String eventName = request.getParameter("eventName");
		String eventScope = request.getParameter("eventScope");
		String eventOrg = request.getParameter("eventOrg");	
		
		Events newEvent = (Events) queryService.querySingle(Events.class, eventId);		
		newEvent.setContestname(eventName);
		newEvent.setScope(eventScope);
		newEvent.setOrganizer(eventOrg);
		teacherService.update(newEvent);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Object> eventsList = (ArrayList<Object>) queryService.queryList(Events.class);
		session.setAttribute("eventsList",eventsList);
		return "update_event";		
	}
	
	public String exit() {
		//销毁session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("teacher");
		session.removeAttribute("leader");
		return "exit";
	}	
	
	//验证当前是否登陆
	public void validate_teacher() {
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
	
	public int count_spend() {
		return queryService.count_entity(Fund.class);
	}

	public QueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	
	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}	
}
