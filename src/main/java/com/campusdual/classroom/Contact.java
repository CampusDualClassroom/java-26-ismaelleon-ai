package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surname;
    private String phoneNumber;
    private String code;


    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = code; //generateCode(name,surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //private String generateCode(String firstName, String lastName) {
    //    String normalizedLastName = Normalizer.normalize(lastName, Normalizer.Form.NFD)
    //            .replaceAll("[^\\p{ASCII}]", "").toLowerCase().replace(" ", "");
//
    //    if (!lastName.contains(" ")) {
    //        return firstName.charAt(0) + normalizedLastName;
    //    }
//
    //    String[] lastNames = lastName.toLowerCase().split(" ");
    //    String code = firstName.substring(0, 1) + lastNames[0].charAt(0) + lastNames[1];
    //    System.out.println(code);
    //    return code;
//
    //}

    public String getCode(){

        return code;
    }

    @Override
    public void callMyNumber() {

    }

    @Override
    public void callOtherNumber(String number) {

    }

    @Override
    public void showContactDetails() {

    }
}
