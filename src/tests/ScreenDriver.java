package tests;

import screen.Screen;

import java.util.ArrayList;

// Класс для тестирования экрана
class ScreenDriver {
    public static void testScreenDriver() {
        // Создаем пустой массив
        ArrayList<Screen> screens = new ArrayList<>();

        screens.add(new Screen("1280x720", 60, 5));
        screens.add(new Screen("1920x1080", 144, 5));

        for(Screen screen : screens)
            System.out.println(screen);
    }
}
