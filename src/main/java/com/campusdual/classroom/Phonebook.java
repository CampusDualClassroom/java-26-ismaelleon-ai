    package com.campusdual.classroom;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Phonebook {

        private static Map<String,Contact> createContactMap() {
            Map<String, Contact> contactMap = new HashMap<>();
            return contactMap;
        }

        public void addContact (){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese nombre: ");
            String name = scanner.nextLine();
            System.out.println("Ingrese apellidos: ");
            String surname = scanner.nextLine();
            System.out.println("Ingrese numero telefonico: ");
            String phoneNumber = scanner.nextLine();

            Contact contact = new Contact(name, surname, phoneNumber);
            createContactMap().put()// no entiendo porque me lo almacena como un metodo
            System.out.println("Contacto añadido");

        }

        public void mainMenu() {

            Scanner scanner = new Scanner(System.in);
            int num;
            do {
                System.out.println("\nMenú de acciones: ");
                System.out.println("1. Añadir un contacto");
                System.out.println("2. Mostrar contactos");
                System.out.println("3. Seleccionar contacto");
                System.out.println("4. Eliminar contacto");
                System.out.println("5. Salir del menu");
                num = scanner.nextInt();

                switch (num) {
                    case 1 =
                        ;
                    case 2 =
                        ;
                    case 3 =;
                    case 4 =;
                }

            } while (num != 5);

        }



    }
