package tests;

import core.Product;
import utils.EmployeeInfo;
import utils.ProcessFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestProductionLine {
    private final List<Product> products;
    private final EmployeeInfo employee;
    private final ProcessFiles processFiles;

    public TestProductionLine() throws IOException {
        this.products = new ArrayList<>();
        this.employee = new EmployeeInfo();
        this.processFiles = new ProcessFiles();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void testAndSaveResults() {
        try {
            for(Product product : products) {
                String output = product.toString() + "\n" + employee.toString();
                processFiles.writeFile(output);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            TestProductionLine testLine = new TestProductionLine();
            // Создадим список тестовых устройств
            List<Product> products = DevicesDriver.getTestCollection();
            // Выведем список устройств в консоль
            DevicesDriver.printDevices(products);
            MoviePlayerDriver.testMoviePlayerDriver();
            PlayerDriver.testPlayerDriver();
            ScreenDriver.testScreenDriver();
            AudioPlayerDriver.testAudioPlayerDriver();
            testLine.testAndSaveResults();
        } catch (IOException e) {
            System.err.println("Failed to initialize test line: " + e.getMessage());
        }
    }
}
