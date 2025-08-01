public class Television {
private String brand;
    private double screenSize;
    private boolean isOn;
    private int currentChannel;

    public Television(String brand, double screenSize) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isOn = false;
        this.currentChannel = 1;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " включен.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " выключен.");
    }

    public void changeChannel(int channel) {
        if (isOn) {
            currentChannel = channel;
            System.out.println("Переключено на канал " + channel);
        } else {
            System.out.println("Сначала включите телевизор.");
        }
    }

    public void printStatus() {
        System.out.println("Бренд: " + brand + ", диагональ: " + screenSize + " дюймов");
        System.out.println("Состояние: " + (isOn ? "Включен" : "Выключен"));
        System.out.println("Текущий канал: " + currentChannel);
    }    
}
