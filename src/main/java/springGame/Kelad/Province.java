package springGame.Kelad;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Province {
    private String name;
    private List<City> cities;
    private int size; // In square kilometers

    public Province(String name, List<City> cities, int size) {
        this.name = name;
        this.cities = cities;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Province: " + name + " Size: " + size + "km^2\n" + cities.stream().map(City::toString).collect(Collectors.joining());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Province generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = ThreadLocalRandom.current().nextInt(10000, 100000); // random size between 10000 and 100000 km^2
        int cityCount = ThreadLocalRandom.current().nextInt(1, 6); // random number of cities between 1 and 5
        List<City> cities = IntStream.range(0, cityCount).mapToObj(i -> City.generateRandom()).collect(Collectors.toList());
        return new Province(name, cities, size);
    }
}

