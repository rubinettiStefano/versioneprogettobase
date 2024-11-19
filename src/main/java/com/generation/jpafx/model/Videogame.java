package com.generation.jpafx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "videogame", schema = "gamecrash")
public class Videogame
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "genre", length = 50)
	private String genre;

	@Column(name = "platforms", length = 100)
	private String platforms;

	@Column(name = "price")
	private Double price;

	@Column(name = "copies_sold")
	private Integer copiesSold;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getPlatforms()
	{
		return platforms;
	}

	public void setPlatforms(String platforms)
	{
		this.platforms = platforms;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getCopiesSold()
	{
		return copiesSold;
	}

	public void setCopiesSold(Integer copiesSold)
	{
		this.copiesSold = copiesSold;
	}

}