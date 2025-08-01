public class App {
  public static void main(String[] args) {
        Television tv1 = new Television("Samsung", 55.0);
        Television tv2 = new Television("LG", 42.0);

        tv1.turnOn();
        tv1.changeChannel(5);
        tv1.printStatus();

        System.out.println();

        tv2.turnOn();
        tv2.changeChannel(10);
        tv2.turnOff();
        tv2.printStatus();
    }  
}
