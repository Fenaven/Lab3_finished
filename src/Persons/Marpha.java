package Persons;

import Enums.Mood;
import Enums.SleepStatus;
import Enums.SpeechStyle;
import Interfaces.Hearable;
import Interfaces.Noticable;
import Interfaces.Speakable;
import Interfaces.Wakeable;
import Stuff.SomeAction;
import Places.Grave;

public class Marpha extends Person implements Speakable, Wakeable, Hearable, Noticable {
    public Marpha(){
        super.setName("Марфа Игнатьевна");
    }

    @Override
    public void notice() {
        Grave grave = new Grave();
        System.out.println("По замечанию " + this.getName() + " с той самой " + grave.getName());
    }

    public void notice(SomeAction someAction) {}

    public void seeSomeone(Person person) {}

    @Override
    public void speak(SpeechStyle speechStyle) {
        System.out.println(this.getName() + " говорила " + speechStyle.name());
    }

    @Override
    public void speakAboutSomeone(SpeechStyle speechStyle, Person person) {
        System.out.println(this.getName() + " говорила " + speechStyle.name() + " о " + person.getName());
    }

    @Override
    public void wake(Person person) {
        if (person.getSleepStatus() == SleepStatus.Sleeping) {
            System.out.println(this.getName() + " разбудила " + person.getName());
            person.setSleepStatus(SleepStatus.WokenUp);
        }
        else{
            //checked exception
            System.out.println("b");
        }
    }

    @Override
    public void wakeUp() {
        System.out.println(this.getName() + " проснулась");
    }

    @Override
    public void hear(SomeAction someAction) {
        System.out.println(this.getName() + " услышала " + someAction.getActionName());

    }

    public void hearSmthStrange(SomeAction someAction, Mood mood){
        System.out.println(this.getName() + " услышала " + someAction.getActionName());
        System.out.println(this.getName() + " сейчас " + mood.name());
        this.setMood(mood);
    }
}
