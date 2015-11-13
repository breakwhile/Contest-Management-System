package cn.edu.xmut.MyContest.serviceimpl;

import cn.edu.xmut.MyContest.Dao.Dao;
import cn.edu.xmut.MyContest.model.Admin;
import cn.edu.xmut.MyContest.model.Teacher;
import cn.edu.xmut.MyContest.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private Dao dao;
	
	@SuppressWarnings("rawtypes")
	public Object login(String userName, String password, Class clasz) {
		Object obj = null;
		try {
			if (clasz.newInstance() instanceof Admin) {
				obj = dao.getByHql("FROM Admin a WHERE a.username='"+ userName +"'");
				if (obj != null && ((Admin) obj).getPassword().equals(password))
					return obj;
			} else if (clasz.newInstance() instanceof Teacher) {
				obj = dao.getByHql("FROM Teacher t WHERE t.teachername='"+ userName +"'");
				if (obj != null && ((Teacher) obj).getPassword().equals(password))
					return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
