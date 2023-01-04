package Places;

import Enums.Stuff;
import Persons.Person;

import java.util.ArrayList;

public class House extends Place{



    public House(){
        super.setName("дом");
    }

    public House(String name){
        super.setName(name);
    }


    ArrayList<Person> guests = new ArrayList<Person>();

    public void visitHouse(Person... people){
        for(Person g: people){
            guests.add(g);
            System.out.println(g.getName() + " has come to the " + this.getName());
        }
    }


}
