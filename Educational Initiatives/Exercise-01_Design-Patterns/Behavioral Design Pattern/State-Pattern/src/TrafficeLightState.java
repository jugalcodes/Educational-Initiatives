// TrafficLightState.java
interface State {
    void handle();
}

class RedState implements State {
    @Override
    public void handle() {
        System.out.println("Stop! The light is RED.");
    }
}

class GreenState implements State {
    @Override
    public void handle() {
        System.out.println("Go! The light is GREEN.");
    }
}

class YellowState implements State {
    @Override
    public void handle() {
        System.out.println("Caution! The light is YELLOW.");
    }
}

class TrafficLight {
    private State currentState;

    public void setState(State state) {
        currentState = state;
    }

    public void change() {
        currentState.handle();
    }
}
