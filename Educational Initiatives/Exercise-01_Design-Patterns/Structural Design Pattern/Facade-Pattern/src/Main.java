public class Main {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd);

        homeTheater.watchMovie("Inception");
    }
}
