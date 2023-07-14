package springGame.Kelad;
import Climate.ClimateType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubRegion {
    private String name;
    private List<Cluster> clusters;
    private int size; // In square kilometers
    private ClimateType climateType;

    public ClimateType getClimateType() {
        return climateType;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public SubRegion(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SubRegion: " + name + " Size: " + size + "km^2\n" + clusters.stream().map(Cluster::toString).collect(Collectors.joining());
    }

    public static SubRegion generateRandom(Region region) {
        String name = NameGenerator.generateRandomName();
//        int size = ThreadLocalRandom.current().nextInt(10, 500); // random size between 10 and 500 km^2
        int size = 0;
        int clusterCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of clusters between 1 and 5

        SubRegion subRegion = new SubRegion(name, size);
        subRegion.setClimateType(region.getClimateType());

        List<Cluster> clusters = IntStream.range(0, clusterCount).mapToObj(i -> Cluster.generateRandom(subRegion)).collect(Collectors.toList());

        for (int i = 0; i < clusterCount; i++) {
            size += clusters.get(i).getSize();
        }
        subRegion.setSize(size);
        subRegion.setClusters(clusters);

        return subRegion;
    }
}

