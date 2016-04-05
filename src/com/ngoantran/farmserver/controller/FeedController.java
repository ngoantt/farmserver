package com.ngoantran.farmserver.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ngoantran.farmserver.model.NewsFeed;
import com.ngoantran.farmserver.model.Status;
import com.ngoantran.farmserver.services.FeedServices;

@Controller
@RequestMapping("/newsfeed")
public class FeedController {
	public static final Log logger = LogFactory.getLog(FeedController.class);
	@Autowired
	FeedServices feedServices;

	/* Submit form in Spring Restful Services */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addFeed(@RequestBody NewsFeed feed) {
		try {
			feedServices.addEntity(feed);
			return new Status(1, "News Feed is add successfully!");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}

	/* Ger a single objct in Json form in Spring Rest Services */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody NewsFeed getNewsFeed(@PathVariable("id") int id) {
		NewsFeed feed = null;
		try {
			feed = feedServices.getEntityById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(feed.id+"-"+feed.image);
		return feed;
	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<NewsFeed> getFeedList() {
		logger.info("may vao day khong");
		List<NewsFeed> feedList = null;
		try {
			feedList = feedServices.getEntityList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedList;
	}

	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteFeed(@PathVariable("id") int id) {
		try {
			feedServices.deleteEntity(id);
			return new Status(1, "delete news feed successfully!");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}
}
