package Places;

import Persons.Person;

import java.util.ArrayList;

public class Grave extends Place{
    public Grave(){
        super.setName("могилка");
    }
    public Grave(Person person){
        super.setName("могилка " + person.getName());
    }

    ArrayList<Person> visitors = new ArrayList<Person>();

    public void visitGrave(Person... people){
        for(Person g: people){
            visitors.add(g);
            System.out.println(g.getName() + " has come to the " + this.getName());
        }
    }


}
