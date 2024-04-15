package main;

import core.Product;
import media.AudioPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagementSystem {
    private final ArrayList<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Добавить новый продукт");
            System.out.println("2. Показать все продукты");
            System.out.println("3. Показать статистику");
            System.out.println("4. Выход");

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
        System.out.print("Введите имя продукта: ");
        String name = scanner.next();
        System.out.print("Введите количество: ");
        int units = scanner.nextInt();

        for (int i = 0; i < units; i++) {
            products.add(new AudioPlayer(name, "Generic Audio Spec"));
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
        System.out.println("Всего продуктов: " + products.size());
    }
}
