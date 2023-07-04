package springGame.Kelad;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + name + "\n";
    }

    public static Person generateRandom() {
        String name = NameGenerator.generateRandomName();
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

