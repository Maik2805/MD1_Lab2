/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import javax.swing.JOptionPane;
import supermarket.model.Employee;

/**
 *
 * @author Maik
 */
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido a \n-- SUPERMARKET UNIVALLE --");
        String employeeName = JOptionPane.showInputDialog("Ingrese el nombre del Cajero");
        String employeeId = JOptionPane.showInputDialog("Ingrese identificación del Cajero");
        String initialAmountStr = JOptionPane.showInputDialog("Ingrese el monto inicial en efectivo.");
        boolean isValid = false;
        float initialAmount = 0;
        do {            
            try {
                initialAmount = Float.parseFloat(initialAmountStr);
                isValid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR, DIGITE UN NUMERO");
            }
            
        } while (!isValid);
        Employee employee = new Employee( employeeId, employeeName);
        RunTimeEnvironment runTime = new RunTimeEnvironment(employee, initialAmount);
        runTime.showInitialMenu();
        
    }
}
