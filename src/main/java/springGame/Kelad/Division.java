package springGame.Kelad;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Division {
    private String name;
    private List<MegaRegion> megaRegions;
    private int size; // In square kilometers

    public Division(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Division: " + name + " Size: " + size + "km^2\n" + megaRegions.stream().map(MegaRegion::toString).collect(Collectors.joining());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MegaRegion> getmegaRegions() {
        return megaRegions;
    }

    public void setmegaRegions(List<MegaRegion> megaRegions) {
        this.megaRegions = megaRegions;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Division generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(10000, 100000); // random size between 10000 and 100000 km^2
        int megaRegionCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of megaRegions between 1 and 5
        List<MegaRegion> megaRegions = IntStream.range(0, megaRegionCount).mapToObj(i -> MegaRegion.generateRandom()).collect(Collectors.toList());

        Division division = new Division(name, size);
        division.setmegaRegions(megaRegions);
        return division;
    }
}

