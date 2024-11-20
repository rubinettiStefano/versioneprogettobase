package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HouseRepository
{
	//SINGLETON
	private static HouseRepository instance;
	public static HouseRepository getInstance()
	{
		if(instance == null)
			instance = new HouseRepository();
		return instance;
	}
	private HouseRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<House> findAllHouses()
	{
		return em.createQuery("select u from House u", House.class).getResultList();
	}

	public House findHouse(int id)
	{
		return em.find(House.class, id);
	}

	public void insertHouse(House house)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(house);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyHouse(House house)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(house);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		House toDelete = findHouse(id);//prima prendiamo lo house con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("House not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
