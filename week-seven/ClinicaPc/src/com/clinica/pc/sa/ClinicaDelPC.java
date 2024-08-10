package com.clinica.pc.sa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class Cliente {
    private String nombre;
    private String telefono;
    private String identificadorUnico;

    public Cliente(String nombre, String identificadorUnico, String telefono) {
        this.nombre = nombre;
        this.identificadorUnico = identificadorUnico;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getIdentificadorUnico() {
        return identificadorUnico;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + ", ID: " + identificadorUnico;
    }
}

class Computador {
    private String marca;
    private String modelo;
    private int memoriaRAM;
    private String procesador;
    private String sistemaOperativo;
    private double costo;

    public Computador(String marca, String modelo, int memoriaRAM, String procesador, String sistemaOperativo, double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaRAM = memoriaRAM;
        this.procesador = procesador;
        this.sistemaOperativo = sistemaOperativo;
        this.costo = costo;
    }
    
    @Override
    public String toString() {
        return "Computador: " + marca + " " + modelo +
        		", RAM: " + memoriaRAM + "GB, " +
        		"Procesador: " + procesador +
        		", SO: " + sistemaOperativo +
        		", Costo: $" + costo;
    }
}

public class ClinicaDelPC {
    private ArrayList<Cliente> clientes;
    private ArrayList<Computador> computadores;
    private Map<String, String> propietarios;
    private Set<String> identificadoresClientes;
    private Map<String, String> clientesMap;
    private Map<String, Cliente> clientesTreeMap;

    public ClinicaDelPC() {
        clientes = new ArrayList<>();
        computadores = new ArrayList<>();
        propietarios = new HashMap<>();
        identificadoresClientes = new HashSet<>();
        clientesMap = new HashMap<>();
        clientesTreeMap = new TreeMap<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarClienteSet(Cliente cliente) {
        if (identificadoresClientes.add(cliente.getIdentificadorUnico())) {
            System.out.println("Cliente agregado: " + cliente.getNombre());
        } else {
            System.out.println("Cliente ya existe con identificador: " + cliente.getIdentificadorUnico());
        }
    }
    
    public void agregarClienteMap(Cliente cliente) {
    	clientesMap.put(cliente.getNombre(), cliente.getTelefono());
        System.out.println("Cliente agregado: " + cliente.getNombre());
    }

    public void agregarComputador(Computador computador) {
        computadores.add(computador);
    }

    public Cliente buscarCliente(String identificadorUnico) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificadorUnico().equals(identificadorUnico)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void listarClientes() {
    	System.out.println("\nListado de Clientes");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarComputadores() {
    	System.out.println("\nListado de Computadores");
        for (Computador computador : computadores) {
            System.out.println(computador);
        }
    }
    
    public void listarPropietarios() {
        System.out.println("\nListado de Propietarios:");
        for (Map.Entry<String, String> entrada : propietarios.entrySet()) {
            System.out.println("Nombre: " + entrada.getKey() + ", Teléfono: " + entrada.getValue());
        }
    }
    
    public void agregarPropietario(String nombre, String telefono) {
        propietarios.put(nombre, telefono);
    }

    public String obtenerTelefono(String nombre) {
        return propietarios.get(nombre);
    }

    public String buscarTelefonoPorNombre(String nombre) {
        return clientesMap.get(nombre);
    }
    
    public void agregarClienteTreeMap(Cliente cliente) {
        clientesTreeMap.put(cliente.getIdentificadorUnico(), cliente);
    }

    public Cliente buscarClienteTreeMap(String identificadorUnico) {
        return clientesTreeMap.get(identificadorUnico);
    }
    
    public static void main(String[] args) {
        ClinicaDelPC clinica = new ClinicaDelPC();
        
        Cliente cliente1 = new Cliente("Juan Perez", "1234", "98765432");
        Cliente cliente2 = new Cliente("Maria Lopez", "5678", "65498732");

        Computador computador1 = new Computador("Dell", "Inspiron", 8, "Intel i5", "Windows 10", 500.00);
        Computador computador2 = new Computador("Apple", "MacBook Pro", 16, "M1", "macOS", 1500.00);

        clinica.agregarCliente(cliente1);
        clinica.agregarCliente(cliente2);

        clinica.agregarComputador(computador1);
        clinica.agregarComputador(computador2);

        clinica.listarClientes();
        clinica.listarComputadores();
       
        
        System.out.println("\n*** PREGUNTA N°1:");
        System.out.println("Búsqueda de Cliente (Id): 1234");
        Cliente clienteEncontrado = clinica.buscarCliente("1234");
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre());
        } else {
            System.out.println("Cliente no encontrado");
        }
        
        System.out.println("\n*** PREGUNTA N°2:");
        clinica.agregarPropietario("Claudio Garrido", "555-1234");
        clinica.agregarPropietario("Alicia Fernandez", "555-5678");
        clinica.listarPropietarios();
        
        System.out.println("\nBúsqueda teléfon Propietario: Claudio Garrido");
        String telefono = clinica.obtenerTelefono("Claudio Garrido");
        if (telefono != null) {
            System.out.println("Teléfono de Juan Perez: " + telefono);
        } else {
            System.out.println("Propietario no encontrado");
        }
        
        System.out.println("\n*** PREGUNTA N°3:");
        System.out.println("--- SET ---");
        clinica.agregarClienteSet(new Cliente("Juan Perez SET", "1234", "35796385"));
        clinica.agregarClienteSet(new Cliente("Maria Lopez SET", "5678", "25896385"));
        clinica.agregarClienteSet(new Cliente("Juan Perez SET", "1234", "75378945")); // Duplicado
              
        System.out.println("--- MAP ---");

        clinica.agregarClienteMap(new Cliente("Rumilio Perez", "555-1234", "77766655"));
        clinica.agregarClienteMap(new Cliente("Lazlo Lopez", "555-5678", "33344466"));

        String telefonoMap = clinica.buscarTelefonoPorNombre("Rumilio Perez");
        System.out.println("Teléfono de Rumilio Perez: " + telefonoMap);
        
        System.out.println("\n*** PREGUNTA N°4:");
        
        clinica.agregarClienteTreeMap(new Cliente("Juan Perez TreeMap", "4321", "65432155"));
        clinica.agregarClienteTreeMap(new Cliente("Maria Lopez TreeMap", "5678", "22233366"));

        Cliente clienteEncontradoTreeMap = clinica.buscarClienteTreeMap("4321");
        System.out.println("Cliente encontrado: " + clienteEncontradoTreeMap.getNombre());
        
    }
}
