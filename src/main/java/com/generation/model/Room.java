package com.generation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room", schema = "caseestanze")
public class Room
{
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type", length = 50)
	private String type;

	@Column(name = "area")
	private Double area;

	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Double getArea()
	{
		return area;
	}

	public void setArea(Double area)
	{
		this.area = area;
	}

	public House getHouse()
	{
		return house;
	}

	public void setHouse(House house)
	{
		this.house = house;
	}

}