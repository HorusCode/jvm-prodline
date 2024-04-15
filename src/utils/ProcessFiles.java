package utils;

import core.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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

    public void writeFile(String content) throws IOException {
        Files.writeString(p3, content + System.lineSeparator(), StandardOpenOption.APPEND);
    }

    public void writeFile(EmployeeInfo emp) throws IOException {
        writeFile(emp.toString());
    }

    public void writeFile(List<Product> products) throws IOException {
        for (Product product : products) {
            writeFile(product.toString());
        }
    }
}
