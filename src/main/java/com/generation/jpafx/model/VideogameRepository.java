package com.generation.jpafx.model;

import com.generation.jpafx.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VideogameRepository
{
	private static VideogameRepository instance;
	public static VideogameRepository getInstance()
	{
		if (instance == null)
			instance = new VideogameRepository();
		return instance;
	}
	private VideogameRepository(){}

	private EntityManager em= HibernateHelper.getEntityManager();

	public List<Videogame> findAllVideogames()
	{
		List<Videogame> videogames = em.createQuery("from Videogame", Videogame.class).getResultList();
		return videogames;
	}
}
