package application.binding;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;

public class BindingsMain {

	public static void main(String[] args) {
		Person chris = new Person(); 
		chris.setName( "Chris" ); 
		chris.setAge( 102 ); 
		InvalidationListener invalidationListener = 
		    observable -> System.out.println( "Änderung am " + observable ); 
		chris.nameProperty().addListener( invalidationListener ); 
		chris.ageProperty().addListener( invalidationListener ); 
		ChangeListener<String> changeListener = 
		    (observable, oldValue, newValue) -> 
		{
			SimpleStringProperty p = (SimpleStringProperty)observable;
			Object o = p.getBean();
			System.out.println(o.getClass());
			Person person = (Person)o;
			System.out.println("GET AGE FROM PERSON:" + person.getAge());
			System.out.printf( "%s -> %s%n",     oldValue, newValue ); 
		};
		chris.nameProperty().addListener( changeListener ); 
		chris.setName( "Cora" ); 
		chris.setAge( 52 );
	}

}
