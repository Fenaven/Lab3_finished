package Interfaces;

import Places.Place;

public interface Movable {
    void move(Place place);
    void getUp();

    void moveSomewhere(Place... places);
}
