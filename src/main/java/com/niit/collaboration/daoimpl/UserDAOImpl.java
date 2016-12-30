package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.UserDetailsDAO;
import com.niit.collaboration.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDetailsDAO {
	private static final UserDetails User = null;
	@Autowired
	SessionFactory sessionFactory;

	private UserDetails user;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDAOImpl() {

	}

	@Transactional
	public boolean saveUser(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateUser(UserDetails user) {
		try
		{
			sessionFactory.openSession() .update(user);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean removeUser(String userId) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public UserDetails getUser(String userId) {
		Session session=sessionFactory.getCurrentSession();
		
		Criteria ct=session.createCriteria(UserDetails.class);
		ct.add(Restrictions.eq("userId",userId));
		System.out.println(userId);
		UserDetails u=(UserDetails)ct.uniqueResult();
		return u;
	}

	@Transactional
	public List<UserDetails> getUserList() {
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession().createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return getUserList();
	}

	
	@Transactional
	public UserDetails isValidUser(String userId, String password) {
		System.out.println("hi");
        Session session=sessionFactory.getCurrentSession();
		
		Criteria cr=session.createCriteria(UserDetails.class);
		cr.add(Restrictions.eq("email",userId));
		cr.add(Restrictions.eq("password",password));
		user=(UserDetails)cr.uniqueResult();
		System.out.println(user.getName());
		return user;
	}

	@Transactional
	public boolean isUser(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
