package springGame.Kelad;

// PartOfRoom.java
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartOfRoom {
    private String name;
    private List<Person> characters; // holds up to 2 characters
    private List<Item> items; // holds up to 4 average-sized items
    private int size; // fixed size

    public PartOfRoom(String name, List<Person> characters, List<Item> items, int size) {
        this.name = name;
        this.characters = characters;
        this.items = items;
        this.size = size;
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

    @Override
    public String toString() {
        return "PartOfRoom: " + name + " Size: " + size + "ft^2\n" +
                "Characters: " + characters.stream().map(Person::toString).collect(Collectors.joining(", ")) +
                "\nItems: " + items.stream().map(Item::toString).collect(Collectors.joining(", ")) + "\n";
    }

    public static PartOfRoom generateRandom() {
        String name = NameGenerator.generateRandomName();
        int size = 10; // fixed size in square feet

        int characterCount = ThreadLocalRandom.current().nextInt(0, 3); // random number of characters between 0 and 2
        List<Person> characters = IntStream.range(0, characterCount).mapToObj(i -> Person.generateRandom()).collect(Collectors.toList());

        int itemCount = ThreadLocalRandom.current().nextInt(0, 5); // random number of items between 0 and 4
        List<Item> items = IntStream.range(0, itemCount).mapToObj(i -> Item.generateRandom()).collect(Collectors.toList());

        return new PartOfRoom(name, characters, items, size);
    }
}

