package springGame.Kelad;

import Climate.ClimateType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Region {
    private String name;
    private List<SubRegion> subRegions;
    private int size; // In square kilometers
    private ClimateType climateType;

    public Region(String name, int size) {
        this.name = name;
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

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Region(): " + name + " Size: " + size + "km^2\n" + subRegions.stream().map(SubRegion::toString).collect(Collectors.joining());
    }

    public static Region generateRandom(Zone zone) {
        String name = NameGenerator.generateRandomName();
//        int size = ThreadLocalRandom.current().nextInt(500, 5000); // random size between 500 and 5000 km^2
        int size = 0;
        int subRegionCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of sub-regions between 1 and 5

        Region region = new Region(name, size);
        region.setClimateType(zone.getClimateType());

        List<SubRegion> subRegions = IntStream.range(0, subRegionCount).mapToObj(i -> SubRegion.generateRandom(region)).collect(Collectors.toList());
        region.setSubRegions(subRegions);
        for (int i = 0; i < subRegionCount; i++) {
            size += subRegions.get(i).getSize();
        }
        region.setSize(size);
        return region;
    }
}



