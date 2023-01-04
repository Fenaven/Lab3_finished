package Places;

import Persons.Person;

import java.util.ArrayList;

public class BathHouse extends Garden{
    public BathHouse(){
        super.setName("Банька");
    }
    public BathHouse(String name){
        super.setName(name);
    }

    public void visitHBathingHouse(Person... people){
        for(Person g: people){
            gardenVisitors.add(g);
            g.setPlace(this);
            System.out.println(g.getName() + " has come to the " + this.getName());
        }
    }


}