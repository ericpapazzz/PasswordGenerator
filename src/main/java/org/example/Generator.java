package org.example;

import javax.swing.*;

public class Generator {
    int passwordLength;
    boolean minusculas;
    boolean mayusculas;
    boolean nums;
    boolean symbols;

    //los caracteres disponibles para la contra
    String min_chars = "abcdefghijklmnopqrstuvwxyz";
    String mayu_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String num_chars = "0123456789";
    String sym_chars = "!@#$%&()=+[]{}|<>?";

    public void getBase() {

        //selecciona que va a contener la contraseña
        passwordLength = getPasswordLength();
        minusculas = getBooleanOption("Incluir minusculas?");
        mayusculas = getBooleanOption("Incluir mayusculas?");
        nums = getBooleanOption("Incluir numeros?");
        symbols = getBooleanOption("Incluir simbolos?");
    }

    private boolean getBooleanOption(String optionLabel) {
        int choice = JOptionPane.showOptionDialog(null, optionLabel, "Selecciona tu opcion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"si", "no"}, "Yes");
        return choice == JOptionPane.YES_OPTION;
    }

    //obtiene la cantidad de caracteres con un return utilizando una variable para guardarlo
    private int getPasswordLength() {
        String input = JOptionPane.showInputDialog(null, "Escriba la cantidad de caracteres para su contraseña:", "Password Length", JOptionPane.PLAIN_MESSAGE);
        return Integer.parseInt(input);
    }

    //crea la contraseña
    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        String characterSet = "";

        if (minusculas) {
            characterSet += min_chars;
        }
        if (mayusculas) {
            characterSet += mayu_chars;
        }
        if (nums) {
            characterSet += num_chars;
        }
        if (symbols) {
            characterSet += sym_chars;
        }

        int characterSetLength = characterSet.length();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = (int) (Math.random() * characterSetLength);
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }

    //entrega la contrasena creada
    public void getPassword(String password) {
        JOptionPane.showMessageDialog(null, "Contraseña creada:" + password);
        System.out.println(password);
    }
}