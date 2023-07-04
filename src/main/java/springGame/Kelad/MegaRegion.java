package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MegaRegion {
    private String name;
    private List<SubRegion> subRegions;
    private int size; // In square kilometers

    public MegaRegion(String name, List<SubRegion> subRegions, int size) {
        this.name = name;
        this.subRegions = subRegions;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubRegion> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(List<SubRegion> subRegions) {
        this.subRegions = subRegions;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MegaRegion: " + name + " Size: " + size + "km^2\n" + subRegions.stream().map(SubRegion::toString).collect(Collectors.joining());
    }

    public static MegaRegion generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(500, 5000); // random size between 500 and 5000 km^2
        int subRegionCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of sub regions between 1 and 5
        List<SubRegion> subRegions = IntStream.range(0, subRegionCount).mapToObj(i -> SubRegion.generateRandom()).collect(Collectors.toList());
        return new MegaRegion(name, subRegions, size);
    }
}


