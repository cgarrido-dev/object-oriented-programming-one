package com.microrol.soluciones;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioApp {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}

class Menu {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Venta> ventas = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int contadorIDVenta = 0;

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n\nMenú de Gestión de Inventarios:");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Generar Factura");
            System.out.println("4. Buscar Productos (Mock de Productos cargados en una lista)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    registrarVenta();
                    break;
                case 3:
                    generarFactura();
                    break;
                case 4:
                	mockProductos();
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
            
        } while (opcion != 5);
    }

    private void mockProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Notebook", 1000, true));
        productos.add(new Producto("Mouse", 20, false));
        productos.add(new Producto("Teclado", 50, false));
        productos.add(new Producto("Monitor", 200, true));
        productos.add(new Producto("Impresora", 150, false));

        buscarProductos(productos);
    }
        
    private void registrarProducto() {
        System.out.print("\n\nIngrese nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio;
        
        while (true) {
            System.out.print("Ingrese precio del producto: ");
            if (scanner.hasNextDouble()) {
                precio = scanner.nextDouble();
                scanner.nextLine();
                if (precio > 0) {
                    break;
                } else {
                    System.out.println("El precio debe ser un número positivo. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
        }

        productos.add(new Producto(nombre, precio, false));
        System.out.println("Producto registrado exitosamente.");
    }

    private void registrarVenta() {
        System.out.print("\n\nIngrese nombre del producto vendido: ");
        String nombre = scanner.nextLine();
        Producto productoVendido = buscarProducto(nombre);
        if (productoVendido != null) {
            ventas.add(new Venta(contadorIDVenta, productoVendido));
            System.out.println("Venta registrada exitosamente con ID: " + contadorIDVenta);
            contadorIDVenta++;
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void generarFactura() {
        System.out.print("\n\nIngrese nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese ID de la venta: ");
        int idVenta = scanner.nextInt();
        scanner.nextLine();

        Venta venta = buscarVenta(idVenta);
        if (venta != null) {
            facturas.add(new Factura(cliente, venta));
            System.out.println("Factura generada exitosamente.");
        } else {
            System.out.println("ID de venta no válido.");
        }
    }

    private Venta buscarVenta(int idVenta) {
        for (Venta venta : ventas) {
            if (venta.getId() == idVenta) {
                return venta;
            }
        }
        return null;
    }
    
    private static void buscarProductos(ArrayList<Producto> productos) {
        for (Producto producto : productos) {
            if (!producto.esImportante()) {
                continue;
            }

            System.out.println("Producto importante encontrado: " + producto.getNombre());

            if (producto.getNombre().equalsIgnoreCase("Monitor")) {
                System.out.println("Producto crítico encontrado, deteniendo búsqueda.");
                break;
            }
        }
    }
}

class Producto {
    private String nombre;
    private double precio;
    private boolean importante;

    public Producto(String nombre, double precio, boolean importante) {
        this.nombre = nombre;
        this.precio = precio;
        this.importante = importante;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public boolean esImportante() {
        return importante;
    }
}

class Venta {
    private int id;
    private Producto producto;

    public Venta(int id, Producto producto) {
        this.id = id;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }
}

class Factura {
    private String cliente;
    private Venta venta;

    public Factura(String cliente, Venta venta) {
        this.cliente = cliente;
        this.venta = venta;
    }

    public String getCliente() {
        return cliente;
    }

    public Venta getVenta() {
        return venta;
    }
}
