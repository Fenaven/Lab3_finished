package Interfaces;

import Persons.Person;
import Stuff.SomeAction;

public interface Noticable {
    void notice(SomeAction someAction);
    void notice();
    void seeSomeone(Person person);
}
