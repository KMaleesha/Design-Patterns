package Builder;

public class Builder {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("alto", 2000000).setAirConditioning(true).setSunroof(true).build();
        System.out.println(car);
    }
}

class Car {
    private final String name;
    private final double price;
    private final boolean sunroof;
    private final boolean airConditioning;

    private Car (CarBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.sunroof = builder.sunroof;
        this.airConditioning = builder.airConditioning;
    }

    public static class CarBuilder {
        private final String name;
        private final double price;
        private boolean sunroof = true;
        private boolean airConditioning = false;

        public CarBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "my car " + name + " " + price + " " + sunroof + " " + airConditioning;
    }

}
