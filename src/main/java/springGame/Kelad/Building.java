package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Building {
    private String name;
    private List<Room> rooms;
    private int size; // In square meters

    public Building(String name, List<Room> rooms, int size) {
        this.name = name;
        this.rooms = rooms;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Building: " + name + " Size: " + size + "m^2\n" + rooms.stream().map(Room::toString).collect(Collectors.joining());
    }

    public static Building generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(50, 500); // random size between 50 and 500 m^2
        int roomCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of rooms between 1 and 5
        List<Room> rooms = IntStream.range(0, roomCount).mapToObj(i -> Room.generateRandom()).collect(Collectors.toList());
        return new Building(name, rooms, size);
    }
}


