/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstore.model;

/**
 *
 * @author telmuun
 */
public enum MenuOption {
    SORT(1),
    SEARCH(2),
    ADD_RECORDS(3),
    CREATE_BINARY_TREE(4),
    EXIT(5);

    public final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public static MenuOption fromInt(int option) {
        for (MenuOption m : MenuOption.values()) {
            if (m.value == option) return m;
        }
        return null;
    }
}
