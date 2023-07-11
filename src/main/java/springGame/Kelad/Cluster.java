package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cluster {
    private String name;
    private List<Cell> cells;
    private int size; // In square meters

    private ClimateType climateType;

    public Cluster(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Building: " + name + " Size: " + size + "m^2\n" + cells.stream().map(Cell::toString).collect(Collectors.joining());
    }

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public static Cluster generateRandom(SubRegion subRegion) {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(50, 500); // random size between 50 and 500 m^2
        int cellCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of cells between 1 and 5

        Cluster cluster = new Cluster(name, size);

        List<Cell> cells = IntStream.range(0, cellCount).mapToObj(i -> Cell.generateRandom(cluster)).collect(Collectors.toList());
        cluster.setCells(cells);
        cluster.setClimateType(subRegion.getClimateType());
        return cluster;
    }
}


