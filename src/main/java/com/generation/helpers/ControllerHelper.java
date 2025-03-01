package com.generation.helpers;

import com.generation.model.House;
import com.generation.model.HouseRepository;
import com.generation.model.Room;
import com.generation.model.RoomRepository;

import java.util.List;

public class ControllerHelper
{

	private static ControllerHelper instance;
	public static ControllerHelper getInstance()
	{
		if(instance == null)
			instance = new ControllerHelper();
		return instance;
	}
	private ControllerHelper(){}

	private HouseRepository hRepo = HouseRepository.getInstance();
	private RoomRepository rRepo = RoomRepository.getInstance();

	public void insertHouse(House house)
	{
		hRepo.insertHouse(house);
	}

	public void insertHouse(String address, double smp)
	{
		House house = new House();
		house.setAddress(address);
		house.setSmp(smp);
		hRepo.insertHouse(house);
	}

	public String produciListaCase()
	{
		List<House> all = hRepo.findAllHouses();

		String res = "";

		for(House house : all)
			res+=house.getId()+","+house.getAddress()+",price: "+house.calcPrice()+" euro\n";
		return res;
	}

	public void insertRoom(String type, double area, int houseId)
	{
		Room room = new Room();
		room.setType(type);
		room.setArea(area);
		House toConnect = hRepo.findHouse(houseId);
		room.setHouse(toConnect);
		rRepo.insertRoom(room);
	}
}
