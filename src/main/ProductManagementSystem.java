package main;

import core.Product;
import factory.AudioPlayerFactory;
import factory.MoviePlayerFactory;
import factory.ProductFactory;
import media.AudioPlayer;
import media.MoviePlayer;
import screen.MonitorType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Supplier;

public class ProductManagementSystem {
    private final Map<Integer, Supplier<ProductFactory>> factoryMap = new HashMap<>();
    private final ArrayList<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Date today;

    public ProductManagementSystem() {
        factoryMap.put(1, AudioPlayerFactory::new);
        factoryMap.put(2, () -> {
            System.out.print("Введите спецификацию экрана (например, 1920x1080): ");
            String resolution = scanner.next();
            System.out.print("Введите частоту обновления экрана: ");
            int refreshRate = scanner.nextInt();
            System.out.print("Введите время отклика экрана: ");
            int responseTime = scanner.nextInt();
            System.out.print("Введите тип монитора (1 - LCD, 2 - LED): ");
            MonitorType monitorType = scanner.nextInt() == 1 ? MonitorType.LCD : MonitorType.LED;
            scanner.nextLine();

            return new MoviePlayerFactory(resolution, refreshRate, responseTime, monitorType);
        });
        this.today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Добавить новый продукт");
            System.out.println("2. Показать все продукты");
            System.out.println("3. Показать статистику");
            System.out.println("4. Выход");
            System.out.println("Для выбора введите от 1 до 4");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    displayStats();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Такого выбора нет. Попробуйте ещё раз");
            }
        }
    }


    private void addProduct() {
        System.out.print("Выбери тип продукта[1 - аудио-плеер, 2 - видео-плеер]: ");
        int type = scanner.nextInt();
        scanner.nextLine();  // Поглощаем оставшийся символ новой строки после числа

        ProductFactory factory = factoryMap.get(type).get();
        if (factory == null) {
            System.out.println("Неверный тип продукта. Попробуйте снова.");
            return;
        }

        System.out.print("Введи название продукта: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество: ");
        int units = scanner.nextInt();

        for (int i = 0; i < units; i++) {
            products.add(factory.createProduct(name));
        }
    }

    private void displayProducts() {
        Product.sortProductsByName(products);
        for (Product product : products) {
            System.out.println(product);
            System.out.println("--------------------------------------------------");
        }
    }

    public void print() {
        products.forEach(System.out::println);
    }

    private void displayStats() {
        int audioCount = 0;
        int videoCount = 0;
        Set<String> uniqueProducts = new HashSet<>();
        int addedToday = 0;

        for (Product product : products) {
            if (product instanceof AudioPlayer) {
                audioCount++;
            } else if (product instanceof MoviePlayer) {
                videoCount++;
            }

            uniqueProducts.add(product.getName());

            if (product.getManufactureDate().compareTo(today) >= 0) {
                addedToday++;
            }
        }

        System.out.println("Всего продуктов: " + products.size());
        System.out.println("Аудиоплееров: " + audioCount);
        System.out.println("Медиаплееров: " + videoCount);
        System.out.println("Уникальных продуктов: " + uniqueProducts.size());
        System.out.println("Продуктов добавлено сегодня: " + addedToday);
    }
}
