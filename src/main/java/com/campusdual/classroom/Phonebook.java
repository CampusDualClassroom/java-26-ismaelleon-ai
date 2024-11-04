    package com.campusdual.classroom;

    import com.campusdual.util.Utils;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Phonebook extends Contact{

        public static Map<String, Contact> contactMap = new HashMap<>();
        private Contact contact1 = new Contact("Ismael", "Leon","634718713");
        private Contact contact2 = new Contact("Alejandro","Perez","655784101");

        public Phonebook(String name, String surname, String phoneNumber) {
            super(name, surname, phoneNumber);
        }

        public Phonebook() {

        }

        public void initialContacts () {
            contactMap.put("ileon",contact1);
            contactMap.put("aperez",contact2);
        }

        public void addContact () {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese nombre: ");
            String name = scanner.nextLine();
            System.out.println("Ingrese apellidos: ");
            String surname = scanner.nextLine();
            System.out.println("Ingrese numero telefonico: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Ingrese código: ");
            String code = scanner.nextLine();

            Contact contact = new Contact(name, surname,phoneNumber);
            contactMap.put(code, contact);
            System.out.println("Contacto añadido");

        }


        public void showAllContacts () {
            for (Map.Entry<String, Contact> entry:contactMap.entrySet()) {
                Contact contact = entry.getValue();

                System.out.println("___________________");
                System.out.println("Clave: " + entry.getKey());
                System.out.println("Nombre completo: " + contact.getName() + " " + contact.getSurname());
                System.out.println("Número de telefono: " + contact.getPhoneNumber());
                System.out.println("___________________");
            }
        }

        public void deleteContact () {

            showAllContacts();
            System.out.println("Elija el contacto a eliminar: ");
            Scanner scanner = new Scanner(System.in);
            String codeD = scanner.nextLine();
            if (contactMap.remove(codeD) !=null) {
                System.out.println("Contacto eliminado");
            } else {
                System.out.println("No se encontró contacto con ese código");
                deleteContact();
            }
        }

        public void selectContact() {

            showAllContacts();
            System.out.println("Introduzca la clave del contacto para seleccionarlo: ");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
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
                        case 1: callMyNumber();

                        case 2: {

                            System.out.println("Ingrese el número a llamar: ");
                            String number = scanner.nextLine();
                            callOtherNumber(number);
                        }

                        case 3:showContactDetails();

                        case 4: mainMenu();
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

                    case 1 : addContact();

                    case 2 : showAllContacts();

                    case 3 : selectContact();

                    case 4 : deleteContact();

                    case 5:
                        System.out.println("Saliendo...");
                }

            } while (input1 != 5);

        }


    }
