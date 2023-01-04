import Enums.*;
import Exceptions.CheckedTimeException;
import Persons.*;
import Places.*;
import Stuff.SomeAction;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static class TimeResolver {
        public static String resolve(LocalTime localtime) {
            enum DayTime {
                morning,
                day,
                evening,
                night
            }


            switch (localtime.getHour()) {
                case 17, 18, 19, 20, 21, 22 -> {
                    return DayTime.evening.name();
                }
                case 23, 0, 1, 2, 3, 4, 5 -> {
                    return DayTime.night.name();
                }
                case 6, 7, 8, 9, 10, 11 -> {
                    return DayTime.morning.name();
                }
                default -> {
                    return DayTime.day.name();
                }
            }
        }
    }

    public static void main(String[] args) throws CheckedTimeException {
        Grigoriy grigorik = new Grigoriy();
        Lizabeth lizun = new Lizabeth();
        Marpha marpha = new Marpha();
        SixFingersKid sixFingersKid = new SixFingersKid();
        UnknownBaby unknownBaby = new UnknownBaby();
        SomeAction crying = new SomeAction();
        crying.setActionName("плач");

        Garden garden = new Garden("Садик");
        BathHouse bathHouse = new BathHouse();
        House house = new House();
        Porch porch = new Porch();

        ArrayList<Faiths> faithsList = new ArrayList<Faiths>(){{
            add(Faiths.Chrisrianity);
            add(Faiths.Buddism);
            add(Faiths.Islamism);
        }};


        marpha.speakAboutSomeone(SpeechStyle.silently, sixFingersKid);
        sixFingersKid.die();
        Grave kidGrave = new Grave(sixFingersKid);
        sixFingersKid.getBuried(kidGrave, sixFingersKid);
        marpha.notice();
        grigorik.believe(Faiths.Divine);

        grigorik.putOn(Stuff.SilverRoundGlasses);
        grigorik.read(Books.ChetiiMenii);


        grigorik.readManyBooks(Books.IovasBook, Books.IsaacSirinList);
        grigorik.believe(Faiths.Mysticism);
        grigorik.believe(faithsList.get(ThreadLocalRandom.current().nextInt(0, faithsList.size())));
        LocalTime localTime = LocalTime.now();
        try {
            String partOfDay = Main.TimeResolver.resolve(localTime);
            if (partOfDay.equals("morning") || partOfDay.equals("day")) {
                throw new CheckedTimeException("Эх, еще светло...");
            }
        } catch (CheckedTimeException exception) {
            System.out.println("Подождем, пока сядет солнце.");
            try {
                Thread.sleep(2000);
            } catch (Exception exception1) {
                exception1.initCause(exception);
                var e = new CheckedTimeException("Кто поломал время?");
                e.initCause(exception1);
                throw e;
            }
        }
        grigorik.sleep();
        marpha.wakeUp();
        marpha.hearSmthStrange(crying, Mood.Frightened);
        marpha.wake(grigorik);
        grigorik.getUp();
        grigorik.getDressed();
        grigorik.move(porch);
        grigorik.notice(crying);
        grigorik.move(garden);
        grigorik.takeManyThings(Stuff.Flashlight, Stuff.GardenKey);
        grigorik.moveSomewhere(bathHouse, house);
        grigorik.seeSomeone(lizun);
        lizun.born(unknownBaby, bathHouse);
        lizun.dieOrGetHelp(grigorik);
    }
}
