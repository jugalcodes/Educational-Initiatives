import java.util.HashMap;

abstract class Shape implements Cloneable {
    abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeCache {
    private static final HashMap<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        try {
            return (Shape) cachedShape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null; // or handle it as appropriate
        }
    }

    public static void loadCache() {
        Circle circle = new Circle();
        shapeMap.put("1", circle);
        Square square = new Square();
        shapeMap.put("2", square);
    }
}
