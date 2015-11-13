package cn.edu.xmut.MyContest.service;

import java.util.List;

import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;

public interface QueryService {
	@SuppressWarnings("rawtypes")
	public List<Object> queryList(Class clasz);
	
	@SuppressWarnings("rawtypes")
	public Object querySingle(Class clasz, int id);
	
	public Teacher queryTeacher(int teacherId);	
	
	public Fund queryFundEventId(int eventId);	
	
	@SuppressWarnings("rawtypes")
	public int count_entity(Class clasz);
	
	@SuppressWarnings("rawtypes")
	public int count_someEntity(Class clasz, String field, String s);
}
