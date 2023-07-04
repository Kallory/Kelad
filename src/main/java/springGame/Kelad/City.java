package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class City {
    private String name;
    private List<MegaRegion> megaRegions;
    private int size; // In square kilometers

    public City(String name, List<MegaRegion> megaRegions, int size) {
        this.name = name;
        this.megaRegions = megaRegions;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MegaRegion> getMegaRegions() {
        return megaRegions;
    }

    public void setMegaRegions(List<MegaRegion> megaRegions) {
        this.megaRegions = megaRegions;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "City: " + name + " Size: " + size + "km^2\n" + megaRegions.stream().map(MegaRegion::toString).collect(Collectors.joining());
    }

    public static City generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(1000, 10000); // random size between 1000 and 10000 km^2
        int megaRegionCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of mega regions between 1 and 5
        List<MegaRegion> megaRegions = IntStream.range(0, megaRegionCount).mapToObj(i -> MegaRegion.generateRandom()).collect(Collectors.toList());
        return new City(name, megaRegions, size);
    }
}

