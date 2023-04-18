package OOP.ec22542.MP;



class Room_ec22542 extends MyRoom{

    public Room_ec22542() {
    }

    public Room_ec22542(RoomMaster selectedRoom) {
        this.selectedRoom = selectedRoom;

    }

    @Override
    public Direction visit(Visitor ovisitor, Direction directionVisitorArrivesFrom){
        ovisitor.tell("The room you are in has 4 rooms");

         boolean leaveHouse = false;

         while(!leaveHouse) {
             char[] doorChoice = {'N', 'E', 'S', 'W'};
             char userDecision = ovisitor.getChoice("Which door do you want to choose, {N,E,S,W}", doorChoice);
             if (userDecision == 'N') {
                 ovisitor.giveGold(selectedRoom.getGoldPoints());
                 ovisitor.giveItem(new Item("Key"));
                 directionVisitorArrivesFrom = Direction.TO_NORTH;
             } else if (userDecision == 'E') {
                 ovisitor.takeGold(2);
                 ovisitor.giveItem(new Item("House Blueprint"));
                 directionVisitorArrivesFrom = Direction.TO_EAST;
             } else if (userDecision == 'S') {
                 ovisitor.giveGold(1);
                 ovisitor.giveItem(new Item("Telescope"));
                 directionVisitorArrivesFrom = Direction.TO_SOUTH;
             } else if (userDecision == 'W') {
                 ovisitor.giveGold(3);
                 ovisitor.giveItem(new Item("apple"));
                 directionVisitorArrivesFrom = Direction.TO_WEST;
             } else {


                 ovisitor.tell("Sorry, you did not choose a door to go through.");
                 ovisitor.takeGold(7);
                 ovisitor.giveItem(new Item("Lamp"));
             }
             char[] leaveChoice = {'y','n'};
             char userLeaveDecision = ovisitor.getChoice("Would you like to leave this room, {y,n}?", leaveChoice);
             if (userLeaveDecision == 'y'){
                 leaveHouse = true;
                 ovisitor.tell("You have chosen to leave this room");
                 ovisitor.takeGold(3);
                 ovisitor.giveItem(new Item("Crossbow"));
             }
             else{
                 ovisitor.tell("Thank you for staying");
                 ovisitor.giveGold(1);

             }
         }
         ovisitor.tell("Goodbye visitor");
         return directionVisitorArrivesFrom;



    }
}





