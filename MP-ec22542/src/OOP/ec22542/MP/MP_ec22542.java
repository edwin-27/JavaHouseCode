package OOP.ec22542.MP;

import java.util.*;

public class MP_ec22542 {

    public static void main(String[] args) {

        House_ec22542 house_ec22542 = new House_ec22542();

        HashMap<String, RoomMaster> rooms = new HashMap<>();
        RoomMaster oroomMaster = new RoomMaster();
        oroomMaster.setRoom(new Room_ec22542());
        oroomMaster.setGoldPoints(6);


        oroomMaster.setItems(new ArrayList<>(Arrays.asList("Candle","Torch")));
        oroomMaster.setName("Scarlet");
        rooms.put(oroomMaster.getName(), oroomMaster);
        oroomMaster = null;

        oroomMaster = new RoomMaster();
        oroomMaster.setRoom(new Room_ec22542());
        oroomMaster.setGoldPoints(3);


        oroomMaster.setItems(new ArrayList<>(Arrays.asList("Crossbow","Key")));
        oroomMaster.setName("Sapphire");
        rooms.put(oroomMaster.getName(), oroomMaster);
        oroomMaster = null;

        oroomMaster = new RoomMaster();
        oroomMaster.setRoom(new Room_ec22542());
        oroomMaster.setGoldPoints(1);


        oroomMaster.setItems(new ArrayList<>(Arrays.asList("Knife","Apple")));
        oroomMaster.setName("Emerald");
        rooms.put(oroomMaster.getName(), oroomMaster);
        oroomMaster = null;

        oroomMaster = new RoomMaster();
        oroomMaster.setRoom(new Room_ec22542());
        oroomMaster.setGoldPoints(2);


        oroomMaster.setItems(new ArrayList<>(Arrays.asList("Rope", "Matchstick")));
        oroomMaster.setName("Ruby");
        rooms.put(oroomMaster.getName(), oroomMaster);
        oroomMaster = null;


        System.out.println("Here is a list of 4 rooms in this house");

        house_ec22542.rooms = rooms;

        int i=1;

        for (Map.Entry<String,RoomMaster> entry :house_ec22542.rooms.entrySet() ){
            String key = entry.getKey();
//            RoomMaster value = entry.getValue();

            System.out.println(i + " "+entry.getValue().getName());
            i++;

        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a number between 1 to 4");
        Integer useroption = scanner.nextInt();
        Object firstKey = house_ec22542.rooms.keySet().toArray()[useroption-1];










        Visitable ovisitable = new Room_ec22542(house_ec22542.rooms.get(firstKey));
        Visitor ovisitor = new GUIVisitor_ec22542(System.out, System.in);
        ovisitable.visit(ovisitor,Direction.FROM_NORTH);



    }
}
