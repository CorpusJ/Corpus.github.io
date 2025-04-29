// Written by Jackson Corpus

import java.util.*;

class Animal {
    private String name;
    private double weight;

    public Animal() {
        this.name = "none";
        this.weight = 1.0;
    }

    public Animal(String name, double weight) {
        setName(name);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name : "none";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = (weight > 0) ? weight : 1.0;
    }

    public boolean equals(Animal other) {
        return other != null && this.name.equalsIgnoreCase(other.name) && this.weight == other.weight;
    }

    public String toString() {
        return "Name : " + name + "\nWeight: " + weight;
    }
}

class Cat extends Animal {
    private String mood;
    private static final String[] VALID_MOODS = {"sleepy", "playful", "hungry"};

    public Cat() {
        super();
        this.mood = "sleepy";
    }

    public Cat(String name, double weight, String mood) {
        super(name, weight);
        setMood(mood);
    }

    public void setMood(String mood) {
        for (String m : VALID_MOODS) {
            if (m.equalsIgnoreCase(mood)) {
                this.mood = m;
                return;
            }
        }
        this.mood = "sleepy";
    }

    public String getMood() {
        return mood;
    }

    public boolean equals(Cat other) {
        return super.equals(other) && this.mood.equalsIgnoreCase(other.mood);
    }

    public String toString() {
        return super.toString() + "\nMood: " + mood;
    }
}

class Dog extends Animal {
    private int energyLevel;

    public Dog() {
        super();
        this.energyLevel = 50;
    }

    public Dog(String name, double weight, int energyLevel) {
        super(name, weight);
        setEnergyLevel(energyLevel);
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = (energyLevel >= 0 && energyLevel <= 100) ? energyLevel : 50;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public boolean equals(Dog other) {
        return super.equals(other) && this.energyLevel == other.energyLevel;
    }

    public String toString() {
        return super.toString() + "\nEnergy Level: " + energyLevel;
    }
}

class HouseCat extends Cat {
    private String type;
    private static final String[] VALID_TYPES = {"short hair", "ragdoll", "sphinx", "scottish fold"};

    public HouseCat() {
        super();
        this.type = "short hair";
    }

    public HouseCat(String name, double weight, String mood, String type) {
        super(name, weight, mood);
        setType(type);
    }

    public void setType(String type) {
        for (String t : VALID_TYPES) {
            if (t.equalsIgnoreCase(type)) {
                this.type = t;
                return;
            }
        }
        this.type = "short hair";
    }

    public String getType() {
        return type;
    }

    public boolean equals(HouseCat other) {
        return super.equals(other) && this.type.equalsIgnoreCase(other.type);
    }

    public String toString() {
        return super.toString() + "\nType: " + type;
    }
}

class Leopard extends Cat {
    private int numberOfSpots;

    public Leopard() {
        super();
        this.numberOfSpots = 1;
    }

    public Leopard(String name, double weight, String mood, int numberOfSpots) {
        super(name, weight, mood);
        setNumberOfSpots(numberOfSpots);
    }

    public void setNumberOfSpots(int spots) {
        this.numberOfSpots = (spots >= 1) ? spots : 1;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public boolean equals(Leopard other) {
        return super.equals(other) && this.numberOfSpots == other.numberOfSpots;
    }

    public String toString() {
        return super.toString() + "\nNumber of Spots: " + numberOfSpots;
    }
}

class DomesticDog extends Dog {
    private String type;
    private static final String[] VALID_TYPES = {"retriever", "terrier", "husky", "mutt"};

    public DomesticDog() {
        super();
        this.type = "retriever";
    }

    public DomesticDog(String name, double weight, int energyLevel, String type) {
        super(name, weight, energyLevel);
        setType(type);
    }

    public void setType(String type) {
        for (String t : VALID_TYPES) {
            if (t.equalsIgnoreCase(type)) {
                this.type = t;
                return;
            }
        }
        this.type = "retriever";
    }

    public String getType() {
        return type;
    }

    public boolean equals(DomesticDog other) {
        return super.equals(other) && this.type.equalsIgnoreCase(other.type);
    }

    public String toString() {
        return super.toString() + "\nType: " + type;
    }
}

class Wolf extends Dog {
    private String packLeaderName;

    public Wolf() {
        super();
        this.packLeaderName = "none";
    }

