/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.utils;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Maik
 */
public class DialogValidator {
    public static String inputStr(String message, List<String> validates){
        String result = "";
        boolean valid = false;
        do {
            result = JOptionPane.showInputDialog(message);
            valid = validates.contains(result);
        } while (!valid);
        
        return result;
    }
    
    public static void addUpOrInsertToMap(Map<String, Float> storage, String key, float value) {
        if (storage.containsKey(key)) {
            storage.put(key, storage.get(key) + value);
        } else {
            storage.put(key, value);
        }
    }
    
}
