package com.generation.jpafx;

import com.generation.jpafx.model.Videogame;
import com.generation.jpafx.model.VideogameRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
	@FXML
	private Label welcomeText;

	private VideogameRepository repo  = VideogameRepository.getInstance();
	@FXML
	protected void onHelloButtonClick()
	{
		String res ="";

		for(Videogame v: repo.findAllVideogames())
			res+= v.getTitle()+"\n";


		welcomeText.setText(res);
	}
}