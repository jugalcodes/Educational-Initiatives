// HomeTheaterFacade.java
class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
    }

    public void watchMovie(String movie) {
        amplifier.on();
        dvdPlayer.on();
        dvdPlayer.play(movie);
        amplifier.setVolume(5);
    }
}
