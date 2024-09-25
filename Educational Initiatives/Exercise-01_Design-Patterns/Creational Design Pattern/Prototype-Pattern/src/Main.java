public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedCircle = ShapeCache.getShape("1");
        clonedCircle.draw(); // Drawing Circle
        Shape clonedSquare = ShapeCache.getShape("2");
        clonedSquare.draw(); // Drawing Square
    }
}
