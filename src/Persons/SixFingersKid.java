package Persons;

import Enums.LifeStatus;
import Interfaces.Burable;
import Interfaces.Deathable;
import Interfaces.Healable;
import Places.Place;
import Places.Grave;

public class SixFingersKid extends Person implements Deathable, Burable {
    public SixFingersKid(){
        super.setName("шестипалый младенец");
        super.setLifeStatus(LifeStatus.Alive);
    }

    @Override
    public void bury(Place place) {
        System.out.println(this.getName() + " was buried at " + place.getName());
        this.setPlace(place);
    }

    @Override
    public void die() {
        System.out.println(this.getName() + " has died.");
        this.setLifeStatus(LifeStatus.Dead);
    }

    @Override
    public void dieOrGetHelp(Healable iHealable) {
        System.out.println("No one could help...");
    }

    @Override
    public void getBuried(Grave grave, Person person){
        System.out.println(person.getName() + " похоронили в " + grave.getName());
    }
}
