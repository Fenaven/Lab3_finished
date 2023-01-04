package Interfaces;

import Enums.SpeechStyle;
import Persons.Person;

public interface Speakable {
    void speak(SpeechStyle speechStyle);
    void speakAboutSomeone(SpeechStyle speechStyle, Person person);
}
