package departmentstore.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author telmuun
 */


import departmentstore.model.*;
import departmentstore.view.ConsoleView;

import java.util.Scanner;

public class AppController {

    private EmployeeList employeeList = new EmployeeList();
    private ConsoleView view = new ConsoleView();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        System.out.print("Enter filename to load, (Enter ApplicantsForm.txt to access the file): ");
        String file = sc.nextLine();
        employeeList.loadFromFile("src/departmentstore/" + file);

        while (true) {
            System.out.println("\nDo You wish to SORT or SEARCH:");
            System.out.println("1. SORT");
            System.out.println("2. SEARCH");
            System.out.println("3. ADD RECORDS");
            System.out.println("4. Create a binary tree");
            System.out.println("5. EXIT");

            MenuOption choice = MenuOption.fromInt(sc.nextInt());
            sc.nextLine();

            if (choice == null) continue;

            switch (choice) {
                case SORT:
                    employeeList.sort();
                    view.show20Employees(employeeList.getEmployees());
                    break;

                case SEARCH:
                    System.out.print("Enter full name to search: ");
                    String name = sc.nextLine();
                    Employee found = employeeList.search(name);
                    view.showEmployee(found);
                    break;

                case ADD_RECORDS:
                    addRecord();
                    break;

                case CREATE_BINARY_TREE:
                    createTree();
                    break;

                case EXIT:
                    return;
            }
        }
    }

    private void addRecord() {
        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Manager Type: ");
        String m = sc.nextLine();

        if (!employeeList.isValidManager(m)) {
            System.out.println("Invalid manager type!");
            return;
        }

        System.out.print("Enter Department: ");
        String d = sc.nextLine();

        if (!employeeList.isValidDepartment(d)) {
            System.out.println("Invalid department!");
            return;
        }

        employeeList.addEmployee(new Employee(name, m, d));
        System.out.println("Record added successfully!");
    }

    private void createTree() {
        BinaryTree tree = new BinaryTree();

        int count = 0;
        for (Employee e : employeeList.getEmployees()) {
            if (count == 20) break;
            tree.insert(e);
            count++;
        }

        System.out.println("\n---- BINARY TREE (LEVEL ORDER) ----");
        tree.displayLevelOrder();

        System.out.println("Tree Height: " + tree.getHeight());
        System.out.println("Node Count: " + tree.getNodeCount());
    }
}

