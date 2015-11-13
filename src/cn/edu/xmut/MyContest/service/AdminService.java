package cn.edu.xmut.MyContest.service;

import cn.edu.xmut.MyContest.model.Apply;
import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;

public interface AdminService {
	public void save(Object entity);
	
	public void delete(Object entity);
	
	public void update(Object entity);
}
