public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("Large")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(false)
                .build();
        pizza.describe(); // Pizza size: Large, Cheese: true, Pepperoni: true, Mushrooms: false
    }
}
