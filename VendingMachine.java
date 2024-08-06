interface VendingMachine {
    HotDrink getProduct(String name, int volume, int temperature);
}

class HotDrink {
    private String name;
    private int volume;
    private double price;
    private int temperature;

    public HotDrink(String name, int volume, double price, int temperature) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                ", temperature=" + temperature +
                '}';
    }
}

class HotDrinksVendingMachine implements VendingMachine {
    private List<HotDrink> drinks;

    public HotDrinksVendingMachine() {
        this.drinks = new ArrayList<>();
    }

    public void addDrink(HotDrink drink) {
        drinks.add(drink);
    }

    @Override
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink drink : drinks) {
            if (drink.getName().equals(name) && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrink coffee = new HotDrink("Coffee", 250, 100.0, 70);
        HotDrink tea = new HotDrink("Tea", 200, 50.0, 65);

        HotDrinksVendingMachine machine = new HotDrinksVendingMachine();
        machine.addDrink(coffee);
        machine.addDrink(tea);

        HotDrink drink1 = machine.getProduct("Coffee", 250, 70);
        HotDrink drink2 = machine.getProduct("Tea", 200, 65);

        System.out.println(drink1);
        System.out.println(drink2);
    }
}
