package Interfaces;

import Persons.Person;
import Places.Grave;

public interface Deathable {
    void die();
    void dieOrGetHelp(Healable healable);

    void getBuried(Grave grave, Person person);
}
