package cn.edu.xmut.MyContest.serviceimpl;

import java.util.ArrayList;
import cn.edu.xmut.MyContest.service.QueryService;
import java.util.List;

import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.Dao.Dao;

public class QueryServiceImpl implements QueryService {
	private Dao dao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> queryList(Class clasz) {
		List<Object> list = (ArrayList<Object>) dao.listByHql("from " + clasz.getName() + " l");
		if (list != null)
			return list;
		else
			System.out.println("未查询到相关数据！");
		return null;
	}
	
	//获取某个表中特定对象
	@SuppressWarnings("rawtypes")
	public Object querySingle(Class clasz, int id) {
		Object obj = dao.getByHql("from " + clasz.getName() + " s where id = " + id);
		return obj;
	}
	
	public Teacher queryTeacher(int teacherId) {
		Teacher teacher = (Teacher) dao.getByHql("from Teacher t where teacherno = " + teacherId);
		return teacher;
	}	
	
	public Fund queryFundEventId(int eventId) {
		Fund fund = (Fund) dao.getByHql("from Fund f where eventId = " + eventId);
		return fund;
	}	
	
	@SuppressWarnings("rawtypes")
	public int count_entity(Class clasz) {
		List<Object> list = queryList(clasz);
		if (list != null)
			return list.size();
		else
			return -1;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int count_someEntity(Class clasz, String field, String s) {
		StringBuffer ss = new StringBuffer("''");
		ss.insert(1, s);
		List<Object> list = (ArrayList<Object>) dao.listByHql("from " +
				clasz.getName() + " l where l." + field + "=" + ss);
		if (list != null)
			return list.size();
		else
			return -1;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