    public Wolf(String name, double weight, int energyLevel, String leaderName) {
        super(name, weight, energyLevel);
        setPackLeaderName(leaderName);
    }

    public void setPackLeaderName(String name) {
        this.packLeaderName = (name != null) ? name : "none";
    }

    public String getPackLeaderName() {
        return packLeaderName;
    }

    public boolean equals(Wolf other) {
        return super.equals(other) && this.packLeaderName.equalsIgnoreCase(other.packLeaderName);
    }

    public String toString() {
        return super.toString() + "\nPack Leader: " + packLeaderName;
    }
}

class AnimalCollection {
    private Animal[] animals;
    private int count;
    public static final int DEF_SIZE = 100;

    public AnimalCollection() {
        animals = new Animal[DEF_SIZE];
        count = 0;
    }

    public void addAnimal(Animal a) {
        if (count < DEF_SIZE) {
            animals[count++] = a;
        }
    }

    public void removeAnimal(Animal a) {
        for (int i = 0; i < count; i++) {
            if (animals[i].equals(a)) {
                animals[i] = animals[count - 1];
                animals[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public void printAnimals() {
        for (int i = 0; i < count; i++) {
            System.out.println("----------------------");
            System.out.println(animals[i]);
        }
    }
}

public class Homework07 {
    static Scanner keyboard = new Scanner(System.in);
    static AnimalCollection aCollection = new AnimalCollection();

    public static void main(String[] args) {
        System.out.println("Welcome to the Animal Collection!");
        while (true) {
            System.out.println("\nEnter 1. To Add an Animal.");
            System.out.println("Enter 2. To Remove an Animal.");
            System.out.println("Enter 9. To Quit.");
            int choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 9) break;
            handleChoice(choice);
            aCollection.printAnimals();
        }
        System.out.println("Goodbye!");
    }

    public static void handleChoice(int choice) {
        if (choice != 1 && choice != 2) return;

        System.out.println("\nEnter the kind of Animal.");
        System.out.println("1. For Animal\n2. For Cat\n3. For Dog\n4. For House Cat\n5. For Leopard\n6. For Domestic Dog\n7. For Wolf");
        int type = keyboard.nextInt();
        keyboard.nextLine();

        Animal a = createAnimal(type);
        if (choice == 1) aCollection.addAnimal(a);
        else aCollection.removeAnimal(a);
    }

    public static Animal createAnimal(int type) {
        System.out.println("Enter the Animal's Name");
        String name = keyboard.nextLine();
        System.out.println("Enter the Animal's Weight");
        double weight = keyboard.nextDouble();
        keyboard.nextLine();

        switch (type) {
            case 1: return new Animal(name, weight);
            case 2:
                System.out.println("Enter the Cat's mood. \"sleepy\", \"playful\", \"hungry\"");
                String mood = keyboard.nextLine();
                return new Cat(name, weight, mood);
            case 3:
                System.out.println("Enter the Dog's Energy Level. Between 1 and 100.");
                int energy = keyboard.nextInt();
                keyboard.nextLine();
                return new Dog(name, weight, energy);
            case 4:
                System.out.println("Enter the Cat's mood. \"sleepy\", \"playful\", \"hungry\"");
                mood = keyboard.nextLine();
                System.out.println("Enter the House Cat's Type. \"short hair\", \"ragdoll\", \"sphinx\", \"scottish fold\"");
                String typeHC = keyboard.nextLine();
                return new HouseCat(name, weight, mood, typeHC);
            case 5:
                System.out.println("Enter the Cat's mood. \"sleepy\", \"playful\", \"hungry\"");
                mood = keyboard.nextLine();
                System.out.println("Enter the Leopard's Spots. Greater than or equal to 1.");
                int spots = keyboard.nextInt();
                keyboard.nextLine();
                return new Leopard(name, weight, mood, spots);
            case 6:
                System.out.println("Enter the Dog's Energy Level. Between 1 and 100.");
                energy = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Enter the Domestic Dog's Type. \"retriever\", \"terrier\", \"husky\", \"mutt\"");
                String dogType = keyboard.nextLine();
                return new DomesticDog(name, weight, energy, dogType);
            case 7:
                System.out.println("Enter the Dog's Energy Level. Between 1 and 100.");
                energy = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Enter the Wolf's Pack Leader's Name.");
                String leader = keyboard.nextLine();
                return new Wolf(name, weight, energy, leader);
            default: return new Animal();
        }
    }
}
