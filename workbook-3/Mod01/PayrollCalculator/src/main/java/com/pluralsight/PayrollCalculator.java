package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;
            input = bufferedReader.readLine();
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]));
                System.out.printf("Employee: %s, Employee ID: %d, Gross Pay: $%.2f\n", employee.getName(), employee.getEmployeeId(), employee.getGrossPay());
            }
        } catch (Exception e) {
            System.out.println("Invalid File");
            e.printStackTrace();
        }
    }
}
