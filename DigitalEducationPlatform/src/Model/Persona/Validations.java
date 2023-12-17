/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Persona;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nitin
 */
public class Validations {
    public static String passwordHashing(String Password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] inputBytes = Password.getBytes();
            md.update(inputBytes);
            byte[] hashedBytes = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isNumber(String st){
        for(char c: st.toCharArray()){
            if(!Character.isDigit(c) || Character.isWhitespace(c))
                return false;
        }
        return true;
    }
}