package Persons;

import Enums.Faiths;
import Enums.LifeStatus;
import Enums.Mood;
import Enums.SleepStatus;
import Places.Place;

import java.util.Objects;

public abstract class Person {
    private String name;
    private Place place;
    private LifeStatus lifeStatus = LifeStatus.Alive;
    private SleepStatus sleepStatus = SleepStatus.WokenUp;
    private Faiths faith = Faiths.None;
    private Mood mood = Mood.Good;

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPlace(Place place) {this.place = place;}
    public Place getPlace() {return place;}

    public void setLifeStatus(LifeStatus lifeStatus) {
        this.lifeStatus = lifeStatus;
    }
    public LifeStatus getLifeStatus(){
        return this.lifeStatus;
    }

    public void setFaith(Faiths faith) {
        this.faith = faith;
    }
    public Faiths getFaith() {
        return faith;
    }

    public void setSleepStatus(SleepStatus sleepStatus) {
        this.sleepStatus = sleepStatus;
    }
    public SleepStatus getSleepStatus() {
        return sleepStatus;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
    public Mood getMood() {
        return mood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(place, person.place) && lifeStatus == person.lifeStatus && sleepStatus == person.sleepStatus && faith == person.faith && Objects.equals(mood, person.mood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, lifeStatus, sleepStatus, faith, mood);
    }

    @Override
    public String toString() {
        return this.getClass() +
                "[name='" + name + '\'' +
                ", place=" + place +
                ", lifeStatus=" + lifeStatus +
                ", sleepStatus=" + sleepStatus +
                ", faith=" + faith +
                ", mood=" + mood +

                ']';
    }
}

