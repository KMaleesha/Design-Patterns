package Factory;

public class Factory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Triangle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle");
    }
}

class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType == null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("triangle")){
            return new Triangle();
        }
        return null;
    }
}
