package factory;

import core.Product;
import media.MoviePlayer;
import screen.MonitorType;
import screen.Screen;

public class MoviePlayerFactory implements ProductFactory{
    private Screen screen;
    private MonitorType monitorType;

    public MoviePlayerFactory(String resolution, int refreshRate, int responseTime, MonitorType monitorType) {
        this.screen = new Screen(resolution, refreshRate, responseTime);
        this.monitorType = monitorType;
    }

    @Override
    public Product createProduct(String name) {
        return new MoviePlayer(name, screen, monitorType);
    }
}
