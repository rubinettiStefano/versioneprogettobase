package com.generation;

import com.generation.model.Electrician;
import com.generation.model.ElectricianRepository;
import com.generation.model.House;
import com.generation.model.HouseRepository;

public class Prove
{
	public static void main(String[] args)
	{
		HouseRepository houseRepository = HouseRepository.getInstance();
		ElectricianRepository eRepository = ElectricianRepository.getInstance();

		House h = houseRepository.findHouse(1);

		Electrician e = eRepository.findElectrician(2);

		h.getElectricians().add(e);

		houseRepository.modifyHouse(h);
	}
}
