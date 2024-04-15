package tests;

import media.AudioPlayer;

import java.util.ArrayList;

// Класс отвечает за тестирование устройства. Содержит единственный статический метод
class AudioPlayerDriver {
    public static void testAudioPlayerDriver() {
        // Создаем пустой список устройств
        ArrayList<AudioPlayer> players = new ArrayList<>();

        // Добавляем в этот список два устройства
        players.add(new AudioPlayer("Philips HQ", "MP3"));
        players.add(new AudioPlayer("Audio Player", "WAV"));


        for(AudioPlayer player : players) {
            player.play();
            player.stop();
            player.previous();
            player.next();

            System.out.println(player);
        }
    }
}
