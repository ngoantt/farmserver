package com.ngoantran.farmserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "newsfeed")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NewsFeed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586465578833858137L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int id;

	@Column(name = "name")
	public String name;

	@Column(name = "status")
	public String status;

	@Column(name = "image")
	public String image;

	@Column(name = "profilePic")
	public String profilePic;

	@Column(name = "timestamp")
	public String timestamp;

	@Column(name = "url")
	public String url;

}
