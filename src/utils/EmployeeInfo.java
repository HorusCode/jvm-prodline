package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeInfo {
    private StringBuilder name;
    private String code;
    private String deptId;
    private final Scanner in;
    private static final Pattern VALID_ID_PATTERN = Pattern.compile("[A-Z][a-z]{3}\\d{2}]");

    public EmployeeInfo() {
        in = new Scanner(System.in);
        setName();
        setDeptId();
    }

    private void setName() {
        System.out.print("Enter employee name: ");
        String nameInput = in.nextLine();
        if(checkName(nameInput)) {
            name = new StringBuilder(nameInput);
            createEmployeeCode(name);
        } else {
            name = new StringBuilder("guest");
            code = "guest";
        }
    }

    private void setDeptId() {
        System.out.print("Enter employee department: ");
        String id = in.nextLine();
        deptId = validId(id) ? id : "None01";
    }

    private boolean validId(String id) {
        return VALID_ID_PATTERN.matcher(id).matches();
    }

    private boolean checkName(String name) {
        return name.contains(" ");
    }

    private void createEmployeeCode(StringBuilder name) {
        code = name.charAt(0) + name.substring(name.indexOf(" ") + 1);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name.toString();
    }

    public String getDeptId() {
        return deptId;
    }

    @Override
    public String toString() {
        return "Employee Code: " + code + ", Department ID: " + deptId;
    }

    public void closeScanner() {
        in.close();
    }

}
