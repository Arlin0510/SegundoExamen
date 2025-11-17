package Pregunta2;

import java.util.ArrayList;

public class MiTeleferico {
    private ArrayList<Linea> lineas;
    private float cantidadIngresos;
    
    // Constructor
    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadIngresos = 0;
        
        // Inicializar líneas según la nota: Amarillo, Rojo y Verde
        lineas.add(new Linea("Amarillo"));
        lineas.add(new Linea("Rojo"));
        lineas.add(new Linea("Verde"));
    }
    
    // Getters
    public ArrayList<Linea> getLineas() {
        return lineas;
    }
    
    public float getCantidadIngresos() {
        return cantidadIngresos;
    }
    
    // Métodos existentes del diagrama
    public void agregarPersonaFinal(Persona p, String lineaColor) {
        for (Linea linea : lineas) {
            if (linea.getColor().equals(lineaColor)) {
                linea.agregarPersona(p);
                System.out.println("Persona " + p.getNombre() + " agregada a línea " + lineaColor);
                return;
            }
        }
        System.out.println("Línea " + lineaColor + " no encontrada");
    }
    
    public void agregarCabina(String lineaColor) {
        for (Linea linea : lineas) {
            if (linea.getColor().equals(lineaColor)) {
                linea.agregarCabina();
                return;
            }
        }
        System.out.println("Línea " + lineaColor + " no encontrada");
    }
    
    // b) Verificar que todas las cabinas de todas las líneas cumplan las reglas
    public boolean verificarTodasLasCabinas() {
        System.out.println("VERIFICANDO REGLAS DE TODAS LAS CABINAS");
        boolean todasCumplen = true;
        
        for (Linea linea : lineas) {
            if (!linea.verificarReglasCabinas()) {
                todasCumplen = false;
            }
        }
        
        if (todasCumplen) {
            System.out.println("TODAS las cabinas cumplen las reglas de abordo");
        } else {
            System.out.println("ALGUNAS cabinas NO cumplen las reglas de abordo");
        }
        
        return todasCumplen;
    }
    
    // c) Calcular ingreso total de todas las líneas
    public float calcularIngresoTotal() {
        float total = 0;
        for (Linea linea : lineas) {
            total += linea.calcularIngresoTotal();
        }
        this.cantidadIngresos = total;
        return total;
    }
    
    // d) Mostrar la línea con más ingreso solo con tarifa regular
    public Linea getLineaConMasIngresoRegular() {
        Linea lineaMax = null;
        float maxIngreso = -1;
        
        for (Linea linea : lineas) {
            float ingresoRegular = linea.calcularIngresoRegular();
            if (ingresoRegular > maxIngreso) {
                maxIngreso = ingresoRegular;
                lineaMax = linea;
            }
        }
        
        return lineaMax;
    }
    
    public void mostrarLineaConMasIngresoRegular() {
        System.out.println("LÍNEA CON MÁS INGRESO REGULAR");
        Linea linea = getLineaConMasIngresoRegular();
        if (linea != null && linea.calcularIngresoRegular() > 0) {
            System.out.println("Línea con más ingreso regular: " + linea.getColor());
            System.out.println("Ingreso regular: " + linea.calcularIngresoRegular() + " bs");
        } else {
            System.out.println("No hay líneas con ingresos regulares");
        }
    }
    
    // Método auxiliar para obtener una línea por color
    public Linea getLinea(String color) {
        for (Linea linea : lineas) {
            if (linea.getColor().equals(color)) {
                return linea;
            }
        }
        return null;
    }
    
    // Método para mostrar resumen
    public void mostrarResumen() {
        System.out.println("RESUMEN DEL SISTEMA MI TELEFÉRICO");
        for (Linea linea : lineas) {
            System.out.println(linea);
            for (Cabina cabina : linea.getCabinas()) {
                System.out.println("  - " + cabina);
            }
        }
        System.out.println("Ingreso total del sistema: " + calcularIngresoTotal() + " bs");
    }
}