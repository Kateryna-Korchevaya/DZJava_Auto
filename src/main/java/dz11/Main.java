package dz11;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Oleg", "Kruglov", 70);
        Woman woman = new Woman("Klara", "Krechetova", 65);

        System.out.println("Is Oleg retired? " + man.isRetired());
        System.out.println("Is Klara retired? " + woman.isRetired());

        man.registerPartnership(woman);
        System.out.println("Klara's last name after marriage: " + woman.getLastName());

        woman.deregisterPartnership(true);
        System.out.println("Klara's last name after divorce: " + woman.getLastName());
    }
}
