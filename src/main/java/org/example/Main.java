package org.example;
    //main
public class Main {
        public static void main(String[] args) {
            Generator generator = new Generator();
            generator.getBase();
            String password = generator.generatePassword();
            generator.getPassword(password);
        }
}
