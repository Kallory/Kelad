package springGame.Kelad;

// PartOfRoom.java
import Climate.ClimateType;
import Utility.StatisticsTracker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import Terrain.*;

public class Tile {
    private String name;
    private List<Person> characters; // holds up to 2 characters
    private List<Item> items; // holds up to 4 average-sized items
    private int size; // fixed size
    private ClimateType climateType;
    final public static int TILE_SIZE = 10; // cubic feetf

    private Terrain terrain;

    public ClimateType getClimateType() {
        return climateType;
    }

    public Tile(String name, List<Person> characters, List<Item> items, int size) {
        this.name = name;
        this.characters = characters;
        this.items = items;
        this.size = size;
    }

    public void setClimateType(ClimateType climateType) {
        this.climateType = climateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Person> characters) {
        this.characters = characters;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        return "Tile: " + name + " Size: " + size + "ft^2\n" +
                "Characters: " + characters.stream().map(Person::toString).collect(Collectors.joining(", ")) +
                "\nItems: " + items.stream().map(Item::toString).collect(Collectors.joining(", ")) + "\n";
    }

    public static Tile generateRandom(Cell cell) {
        String name = NameGenerator.generateRandomName();
        int size = TILE_SIZE;

        int characterCount = ThreadLocalRandom.current().nextInt(0, 3); // random number of characters between 0 and 2
        List<Person> characters = IntStream.range(0, characterCount).mapToObj(i -> Person.generateRandom()).collect(Collectors.toList());
        StatisticsTracker.population += characterCount;
        int itemCount = ThreadLocalRandom.current().nextInt(0, 5); // random number of items between 0 and 4
        List<Item> items = IntStream.range(0, itemCount).mapToObj(i -> Item.generateRandom()).collect(Collectors.toList());

        Tile tile = new Tile(name, characters, items, size);
        StatisticsTracker.tileCount++;
        tile.setClimateType(cell.getClimateType());
        tile.setTerrain(cell.getClimateType().generateTerrain());
       // System.out.println("Climate type: " + tile.getClimateType());
        return tile;
    }
}

