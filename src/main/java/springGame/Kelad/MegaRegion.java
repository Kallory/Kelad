package springGame.Kelad;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MegaRegion {
    private String name;
    private List<Zone> zones;
    private int size; // In square kilometers
    private ClimateType climateType;

    public MegaRegion(String name, int size, ClimateType climateType) {
        this.name = name;
        this.size = size;
        this.climateType = climateType;
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
        int size = ThreadLocalRandom.current().nextInt(500, 5000); // random size between 500 and 5000 km^2
        int zoneCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of sub-regions between 1 and 5

        ClimateType[] climateTypes = ClimateType.values();
        ClimateType climateType1 = climateTypes[ThreadLocalRandom.current().nextInt(climateTypes.length)];
        MegaRegion megaRegion = new MegaRegion(name, size, climateType1);

        List<Zone> zones = IntStream.range(0, zoneCount).mapToObj(i -> Zone.generateRandom(megaRegion)).collect(Collectors.toList());
        megaRegion.setZones(zones);

        return megaRegion;
    }
}


