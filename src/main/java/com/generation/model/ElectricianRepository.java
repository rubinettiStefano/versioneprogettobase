package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ElectricianRepository
{
	//SINGLETON
	private static ElectricianRepository instance;
	public static ElectricianRepository getInstance()
	{
		if(instance == null)
			instance = new ElectricianRepository();
		return instance;
	}
	private ElectricianRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<Electrician> findAllElectricians()
	{
		return em.createQuery("select u from Electrician u", Electrician.class).getResultList();
	}

	public Electrician findElectrician(int id)
	{
		return em.find(Electrician.class, id);
	}

	public void insertElectrician(Electrician electrician)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(electrician);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyElectrician(Electrician electrician)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(electrician);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		Electrician toDelete = findElectrician(id);//prima prendiamo lo electrician con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("Electrician not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
