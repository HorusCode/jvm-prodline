package media;

import core.Product;
import screen.MonitorType;
import screen.Screen;

import javax.management.monitor.Monitor;

public class MoviePlayer extends Product implements MultimediaControl {
    private Screen screen;
    private MonitorType monitorType;

    public MoviePlayer(String name, Screen screen, MonitorType monitorType) {
        super(name);
        this.screen = screen;
        this.monitorType = monitorType;
    }

    @Override
    public void play() {
        System.out.println("Проигрывать фильм");
    }

    @Override
    public void stop() {
        System.out.println("Стоп фильм");
    }

    @Override
    public void previous() {
        System.out.println("Предыдущий фильм");
    }

    @Override
    public void next() {
        System.out.println("Следующий фильм");
    }


    public String toString() {
        return super.toString() + "\nЭкран: " + screen.toString() + "\nТип монитора: " + monitorType;
    }
}
