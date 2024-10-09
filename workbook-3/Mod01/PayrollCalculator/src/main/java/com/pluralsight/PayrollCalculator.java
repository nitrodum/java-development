package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the name of the employee file to process: ");
        String readFile = scanner.nextLine();
        System.out.println("Would you like the data as JSON? (Yes/No)");
        String answer = scanner.nextLine();
        System.out.println("Enter the name of the payroll file to create: ");
        String writeFile = scanner.nextLine();
        scanner.close();

        boolean json = false;

        if (answer.equalsIgnoreCase("yes")) {
            json = true;
        }
        try {
            FileReader fileReader = new FileReader(readFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter writer = new FileWriter(writeFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            List<String> employeeDataList = new ArrayList<>();
            String input = bufferedReader.readLine();

            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]));

                String employeeData;
                if (json) {
                    employeeData = String.format("\t{ \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                } else {
                    employeeData = String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                }

                employeeDataList.add(employeeData);
                System.out.printf("Employee: %s, Employee ID: %d, Gross Pay: $%.2f\n", employee.getName(), employee.getEmployeeId(), employee.getGrossPay());
            }

            if (json) {
                bufferedWriter.write("[\n");
                for (int i = 0; i < employeeDataList.size(); i++) {
                    bufferedWriter.write(employeeDataList.get(i));
                    if (i < employeeDataList.size() - 1) {
                        bufferedWriter.write(",\n");
                    } else {
                        bufferedWriter.write("\n");
                    }
                }
                bufferedWriter.write("]");
            } else {
                bufferedWriter.write("id|name|gross pay\n");
                for (String employeeData : employeeDataList) {
                    bufferedWriter.write(employeeData);
                }
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Invalid File");
            e.printStackTrace();
        }
    }
}