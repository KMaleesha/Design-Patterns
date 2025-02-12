package prototype;

import java.util.HashMap;
import java.util.Map;

public class Prototype {
    public static void main(String[] args) {
        CarRegistry registry = new CarRegistry();
        Car cloneCar =  registry.getCar("SportsCar");
        System.out.println(cloneCar);
    }
}

interface PrototypeInterface {
    Car clone();
}

class Car implements PrototypeInterface {
    private String color;
    private String model;
    private String brand;
    private int speed;

    public Car() {}

    public Car(String color, String model, String brand, int speed) {
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.speed = speed;
    }

    public Car(Car car){
        this.color = car.color;
        this.model = car.model;
        this.brand = car.brand;
        this.speed = car.speed;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

    @Override
    public String toString() {
        return "Car [Brand=" + brand + ", Model=" + model + ", Color=" + color + ", Speed=" + speed + "]";
    }
}

class CarRegistry {
    private Map<String, Car> cars = new HashMap<>();

    public CarRegistry() {
        Car sportsCar = new Car("Red", "911", "Porsche", 320);
        Car suvCar = new Car("Black", "X5", "BMW", 250);

        registerCar("SportsCar", sportsCar);
        registerCar("SUVCar", suvCar);
    }

    public void registerCar(String key, Car car) {
        cars.put(key, car);
    }

    public Car getCar(String key) {
        Car car = cars.get(key);
        return (car != null) ? car.clone() : null;
    }
}
