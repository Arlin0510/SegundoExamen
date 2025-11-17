package Pregunta2;

public class Main {
    public static void main(String[] args) {
        // Crear el sistema MiTeleférico
        MiTeleferico teleferico = new MiTeleferico();
        
        // Agregar cabinas a las líneas
        teleferico.agregarCabina("Amarillo");
        teleferico.agregarCabina("Amarillo");
        teleferico.agregarCabina("Rojo");
        teleferico.agregarCabina("Verde");
        
        // Crear personas
        Persona p1 = new Persona("Juan", 30, 70.5f);   // Tarifa regular (3 bs)
        Persona p2 = new Persona("Ana", 20, 55.0f);    // Tarifa preferencial (1.5 bs)
        Persona p3 = new Persona("Carlos", 65, 80.0f); // Tarifa preferencial (1.5 bs)
        Persona p4 = new Persona("Maria", 35, 60.0f);  // Tarifa regular (3 bs)
        Persona p5 = new Persona("Luis", 28, 75.0f);   // Tarifa regular (3 bs)
        
        // Agregar personas a cabinas específicas
        Linea lineaAmarillo = teleferico.getLinea("Amarillo");
        if (lineaAmarillo != null) {
            Cabina cabina1 = lineaAmarillo.getCabina(1);
            if (cabina1 != null) {
                cabina1.agregarPrimeraPersona(p1); // Primera persona
                cabina1.agregarPersona(p2);
            }
            
            Cabina cabina2 = lineaAmarillo.getCabina(2);
            if (cabina2 != null) {
                cabina2.agregarPrimeraPersona(p3);
            }
        }
        
        Linea lineaRojo = teleferico.getLinea("Rojo");
        if (lineaRojo != null) {
            Cabina cabina1 = lineaRojo.getCabina(1);
            if (cabina1 != null) {
                cabina1.agregarPrimeraPersona(p4);
                cabina1.agregarPersona(p5);
            }
        }
        
        // Ejecutar los métodos requeridos
        teleferico.verificarTodasLasCabinas(); // Punto b
        
        System.out.println("INGRESO TOTAL"); // Punto c
        System.out.println("Ingreso total del sistema: " + teleferico.calcularIngresoTotal() + " bs");
        
        teleferico.mostrarLineaConMasIngresoRegular(); // Punto d
        
        // Mostrar resumen completo
        teleferico.mostrarResumen();
    }
}