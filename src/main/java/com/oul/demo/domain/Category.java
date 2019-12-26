package com.oul.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "cover_photo_url")
	private String coverPhotoUrl;

	@ManyToOne(optional = false)
	@JoinColumn(name = "company_id", nullable = false, updatable = true)
	@JsonBackReference
	private Company company;

	@ManyToMany(mappedBy = "categoryList")
	@JsonBackReference
	private List<ContentData> contentDataList;


}
