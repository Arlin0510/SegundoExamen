package Pregunta2;

public class Persona {
    private String nombre;
    private int edad;
    private float peso;
    
    // Constructor
    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public float getPeso() {
        return peso;
    }
    
    // Métodos adicionales para calcular tarifas
    public float calcularTarifa() {
        if (edad <= 25 || edad > 60) {
            return 1.5f; // Tarifa preferencial
        } else {
            return 3.0f; // Tarifa regular
        }
    }
    
    public boolean esTarifaRegular() {
        return !(edad <= 25 || edad > 60);
    }
    
    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + peso + " kg)";
    }
}