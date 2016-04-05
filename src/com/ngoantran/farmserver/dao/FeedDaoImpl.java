package com.ngoantran.farmserver.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ngoantran.farmserver.model.NewsFeed;

public class FeedDaoImpl implements FeedDao {

	public static final Log logger = LogFactory.getLog(FeedDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(NewsFeed feed) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(feed);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public NewsFeed getEntityById(int id) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		NewsFeed feed = (NewsFeed) session.createCriteria(NewsFeed.class).add(Restrictions.eq("id", id)).uniqueResult();
		tx.commit();
		logger.info("getEntityById:" + feed.name);
		return feed;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsFeed> getEntityList() throws Exception {
		logger.info("vao ham feedDaoImpl khong");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<NewsFeed> feedList = session.createCriteria(NewsFeed.class).list();
		tx.commit();
		session.close();
		logger.info(feedList.size());
		return feedList;
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		session = sessionFactory.openSession();
		Object object = session.load(NewsFeed.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(object);
		tx.commit();
		return false;
	}

}
