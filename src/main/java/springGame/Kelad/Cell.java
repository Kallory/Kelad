package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// Room.java
public class Cell {
    private String name;
    private List<Tile> tiles;
    private int size; // In square meters
    private ClimateType climateType;

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public Cell(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Room: " + name + " Size: " + size + "m^2\n" + tiles.stream().map(Tile::toString).collect(Collectors.joining());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Cell generateRandom(Cluster cluster) {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(10, 50); // random size between 10 and 50 m^2
        int tileCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of part of rooms between 1 and 5

        Cell cell = new Cell(name, size);

        List<Tile> tiles = IntStream.range(0, tileCount).mapToObj(i -> Tile.generateRandom(cell)).collect(Collectors.toList());
        cell.setTiles(tiles);
        cell.setClimateType(cluster.getClimateType());
        return new Cell(name, size);
    }
}

