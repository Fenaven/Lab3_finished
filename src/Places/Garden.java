package Places;

import Persons.Person;

import java.util.ArrayList;

public class Garden extends Place{
    public Garden(){
        super.setName("Сад");
    }

    public Garden(String name){
        super.setName(name);
    }

    ArrayList<Person> gardenVisitors = new ArrayList<Person>();

    public void visitHouse(Person... people){
        for(Person g: people){
            gardenVisitors.add(g);
            g.setPlace(this);
            System.out.println(g.getName() + " has come to the " + this.getName());
        }
    }

}
