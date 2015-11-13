package cn.edu.xmut.MyContest.service;

public interface LoginService {
	@SuppressWarnings("rawtypes")
	public Object login(String userName, String password, Class clasz);
}
