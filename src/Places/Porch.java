package Places;

import Persons.Person;
import Places.House;

public class Porch extends House{
    public Porch(){
        super.setName("Крыльцо");
    }
    public void goToPorch(Person... people){
        for(Person g: people){
            guests.add(g);
            g.setPlace(this);
            System.out.println(g.getName() + " has come to the " + this.getName());
        }
    }
}
