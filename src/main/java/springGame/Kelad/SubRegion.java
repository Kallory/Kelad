package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubRegion {
    private String name;
    private List<Building> buildings;
    private int size; // In square kilometers

    public SubRegion(String name, List<Building> buildings, int size) {
        this.name = name;
        this.buildings = buildings;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SubRegion: " + name + " Size: " + size + "km^2\n" + buildings.stream().map(Building::toString).collect(Collectors.joining());
    }

    public static SubRegion generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(10, 500); // random size between 10 and 500 km^2
        int buildingCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of buildings between 1 and 5
        List<Building> buildings = IntStream.range(0, buildingCount).mapToObj(i -> Building.generateRandom()).collect(Collectors.toList());
        return new SubRegion(name, buildings, size);
    }
}

