package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RoomRepository
{
	//SINGLETON
	private static RoomRepository instance;
	public static RoomRepository getInstance()
	{
		if(instance == null)
			instance = new RoomRepository();
		return instance;
	}
	private RoomRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<Room> findAllRooms()
	{
		return em.createQuery("select u from Room u", Room.class).getResultList();
	}

	public Room findRoom(int id)
	{
		return em.find(Room.class, id);
	}

	public void insertRoom(Room room)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(room);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyRoom(Room room)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(room);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		Room toDelete = findRoom(id);//prima prendiamo lo room con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("Room not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
