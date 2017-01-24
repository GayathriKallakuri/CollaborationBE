package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	private static final Friend Friend = null;
	@Autowired
	SessionFactory sessionFactory;

	private Friend friend;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public FriendDAOImpl() {

	}

	@Transactional
	public List<com.niit.collaboration.model.Friend> getMyFriend(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public com.niit.collaboration.model.Friend get(String userID, String friendID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public com.niit.collaboration.model.Friend get(int friendID) {
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Friend.class);
		ct.add(Restrictions.eq("friendID",friendID));
		System.out.println(friendID);
		Friend f = (com.niit.collaboration.model.Friend) ct.uniqueResult();
		return f;	
	}

	@Transactional
	public boolean save(com.niit.collaboration.model.Friend friend) {
		try{
			  sessionFactory.getCurrentSession().save(friend);
		return true;
			}catch (Exception e ){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean update(com.niit.collaboration.model.Friend friend) {
		try{
			sessionFactory.getCurrentSession().update(friend);
	return true;
		} catch (Exception e){
			//TODO Auto-generated catch block
	       e.printStackTrace();
	       return false;
		}
	}

	@Transactional
	public boolean delete(String userID, String friendID) {
		Friend friend = new Friend();
		friend.setFriendID(friendID);
		friend.setUserID(userID);
		sessionFactory.getCurrentSession().delete(friend);
		return true;
	}

	@Transactional
	public List<com.niit.collaboration.model.Friend> getNewFriendRequests(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void setOnline(String loggedInUserID) {
		Logger.debug("Starting of the method setOnline");
		String hql = "UPDATE Friend SET isOnline = 'Y' where userID ='" + loggedInUserID + "'";
		Logger.debug("hql: " + hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		Logger.debug("Ending of the method setOnline");
		
	}

	@Transactional
	public void setOffLine(String loggedInUserID) {
		Logger.debug("Starting of the method setOffline");
		String hql = "UPDATE Friend SET isOnline = 'N' where userID = '" + loggedInUserID + "'";
		Logger.debug("hql: " + hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		Logger.debug("Ending of the method setOffline");
		
	}
}
