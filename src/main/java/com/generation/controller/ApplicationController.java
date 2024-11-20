package com.generation.controller;

import com.generation.helpers.ControllerHelper;
import com.generation.model.House;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ApplicationController
{
	@FXML
	public TextField address,smp,area,type,house_id;
	@FXML
	public Text listaCase;

	private ControllerHelper helper = ControllerHelper.getInstance();

	public void refresh()
	{
		listaCase.setText(helper.produciListaCase());
	}

	public void insert()
	{
		String address = this.address.getText();
		double smp = Double.parseDouble(this.smp.getText());
//		v1
//		House house = new House();
//		house.setAddress(address);
//		house.setSmp(smp);
//
//		helper.insertHouse(house);

		//v2
		helper.insertHouse(address,smp);
		this.address.clear();
		this.smp.clear();
		refresh();
	}

	public void insertRoom()
	{
		String type = this.type.getText();
		double area = Double.parseDouble(this.area.getText());
		int house_id = Integer.parseInt(this.house_id.getText());

		helper.insertRoom(type,area,house_id);
		this.type.clear();
		this.area.clear();
		this.house_id.clear();
		refresh();
	}
}
