package Attestation01;

import java.time.LocalDate;
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
                if (parts.length != 2) {
                    System.out.println("❌ Неверный формат! Используйте: Имя = Сумма");
                    continue;
                }

                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());

                Person person = new Person(name, money);
                people.put(name, person);
            }

            // Ввод продуктов
            System.out.println("Введите продукты. Форматы:");
            System.out.println("Обычный: Название = Цена");
            System.out.println("Скидочный: Название = Цена = Скидка% = ГГГГ-ММ-ДД");
            System.out.println("Пустая строка — завершение ввода");

            while (true) {
                String line = scanner.nextLine();
                if (line.isBlank()) break;

                String[] parts = line.split("=");
                if (parts.length == 2) {
                    // Обычный продукт
                    String name = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());

                    Product product = new Product(name, price);
                    products.put(name, product);

                } else if (parts.length == 4) {
                    // Скидочный продукт
                    String name = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());
                    int discount = Integer.parseInt(parts[2].trim());
                    LocalDate expiry = LocalDate.parse(parts[3].trim());

                    Product product = new DiscountProduct(name, price, discount, expiry);
                    products.put(name, product);

                } else {
                    System.out.println("❌ Неверный формат продукта!");
                }
            }

            // Ввод покупок
            System.out.println("Введите покупки в формате: Имя - НазваниеПродукта (введите END для завершения)");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;

                String[] parts = line.split("-");
                if (parts.length != 2) {
                    System.out.println("❌ Неверный формат! Используйте: Имя - НазваниеПродукта");
                    continue;
                }

                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = people.get(personName);
                Product product = products.get(productName);

                if (person == null) {
                    System.out.println("❌ Покупатель " + personName + " не найден!");
                } else if (product == null) {
                    System.out.println("❌ Продукт " + productName + " не найден!");
                } else {
                    person.buy(product);
                }
            }

            // Вывод содержимого пакетов
            System.out.println();
            for (Person person : people.values()) {
                System.out.println(person.getBagContents());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
