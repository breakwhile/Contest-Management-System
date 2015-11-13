package cn.edu.xmut.MyContest.Dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class Dao extends HibernateDaoSupport {
	
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	public void save(Object entity) {
		//this.getHibernateTemplate().clear();
		this.getHibernateTemplate().save(entity);
		this.getHibernateTemplate().flush();
	}
	
	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public List listByHql(String hql) {
		// TODO Auto-generated method stub
		final String myhql = hql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(org.hibernate.Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				try {
					Query query = session.createQuery(myhql);
					List list = query.list();
					return list;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}
	
	@SuppressWarnings("rawtypes")
	public Object getByHql(String hql) {
		// TODO Auto-generated method stub
		final String myhql = hql;
		Object obj = null;
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(org.hibernate.Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query;
						try {
							query = session.createQuery(myhql);
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
						return query.list();
					}
				});
		if (list != null && list.size() > 0)
			obj = list.get(0);
		return obj;
	}
}
