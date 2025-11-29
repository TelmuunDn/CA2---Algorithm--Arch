/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstore.model;

/**
 *
 * @author telmuun
 */


public class Employee {
    private String fullName;
    private String managerType;
    private String department;

    public Employee(String fullName, String managerType, String department) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public String getManagerType() {
        return managerType;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return fullName + " | " + managerType + " | " + department;
    }
}

