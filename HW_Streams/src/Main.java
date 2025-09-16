import java.util.*;
import java.util.stream.Collectors;

public class Main {
   public static void main(String[] args) {
        List<Car> cars = List.of(
    new Car("a123me","Mercedes","White",    0,   8_300_000),
    new Car("b873of","Volga",   "Black",     0,     673_000),
    new Car("w487mn","Lexus",   "Grey",  76_000,     900_000),
    new Car("p987hj","Volga",   "Red",      610,     704_340),
    new Car("c987ss","Toyota",  "White", 254_000,     761_000),
    new Car("o983op","Toyota",  "Black", 698_000,     740_000),
    new Car("p146op","BMW",     "White", 271_000,     850_000),
    new Car("u893ii","Toyota",  "Purple",210_900,     440_000),
    new Car("l097df","Toyota",  "Black", 108_000,     780_000),
    new Car("y876wd","Toyota",  "Black", 160_000,   1_000_000)
);

        System.out.println("\nШаг 1: Автомобили марки Toyota");
        cars.stream()
            .filter(car -> car.getModel().equals("Toyota"))
            .forEach(System.out::println);

        System.out.println("\nШаг 2: Авто с пробегом < 50 000 км");
        cars.stream()
            .filter(car -> car.getMileage() < 50_000)
            .forEach(System.out::println);

        System.out.println("\nШаг 3: Сортировка по стоимости (возрастание)");
cars.stream()
    .sorted(Comparator.comparingLong(Car::getCost)) // <— ВАЖНО: comparingLong
    .forEach(System.out::println);

    System.out.println("\nШаг 4: Средняя стоимость по моделям");

cars.stream()
    .collect(Collectors.groupingBy(
        Car::getModel,                            // группируем по модели
        Collectors.averagingLong(Car::getCost)    // считаем среднюю стоимость
    ))
    .forEach((model, avgCost) ->
        System.out.println(model + " → " + avgCost)
    );
   }
}
