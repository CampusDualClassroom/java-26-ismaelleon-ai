    package com.campusdual.classroom;

    import com.campusdual.util.Utils;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Phonebook {

        public static Map<String, Contact> contactMap = new HashMap<>();
        
        //public void initialContacts () {
        //    contactMap.put();
        //}

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

            Contact contact = new Contact(name, surname, phoneNumber);
            contactMap.put(code, contact);
            System.out.println("Contacto añadido");

        }



        public void showAllContacts () {
            for (Map.Entry<String, Contact> entry:contactMap.entrySet()) {
                Contact contact = entry.getValue();

                System.out.print(entry.getKey() + " -> Nombre completo:" + contact.getName() + " " + contact.getSurname() + " " + " Número de telefono: " + contact.getPhoneNumber());
                System.out.println();
            }
        }

        public void mainMenu() {

            Scanner scanner = new Scanner(System.in);
            int input;
            do {
                System.out.println("\nMenú de acciones: ");
                System.out.println("1. Añadir un contacto");
                System.out.println("2. Mostrar contactos");
                System.out.println("3. Seleccionar contacto");
                System.out.println("4. Eliminar contacto");
                System.out.println("5. Salir del menu");
                input = scanner.nextInt();

                switch (input) {

                    case 1 : addContact();

                    case 2 : showAllContacts();

                    case 3 : {

                    }

                    case 4 : {

                    }
                }

            } while (input != 5);

        }

    }
