package Persons;

import Enums.LifeStatus;
import Enums.SpeechStyle;
import Exceptions.UncheckedDeathException;
import Interfaces.Deathable;
import Interfaces.Healable;
import Interfaces.Replicatable;
import Interfaces.Speakable;
import Places.Grave;
import Places.Place;

public class Lizabeth extends Person implements Replicatable, Deathable, Speakable {
    public Lizabeth(){
        super.setName("Лизавета Смердящая");
    }

    @Override
    public void born(Person person) {
        System.out.println(this.getName() + " родила " + person.getName());
    }
    public void born(Person person, Place place) {
        System.out.println(this.getName() + " родила " + person.getName() + " в " + place.getName());
        this.setPlace(place);
        person.setPlace(place);
    }



    @Override
    public void die() {
        System.out.println(this.getName() + " умерла.");
        this.setLifeStatus(LifeStatus.Dead);
    }

    @Override
    public void dieOrGetHelp(Healable iHealable) {
        System.out.println(this.getName() + " помирает");
        this.speak(SpeechStyle.nothing);
        this.setLifeStatus(LifeStatus.GoingToDie);
        try {
            if (1 - Math.random() < 0.5) {
                this.die();
                Grave LizkaGrave = new Grave(this);
                this.getBuried(LizkaGrave, this);
            } else {
                throw new UncheckedDeathException(this.getName() + " выжила.");
            }
        }
        catch (UncheckedDeathException ex){
            iHealable.heal(this);
            System.out.println(this.getName() + " была спасена и теперь выживет");
        }
    }

    @Override
    public void getBuried(Grave grave, Person person){
        System.out.println(person.getName() + " похоронили в " + grave.getName());
    }

    @Override
    public void speak(SpeechStyle speechStyle) {
        System.out.println(this.getName() + " не говорила " + speechStyle.name());
    }
    @Override
    public void speakAboutSomeone(SpeechStyle speechStyle, Person person){
        return;
    }
}
