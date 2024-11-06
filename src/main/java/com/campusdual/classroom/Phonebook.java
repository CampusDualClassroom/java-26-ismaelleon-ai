    package com.campusdual.classroom;

    import com.campusdual.util.Utils;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Phonebook{

        public static Map<String, Contact> contactMap = new HashMap<>();
        private Contact contact1 = new Contact("Javier", "López","1");
        private Contact contact2 = new Contact("Carlos","Fernández-Simón","2");
        private Contact contact3 = new Contact("Jose Manuel","Soria","3");
        private Contact contact4 = new Contact("Santiago","Fernández Rocha","4");
        private Contact contact5 = new Contact("Esteban","Serrano del Río","5");
        private Contact contact6 = new Contact("Fernando Miguel","Juan de los Santos Requejo León","6");

        public Phonebook() {

        }

        public Map<String, Contact> getData() {
            return contactMap;
        }

        public void initialContacts () {
            contactMap.put("jlopez",contact1);
            contactMap.put("cfernandez-simon",contact2);
            contactMap.put("jsoria",contact3);
            contactMap.put("sfrocha",contact4);
            contactMap.put("esdelrio",contact5);
            contactMap.put("fjdelossantosrequejoleon",contact6);
        }

        public void addContact (Contact contact) {

            contactMap.put(contact.getCode(), contact);
            System.out.println("Contacto añadido: " + contact.getCode());

        }

        public void showPhonebook () {
            for (Map.Entry<String, Contact> entry:contactMap.entrySet()) {
                Contact contact = entry.getValue();


                System.out.println("___________________");
                System.out.println("Clave: " + entry.getKey());
                System.out.println("Nombre completo: " + contact.getName() + " " + contact.getSurnames());
                System.out.println("Número de telefono: " + contact.getPhone());
                System.out.println("___________________");
            }
        }

        public void deleteContact (String code) {

            if (contactMap.remove(code) !=null) {
                System.out.println("Contacto eliminado");
            } else {
                System.out.println("No se encontró contacto con ese código");
            }
        }

        public void selectContact() {

            showPhonebook();
            System.out.println("Introduzca la clave del contacto para seleccionarlo: ");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            Contact selectedContact = contactMap.get(key);
            if (key !=null) {
                int input2;
                do {
                    System.out.println("\nMenú de acciones del contacto: ");
                    System.out.println("1. Llamar a mi número");
                    System.out.println("2. Lamar a otro número");
                    System.out.println("3. Mostrar detalles");
                    System.out.println("4. Volver al menú principal");
                    input2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (input2) {
                        case 1: selectedContact.callMyNumber();
                        break;

                        case 2: {
                            Scanner scanner2 = new Scanner(System.in);
                            String otherNumber = scanner2.nextLine();
                            selectedContact.callOtherNumber(otherNumber);
                            break;
                        }

                        case 3: selectedContact.showContactDetails();
                        break;

                        case 4: mainMenu();
                        break;
                    }

                } while (input2 !=5);
            }
        }

        public void mainMenu() {

            Scanner scanner = new Scanner(System.in);
            int input1;
            do {
                System.out.println("\nMenú de acciones: ");
                System.out.println("1. Añadir un contacto");
                System.out.println("2. Mostrar contactos");
                System.out.println("3. Seleccionar contacto");
                System.out.println("4. Eliminar contacto");
                System.out.println("5. Salir del menú");
                input1 = scanner.nextInt();
                scanner.nextLine();

                switch (input1) {

                    case 1 : {

                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println("Ingrese nombre: ");
                        String name = scanner5.nextLine();
                        System.out.println("Ingrese apellidos: ");
                        String surname = scanner5.nextLine();
                        System.out.println("Ingrese numero telefonico: ");
                        String phoneNumber = scanner5.nextLine();
                        Contact newContact = new Contact(name, surname,phoneNumber);
                        addContact(newContact);
                    }
                    break;

                    case 2 : showPhonebook();
                    break;

                    case 3 : selectContact();
                    break;

                    case 4 : {
                        showPhonebook();
                        System.out.println("Elija el contacto a eliminar: ");
                        Scanner scanner1 = new Scanner(System.in);
                        String code = scanner1.nextLine();
                        deleteContact(code);
                    }
                    break;

                    case 5:
                        System.out.println("Saliendo...");
                        return;
                }

            } while (input1 != 5);
        }
    }
