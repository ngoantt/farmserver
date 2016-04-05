package com.ngoantran.farmserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ngoantran.farmserver.dao.FeedDao;
import com.ngoantran.farmserver.model.NewsFeed;

public class FeedServicesImpl implements FeedServices {

	@Autowired
	FeedDao feedDao;

	@Override
	public boolean addEntity(NewsFeed newsFeed) throws Exception {
		return feedDao.addEntity(newsFeed);
	}

	@Override
	public NewsFeed getEntityById(int id) throws Exception {
		return feedDao.getEntityById(id);
	}

	@Override
	public List<NewsFeed> getEntityList() throws Exception {
		return feedDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		return feedDao.deleteEntity(id);
	}

}
