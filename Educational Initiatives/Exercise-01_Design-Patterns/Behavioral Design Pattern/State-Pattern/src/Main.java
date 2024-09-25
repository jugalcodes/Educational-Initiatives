public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.setState(new RedState());
        trafficLight.change(); // Stop! The light is RED.
        trafficLight.setState(new GreenState());
        trafficLight.change(); // Go! The light is GREEN.
        trafficLight.setState(new YellowState());
        trafficLight.change(); // Caution! The light is YELLOW.
    }
}
