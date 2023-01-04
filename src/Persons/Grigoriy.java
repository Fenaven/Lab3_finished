package Persons;

import Enums.*;

import Exceptions.*;
import Interfaces.*;
import Interfaces.Readable;
import Places.Place;
import Stuff.SomeAction;

import java.util.ArrayList;

public class Grigoriy extends Person implements Readable, Believable, Movable, Noticable, Dressable, Takeable, Sleepable, Healable {
    public Grigoriy(){
        super.setName("Григорий Васильевич");
    }


    ArrayList<Books> readBooks = new ArrayList<Books>();
    ArrayList<Stuff> inventory = new ArrayList<Stuff>();
    @Override
    public void read(Books books) {
        System.out.println(this.getName() + " читал " + books.name());
        readBooks.add(books);
    }

    @Override
    public void readManyBooks(Books... books){
        for(Books b:books){
            readBooks.add(b);
            System.out.println(this.getName() + " читал " + b.name());
        }
    }

    @Override
    public void believe(Faiths faith) {
        System.out.println(this.getName() + " уверовал в " + faith.name());
        this.setFaith(faith);
    }


    @Override
    public void move(Place place) {
        System.out.println(this.getName() + " пошел в/ на " + place.getName());
    }

    @Override
    public void moveSomewhere(Place... places) {
        try {
            Place placeToGo;
            if (1 - Math.random() < 0.3) {
                placeToGo = places[0];
            }
            else {
                placeToGo = places[1];
            }
            if (placeToGo.hashCode() == places[0].hashCode()) {
                System.out.println(this.getName() + " пошел в " + placeToGo.getName());
            } else {
                throw new UncheckedMoveException(this.getName() + " захотел пойти в " + placeToGo.getName());
            }
        }
        catch (UncheckedMoveException ex){
            System.out.println(this.getName() + " пришёл в " + places[1].getName() + " но понял, что перепутал, и пошёл обратно");
            this.move(places[0]);
        }
    }

    @Override
    public void notice(SomeAction someAction) {
        System.out.println(this.getName() + " заметил " + someAction.getActionName());
    }
    @Override
    public void notice() {}

    @Override
    public void seeSomeone(Person person) {
        System.out.println(this.getName() + " увидал " + person.getName());

    }

    @Override
    public void getDressed() {
        System.out.println(this.getName() + " оделся");
    }

    @Override
    public void getUp() {
        System.out.println(this.getName() + " поднялся");
    }

    public void putOn(Stuff stuff) {
        inventory.add(stuff);
        System.out.println(this.getName() + " каждый раз надевал " + stuff.name());
    }


    @Override
    public void take(Stuff stuff) {
        inventory.add(stuff);
        System.out.println(this.getName() + " взял " + stuff.name());
    }

    public void takeManyThings(Stuff... staffs){
        for(Stuff g: staffs){
            inventory.add(g);
            System.out.println(this.getName() + " взял " + g.name());
        }
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + " уснул");
        this.setSleepStatus(SleepStatus.Sleeping);
    }

    @Override
    public void heal(Person person) {
        person.setLifeStatus(LifeStatus.Alive);
        System.out.println(this.getName() + " помог " + person.getName());
    }
}
