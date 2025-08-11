package Attestation01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            // Ввод покупателей
            System.out.println("Введите покупателей в формате: Имя = Сумма (пустая строка — завершение ввода)");
            while (true) {
                String line = scanner.nextLine();
                if (line.isBlank()) break;

                String[] parts = line.split("=");
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());

                Person person = new Person(name, money);
                people.put(name, person);
            }

            // Ввод продуктов
            System.out.println("Введите продукты в формате: Название = Цена (пустая строка — завершение ввода)");
            while (true) {
                String line = scanner.nextLine();
                if (line.isBlank()) break;

                String[] parts = line.split("=");
                String name = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());

                Product product = new Product(name, price);
                products.put(name, product);
            }

            // Ввод покупок
            System.out.println("Введите покупки в формате: Имя - НазваниеПродукта (введите END для завершения)");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;

                String[] parts = line.split("-");
                if (parts.length != 2) continue;

                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = people.get(personName);
                Product product = products.get(productName);

                if (person != null && product != null) {
                    person.buy(product);
                }
            }

            // Вывод содержимого пакетов
            System.out.println();
            for (Person person : people.values()) {
                System.out.println(person.getBagContents());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
