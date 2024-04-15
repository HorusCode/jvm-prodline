package tests;

import media.MoviePlayer;
import screen.MonitorType;
import screen.Screen;

import java.util.ArrayList;

// Класс отвечает за тестирование устройства. Содержит единственный статический метод
class MoviePlayerDriver {
    public static void testMoviePlayerDriver() {
        // Создаем пустой список устройств
        ArrayList<MoviePlayer> players = new ArrayList<>();

        // Добавляем в этот список два устройства
        players.add(new MoviePlayer("LG", new Screen("1280x720", 60, 5), MonitorType.LCD));
        players.add(new MoviePlayer("Bravia", new Screen("1024x768", 30, 10), MonitorType.LED));


        for(MoviePlayer player : players) {
            player.play();
            player.stop();
            player.next();
            player.previous();


            System.out.println(player);
        }
    }
}
