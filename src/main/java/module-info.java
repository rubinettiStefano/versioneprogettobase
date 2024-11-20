module com.generation.jpafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires jakarta.persistence;
	requires org.hibernate.orm.core;

	opens com.generation to javafx.fxml, org.hibernate.orm.core;
	exports com.generation;
	exports com.generation.model;
	opens com.generation.model to javafx.fxml, org.hibernate.orm.core;
	opens com.generation.controller to javafx.fxml, org.hibernate.orm.core;
}
