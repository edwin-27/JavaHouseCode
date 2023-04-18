package OOP.ec22542.MP;

import java.util.*;

public class RoomMaster  {

    private Room_ec22542 room;
    private  String name;
    private int goldPoints;
    public ArrayList<String> items;

//    public Room_ec22542 getRoom(Room_ec22542 room) {
//        return this.room;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoldPoints(int goldPoints) {
        this.goldPoints = goldPoints;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public void setRoom(Room_ec22542 room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public int getGoldPoints() {
        return goldPoints;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
