/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstore.model;

/**
 *
 * @author telmuun
 */


import java.io.*;
import java.util.*;

public class EmployeeList {

    private List<Employee> employees = new ArrayList<>();

    // Valid entries for assignment
    private final List<String> validManagers = Arrays.asList(
            "Senior Manager", "Manager", "Team Lead", "Assistant Manager",
            "Supervisor", "Sales Associate"
    );

    private final List<String> validDepartments = Arrays.asList(
            "IT Development", "Finance", "Sales", "HR", "Marketing",
            "Customer Service", "Operations", "Accounting"
    );

    public List<Employee> getEmployees() {
        return employees;
    }

    // File Reading logic
    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // skip header row

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 8) continue;

                String fullName = parts[0].trim() + " " + parts[1].trim();
                String dept = parts[5].trim();
                String managerType = parts[7].trim(); // using "Job title" as manager type

                if (managerType.isEmpty()) managerType = "Staff";

                Employee emp = new Employee(fullName, managerType, dept);
                employees.add(emp);
            }

            System.out.println("File loaded successfully. Records: " + employees.size());

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Merge Sort(Recursive) logic
    public void sort() {
        employees = mergeSort(employees);
        System.out.println("List sorted successfully.");
    }

    private List<Employee> mergeSort(List<Employee> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Employee> left = mergeSort(list.subList(0, mid));
        List<Employee> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getFullName().compareToIgnoreCase(right.get(j).getFullName()) < 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }

    // Binary Search
    public Employee search(String name) {
        int low = 0, high = employees.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Employee emp = employees.get(mid);

            int cmp = emp.getFullName().compareToIgnoreCase(name);

            if (cmp == 0) return emp;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    // Add new employee
    public void addEmployee(Employee e) {
        employees.add(e);
        sort();  // Keep sorted after adding
    }

    public boolean isValidManager(String m) {
        return validManagers.contains(m);
    }

    public boolean isValidDepartment(String d) {
        return validDepartments.contains(d);
    }
}

