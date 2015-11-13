package cn.edu.xmut.MyContest.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmut.MyContest.model.Admin;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String adminName;
	private String adminPassword;
	private String teacherName;
	private String teacherPassword;
	private LoginService loginService;

	public String login_admin() {
		Admin ad = (Admin) loginService.login(adminName, adminPassword, Admin.class);
		if (ad != null) {
			ActionContext.getContext().getSession().put("admin", ad);
			return "login_admin";
		}
		else
			return "error_admin";
	}
	
	public String login_teacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		Teacher teacher = (Teacher) loginService.login(teacherName, teacherPassword, Teacher.class);
		if (teacher != null) {
			ActionContext.getContext().getSession().put("teacher", teacher);
			if (teacher.getLevel().equals("1")) {
				ActionContext.getContext().getSession().put("leader", teacher);
			}
			return "login_teacher";
		} else
			return "error_teacher";
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}	

}
