package springGame.Kelad;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zone {
    private String name;
    private List<Region> regions;
    private int size; // In square kilometers
    private ClimateType climateType;

    public Zone(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    @Override
    public String toString() {
        return "Zone: " + name + " Size: " + size + "km^2\n" + regions.stream().map(Region::toString).collect(Collectors.joining());
    }

    public static Zone generateRandom(MegaRegion megaRegion) {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(1000, 10000); // random size between 1000 and 10000 km^2
        int regionCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of mega regions between 1 and 5


        Zone zone = new Zone(name, size);

        List<Region> regions = IntStream.range(0, regionCount).mapToObj(i -> Region.generateRandom(zone)).collect(Collectors.toList());
        zone.setRegions(regions);
        zone.setClimateType(megaRegion.getClimateType());
        return zone;
    }
}

