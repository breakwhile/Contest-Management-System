package cn.edu.xmut.MyContest.serviceimpl;

import cn.edu.xmut.MyContest.Dao.Dao;
import cn.edu.xmut.MyContest.model.Fund;
import cn.edu.xmut.MyContest.service.TeacherService;


public class TeacherServiceImpl implements TeacherService {
	private Dao dao;
	
	public void delete(Object entity) {
		dao.delete(entity);
	}
	
	public void save(Object entity) {
		dao.save(entity);
	}
	
	public void update(Object entity) {
		dao.update(entity);
	}
	
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}	
}
