package tests;

import media.AudioPlayer;
import media.MoviePlayer;
import media.MultimediaControl;
import screen.MonitorType;
import screen.Screen;

import java.util.ArrayList;

// Класс который тестирует устройства только по интерфейсу
class PlayerDriver {
    public static void testPlayerDriver() {
        // Создаем список тип которого является MultimediaControl
        ArrayList<MultimediaControl> players = new ArrayList<MultimediaControl>();

        // Добавляем произвольные объекты, которые реализовывают интерфейс MultimediaControl
        players.add(new AudioPlayer("Audio", "MP3"));
        players.add(new MoviePlayer("Video", new Screen("1024x768", 30, 10), MonitorType.LED));

        // Пробегаемся в цикле по устройствам и совершаем все действия, которые доступны интерфейсу MultimediaControl
        for(MultimediaControl player : players) {
            player.play();
            player.stop();
            player.next();
            player.previous();
        }
    }
}
