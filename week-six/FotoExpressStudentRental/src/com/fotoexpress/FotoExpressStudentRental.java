package com.fotoexpress;

import java.util.*;

public class FotoExpressStudentRental {

    private static Map<String, Customer> clientes = new HashMap<>();
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        inicializarInventario(inventory);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    alquilarCamara(scanner);
                    break;
                case 2:
                    devolverCamara(scanner);
                    break;
                case 3:
                    listarCamarasDisponibles();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nBienvenido a Foto Express Student Rental");
        System.out.println("1. Alquilar cámara");
        System.out.println("2. Devolver cámara");
        System.out.println("3. Listar cámaras disponibles");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarInventario(Inventory inventory) {
        inventory.agregarCamara(new Camera("Nikon", "Camera", "F6", true));
        inventory.agregarCamara(new Camera("Canon", "Camera", "AE-1", false));
        inventory.agregarCamara(new Camera("Pentax", "Camera", "K1000", true));

        inventory.agregarPelicula(new Film("Kodak", "Portra 400", 400, "35mm"));
        inventory.agregarPelicula(new Film("Fujifilm", "Superia X-TRA 400", 400, "35mm"));
    }

    private static void alquilarCamara(Scanner scanner) {
        System.out.println("Ingrese su ID de estudiante:");
        String idEstudiante = scanner.nextLine();
        Customer cliente = obtenerCliente(scanner, idEstudiante);

        System.out.println("Ingrese el modelo de la cámara a alquilar:");
        String modelo = scanner.nextLine();
        Camera camara = inventory.buscarCamara(modelo);

        if (camara != null && cliente.alquilarCamara(camara)) {
            System.out.println("Cámara alquilada exitosamente.");
        } else {
            System.out.println("No se pudo alquilar la cámara.");
        }
    }

    private static void devolverCamara(Scanner scanner) {
        System.out.println("Ingrese su ID de estudiante:");
        String idEstudiante = scanner.nextLine();
        Customer cliente = clientes.get(idEstudiante);

        if (cliente != null) {
            cliente.devolverCamara();
            System.out.println("Cámara devuelta exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarCamarasDisponibles() {
        System.out.println("Cámaras disponibles:");
        for (Camera c : inventory.listarCamarasDisponibles()) {
            System.out.println("Marca: " + c.getMarca() + ", Modelo: " + c.getModelo());
        }
    }

    private static Customer obtenerCliente(Scanner scanner, String idEstudiante) {
        Customer cliente = clientes.get(idEstudiante);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Ingrese su nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese su apellido:");
            String apellido = scanner.nextLine();
            cliente = new Customer(nombre, apellido, idEstudiante);
            clientes.put(idEstudiante, cliente);
        }
        return cliente;
    }
}
