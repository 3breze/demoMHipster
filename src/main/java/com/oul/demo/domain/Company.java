package com.oul.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "company_name")
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	@JsonManagedReference
	private List<Category> categoryList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	@JsonManagedReference
	private List<TechnicalData> technicalDataList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	@JsonManagedReference
	private List<ContentData> contentDataList;

}
