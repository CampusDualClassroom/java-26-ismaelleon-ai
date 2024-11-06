package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surnames;
    private String phone;
    private String code;
    private final String MY_NUMBER = "634718713";

    public Contact() {

    }

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surnames = surname;
        this.phone = phoneNumber;
        this.code = generateCode(name,surname);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurname(String surname) {
        this.surnames = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String generateCode(String firstName, String lastName) {
        String lowerName = this.name.toLowerCase();
        String lowerSurnames = this.surnames.toLowerCase();

        String diacriticsName = Normalizer.normalize(lowerName, Normalizer.Form.NFD);
        String diacriticsSurnames = Normalizer.normalize(lowerSurnames, Normalizer.Form.NFD);

        String perfectName = diacriticsName.replaceAll("[^\\p{ASCII}]", "");
        String perfectSurnames = diacriticsSurnames.replaceAll("[^\\p{ASCII}]", "");

        String[] nameParts = perfectName.split(" ");
        String[] surnamesPart = perfectSurnames.split(" ");

        StringBuilder sb = new StringBuilder();

        sb.append(nameParts[0].charAt(0));

        if(perfectSurnames.contains(" ")) {

            sb.append(surnamesPart[0].charAt(0));
            for (int i = 1; i < surnamesPart.length; i++) {
                sb.append(surnamesPart[i]);
            }
        }
        else {
            sb.append(perfectSurnames);
        }

        return sb.toString();
    }

    public String getCode(){

        return code;
    }

    @Override
    public void callOtherNumber(String phoneNumber) {
        System.out.println("Llamando al número: " + this.phone+ this.name + this.surnames + phoneNumber);

    }

    @Override
    public void callMyNumber() {

        if (MY_NUMBER == phone) {
            System.out.println("Llamando a mi propio número: " + MY_NUMBER);

        } else {
            System.out.println("Llamando a " + this.name + " " + this.phone + this.surnames);

        }
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre completo: " + this.name + " " + this.surnames + this.phone + this.code);

    }


}
