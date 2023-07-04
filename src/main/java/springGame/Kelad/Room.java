package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// Room.java
public class Room {
    private String name;
    private List<PartOfRoom> partsOfRoom;
    private int size; // In square meters

    public Room(String name, List<PartOfRoom> partsOfRoom, int size) {
        this.name = name;
        this.partsOfRoom = partsOfRoom;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Room: " + name + " Size: " + size + "m^2\n" + partsOfRoom.stream().map(PartOfRoom::toString).collect(Collectors.joining());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PartOfRoom> getPartsOfRoom() {
        return partsOfRoom;
    }

    public void setPartsOfRoom(List<PartOfRoom> partsOfRoom) {
        this.partsOfRoom = partsOfRoom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Room generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(10, 50); // random size between 10 and 50 m^2
        int partOfRoomCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of part of rooms between 1 and 5
        List<PartOfRoom> partOfRooms = IntStream.range(0, partOfRoomCount).mapToObj(i -> PartOfRoom.generateRandom()).collect(Collectors.toList());
        return new Room(name, partOfRooms, size);
    }
}

