package com.generation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "electrician")
public class Electrician
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;

	@ManyToMany
	@JoinTable(
			name = "electrician_to_house",//nome tabella associativa
			joinColumns = @JoinColumn(name = "electrician_id"),
			inverseJoinColumns = @JoinColumn(name = "house_id")
	)
	private List<House> houses = new ArrayList<House>();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}
}
