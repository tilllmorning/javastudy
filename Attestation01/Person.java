package Attestation01;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> bag = new ArrayList<>();

    public Person(String name, int money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }

        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void buy(Product product) {
        if (product.getPrice() > money) {
            System.out.println(name + " не может позволить себе " + product.getName());
        } else {
            bag.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
        }
    }

    public String getBagContents() {
        if (bag.isEmpty()) return name + " - Ничего не куплено";

        StringBuilder sb = new StringBuilder(name + " - ");
        for (int i = 0; i < bag.size(); i++) {
            sb.append(bag.get(i).getName());
            if (i < bag.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return money == person.money && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + money;
    }
}
