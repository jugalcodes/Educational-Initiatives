public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton(); // Light is ON
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton(); // Light is OFF
    }
}
