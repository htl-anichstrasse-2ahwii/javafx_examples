package application.binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class MyStringProperty extends SimpleStringProperty
{
	Object parent;
	public MyStringProperty(Object parent)
	{
		super();
		this.parent = parent;
	}

	@Override
	public Object getBean() {
		return parent;
	}
	
}

public class Person {
	  private final StringProperty name = new MyStringProperty(this); 
	  private final IntegerProperty age = new SimpleIntegerProperty(); 
	  public StringProperty nameProperty() { return name; } 
	  public final String getName() { return name.get(); } 
	  public final void setName( String name ) { this.name.set( name ); } 
	  public IntegerProperty ageProperty() { return age; } 
	  public final int getAge() { return age.get(); } 
	  public final void setAge( int age ) { this.age.set( age ); } 

}
