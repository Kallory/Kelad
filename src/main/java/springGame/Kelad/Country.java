package springGame.Kelad;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Country {
    private String name;
    private List<Province> provinces;
    private int size; // In square kilometers

    public Country(String name, List<Province> provinces, int size) {
        this.name = name;
        this.provinces = provinces;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Country: " + name + " Size: " + size + "km^2\n" + provinces.stream().map(Province::toString).collect(Collectors.joining());
    }

    public static Country generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(100000, 1000000); // random size between 100000 and 1000000 km^2
        int provinceCount = ThreadLocalRandom.current().nextInt(1, 11); // random number of provinces between 1 and 10
        List<Province> provinces = IntStream.range(0, provinceCount).mapToObj(i -> Province.generateRandom()).collect(Collectors.toList());
        return new Country(name, provinces, size);
    }
}

