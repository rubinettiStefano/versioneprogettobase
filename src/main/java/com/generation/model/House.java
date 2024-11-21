package com.generation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "house", schema = "caseestanze")
public class House
{
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "address", length = 50)
	private String address;

	@Column(name = "smp")
	private Double smp;

	@OneToMany(mappedBy = "house")
	private List<Room> rooms = new ArrayList<>();

	@ManyToMany(mappedBy = "houses")
	private List<Electrician> electricians = new ArrayList<>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Double getSmp()
	{
		return smp;
	}

	public void setSmp(Double smp)
	{
		this.smp = smp;
	}

	public double getTotalArea()
	{
		double res = 0;
		for(Room room : rooms)
			res+=room.getArea();

		return res;
	}

	public double calcPrice()
	{
		return getTotalArea()*smp;
	}

	public List<Room> getRooms()
	{
		return rooms;
	}

	public void setRooms(List<Room> rooms)
	{
		this.rooms = rooms;
	}

	public List<Electrician> getElectricians()
	{
		return electricians;
	}

	public void setElectricians(List<Electrician> electricians)
	{
		this.electricians = electricians;
	}
}