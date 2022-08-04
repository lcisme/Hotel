package com.company;

import java.util.ArrayList;

public interface IRoomsInterface {
    ArrayList<Rooms> list();
    void create(Rooms rooms);
    void update(Rooms rooms);
    void delete(Rooms rooms);

}
