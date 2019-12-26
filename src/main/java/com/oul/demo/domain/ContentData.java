package com.oul.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "content_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentData {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "cover_photo_url")
	private String coverPhotoUrl;

	@ManyToOne(optional = false)
	@JoinColumn(name = "company_id", nullable = false, updatable = true)
	@JsonBackReference
	private Company company;

	@ManyToMany()
	@JoinTable(name = "category_content_data", joinColumns = {
			@JoinColumn(name = "contentdata_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	@JsonManagedReference
	private List<Category> categoryList;

	@ManyToOne(optional = false)
	@JoinColumn(name = "technical_data_id", nullable = false, updatable = true)
	@JsonBackReference
	private TechnicalData technicalData;

}
