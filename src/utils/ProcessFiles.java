package utils;

import core.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ProcessFiles {
    private final Path p;
    private final Path p2;
    private final Path p3;

    public ProcessFiles() {
        p = Paths.get(System.getProperty("user.dir"), "src", "main", "java");
        p2 = Paths.get(p.toString(), "TestResults.txt");
        p3 = p.resolve(p2.toString());
        createDirectory();
    }

    private void createDirectory() {
        try {
            if(!Files.exists(p)) {
                Files.createDirectory(p);
            }

            if(!Files.exists(p2)) {
                Files.createFile(p2);
            }
        } catch (IOException e) {
            System.out.println("Ошибка в создании директории или файла");
            e.printStackTrace();
        }
    }

    public void writeFile(EmployeeInfo employeeInfo) throws IOException {
        String eol = System.getProperty("line.separator");
        Files.writeString(p3, employeeInfo.toString() + eol, StandardOpenOption.APPEND);
    }

    public void writeFile(ArrayList<Product> products) throws IOException {
        String eol = System.getProperty("line.separator");
        for (Product product : products) {
            Files.writeString(p3, product.toString() + eol, StandardOpenOption.APPEND);
        }
    }
}
