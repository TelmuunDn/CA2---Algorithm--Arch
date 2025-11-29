/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstore.view;

/**
 *
 * @author telmuun
 */


import departmentstore.model.Employee;

public class ConsoleView {

    public void show20Employees(java.util.List<Employee> list) {
        System.out.println("---- FIRST 20 EMPLOYEES ----");
        for (int i = 0; i < Math.min(20, list.size()); i++) {
            System.out.println(list.get(i));
        }
    }

    public void showEmployee(Employee e) {
        if (e == null) System.out.println("Employee not found.");
        else System.out.println("Found: " + e);
    }
}

