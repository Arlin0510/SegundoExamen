package Pregunta2;

import java.util.ArrayList;

public class Linea {
    private String color;
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Cabina> cabinas;
    
    // Constructor
    public Linea(String color) {
        this.color = color;
        this.listaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();
    }
    
    // Getters
    public String getColor() {
        return color;
    }
    
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
    
    public ArrayList<Cabina> getCabinas() {
        return cabinas;
    }
    
    // Métodos existentes del diagrama
    public void agregarPersona(Persona p) {
        listaPersonas.add(p);
    }
    
    public void agregarCabina(Cabina cabina) {
        cabinas.add(cabina);
    }
    
    // b) Verificar que todas las cabinas cumplan las reglas
    public boolean verificarReglasCabinas() {
        for (Cabina cabina : cabinas) {
            if (!cabina.cumpleReglasAbordo()) {
                System.out.println("Cabina " + cabina.getNroCabina() + " no cumple las reglas");
                return false;
            }
        }
        System.out.println("Todas las cabinas de línea " + color + " cumplen las reglas");
        return true;
    }
    
    // c) Calcular ingresos totales de la línea
    public float calcularIngresoTotal() {
        float total = 0;
        for (Cabina cabina : cabinas) {
            total += cabina.calcularIngresos();
        }
        return total;
    }
    
    // Calcular ingresos solo con tarifa regular
    public float calcularIngresoRegular() {
        float total = 0;
        for (Cabina cabina : cabinas) {
            total += cabina.calcularIngresosRegulares();
        }
        return total;
    }
    
    // Método para agregar cabina con número automático
    public void agregarCabina() {
        int nroCabina = cabinas.size() + 1;
        cabinas.add(new Cabina(nroCabina));
        System.out.println("Cabina " + nroCabina + " agregada a línea " + color);
    }
    
    public Cabina getCabina(int nroCabina) {
        for (Cabina cabina : cabinas) {
            if (cabina.getNroCabina() == nroCabina) {
                return cabina;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Línea " + color + " - Cabinas: " + cabinas.size() + 
               ", Ingreso total: " + calcularIngresoTotal() + " bs";
    }
}