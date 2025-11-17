package Pregunta2;

import java.util.ArrayList;

public class Cabina {
    private int nroCabina;
    private ArrayList<Persona> personasAbordo;
    
    // Constructor
    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }
    
    // Getters
    public int getNroCabina() {
        return nroCabina;
    }
    
    public ArrayList<Persona> getPersonasAbordo() {
        return personasAbordo;
    }
    
    // a) Método para agregar la primera persona
    public boolean agregarPrimeraPersona(Persona p) {
        if (personasAbordo.isEmpty()) {
            return agregarPersona(p);
        }
        return false; // Solo permite si está vacía
    }
    
    public boolean agregarPersona(Persona p) {
        // Verificar máximo 10 personas
        if (personasAbordo.size() >= 10) {
            System.out.println("No se puede agregar: Límite de 10 personas alcanzado");
            return false;
        }
        
        // Verificar peso máximo 850 Kg
        float pesoTotal = calcularPesoTotal();
        if (pesoTotal + p.getPeso() > 850) {
            System.out.println("No se puede agregar: Peso máximo superado");
            return false;
        }
        
        personasAbordo.add(p);
        System.out.println("Persona agregada: " + p.getNombre() + " a cabina " + nroCabina);
        return true;
    }
    
    private float calcularPesoTotal() {
        float total = 0;
        for (Persona p : personasAbordo) {
            total += p.getPeso();
        }
        return total;
    }
    
    public int getCantidadPersonas() {
        return personasAbordo.size();
    }
    
    public float getPesoTotal() {
        return calcularPesoTotal();
    }
    
    // b) Verificar reglas de abordo
    public boolean cumpleReglasAbordo() {
        boolean cumplePersonas = personasAbordo.size() <= 10;
        boolean cumplePeso = calcularPesoTotal() <= 850;
        return cumplePersonas && cumplePeso;
    }
    
    // Calcular ingresos de esta cabina
    public float calcularIngresos() {
        float total = 0;
        for (Persona p : personasAbordo) {
            total += p.calcularTarifa();
        }
        return total;
    }
    
    public float calcularIngresosRegulares() {
        float total = 0;
        for (Persona p : personasAbordo) {
            if (p.esTarifaRegular()) {
                total += 3.0f;
            }
        }
        return total;
    }
    
    public String toString() {
        return "Cabina " + nroCabina + " - Personas: " + getCantidadPersonas() + 
               ", Peso: " + getPesoTotal() + " kg, Ingresos: " + calcularIngresos() + " bs";
    }

}
