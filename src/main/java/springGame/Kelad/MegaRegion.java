package springGame.Kelad;
import Climate.ClimateType;
import Climate.TropicalWetClimate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MegaRegion {
    private String name;
    private List<Zone> zones;
    private int size; // In square kilometers
    private ClimateType climateType;

    public MegaRegion(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
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
        return "MegaRegion: " + name + " Size: " + size + "km^2\n" + zones.stream().map(Zone::toString).collect(Collectors.joining());
    }

    public static MegaRegion generateRandom() {
        String name = NameGenerator.generateRandomName();
//        int size = ThreadLocalRandom.current().nextInt(500, 5000); // random size between 500 and 5000 km^2
        int size = 0;
        int zoneCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of sub-regions between 1 and 5
//        ClimateType[] climateTypes = ClimateType.values();
//        ClimateType climateType = climateTypes[ThreadLocalRandom.current().nextInt(climateTypes.length)];
        ClimateType climateType = new TropicalWetClimate("Tropical Wet");
        MegaRegion megaRegion = new MegaRegion(name, size);
        megaRegion.setClimateType(climateType);

        List<Zone> zones = IntStream.range(0, zoneCount).mapToObj(i -> Zone.generateRandom(megaRegion)).collect(Collectors.toList());
        for (int i = 0; i < zoneCount; i++) {
            size += zones.get(i).getSize();
        }

        megaRegion.setSize(size);
        megaRegion.setZones(zones);
        System.out.println("Climate type: " + megaRegion.getClimateType());
        return megaRegion;
    }
}


