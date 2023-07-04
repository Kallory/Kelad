package springGame.Kelad;

import java.util.concurrent.ThreadLocalRandom;

// Item.java
public class Item {
    private String name;
    private ItemSize size;

    public Item(String name, ItemSize size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemSize getSize() {
        return size;
    }

    public void setSize(ItemSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Item: " + name + " Size: " + size;
    }

    public static Item generateRandom() {
        String name = NameGenerator.generateRandomName();
        ItemSize size = ItemSize.values()[ThreadLocalRandom.current().nextInt(ItemSize.values().length)];
        return new Item(name, size);
    }
}

