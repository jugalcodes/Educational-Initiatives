// PizzaBuilder.java
class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    public static class Builder {
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        public Builder(String size) {
            this.size = size;
        }

        public Builder cheese(boolean value) {
            cheese = value;
            return this;
        }

        public Builder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }

        public Builder mushrooms(boolean value) {
            mushrooms = value;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        size = builder.size;
        cheese = builder.cheese;
        pepperoni = builder.pepperoni;
        mushrooms = builder.mushrooms;
    }

    public void describe() {
        System.out.println("Pizza size: " + size +
                ", Cheese: " + cheese +
                ", Pepperoni: " + pepperoni +
                ", Mushrooms: " + mushrooms);
    }
}
