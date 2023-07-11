package springGame.Kelad;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Domain {
    private String name;
    private List<Division> divisions;
    private int size; // In square kilometers

    public Domain(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Domain: " + name + " Size: " + size + "km^2\n" + divisions.stream().map(Division::toString).collect(Collectors.joining());
    }

    public static Domain generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(100000, 1000000); // random size between 100000 and 1000000 km^2
        int divisionCount = ThreadLocalRandom.current().nextInt(1, 11); // random number of divisions between 1 and 10
        List<Division> divisions = IntStream.range(0, divisionCount).mapToObj(i -> Division.generateRandom()).collect(Collectors.toList());
        Domain domain = new Domain(name, size);
        domain.setDivisions(divisions);
        return domain;
    }
}

