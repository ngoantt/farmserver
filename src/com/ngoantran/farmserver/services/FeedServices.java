package com.ngoantran.farmserver.services;

import java.util.List;

import com.ngoantran.farmserver.model.NewsFeed;

public interface FeedServices {

	public boolean addEntity(NewsFeed feed) throws Exception;

	public NewsFeed getEntityById(int id) throws Exception;

	public List<NewsFeed> getEntityList() throws Exception;

	public boolean deleteEntity(int id) throws Exception;
}
