package tests;

import core.Product;
import factory.AudioPlayerFactory;
import factory.MoviePlayerFactory;
import factory.ProductFactory;
import media.AudioPlayer;
import media.MoviePlayer;
import screen.MonitorType;
import screen.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс отвечает за тестирование и сортировку разных типов устройств.
class DevicesDriver {
    // Метод для создания и получения тестовой коллекции устройств
    public static List<Product> getTestCollection() {
        List<Product> products = new ArrayList<>();

        ProductFactory audioFactory = new AudioPlayerFactory();
        products.add(audioFactory.createProduct("Philips HQ"));
        products.add(audioFactory.createProduct("Audio Player"));

        ProductFactory movieFactory = new MoviePlayerFactory("1280x720", 60, 5, MonitorType.LCD);
        products.add(movieFactory.createProduct("LG"));

        movieFactory = new MoviePlayerFactory("1024x768", 30, 10, MonitorType.LED);
        products.add(movieFactory.createProduct("Bravia"));

        return products;
    }


    // Метод для вывода в консоль любых объектов
    public static <T> void printDevices(List<T> devices) {
        for(T device : devices)
            System.out.println(device);
    }
}
