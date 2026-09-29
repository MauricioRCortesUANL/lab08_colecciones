public class Main {
    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();

        System.out.println("--- Bloque 1: Gestión de roster ---");
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco Largo", 20, 95));
        
        // Constructor adaptado a la clase Guerrero del Lab07 (nombre, nivel, vida, energia)
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80)); 
        
        gremio.mostrarRoster();
        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();
        
        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        System.out.println("\n--- Bloque 2: Cola de espera ---");
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();
        gremio.atenderSiguiente();
        gremio.mostrarCola();

        System.out.println("\n--- Bloque 3: Inventario ---");
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        System.out.println("\n--- Bloque 4: Habilidades ---");
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();
        System.out.println("¿Tiene Tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene Curación? " + gremio.tieneHabilidad("Curación"));

        System.out.println("\n--- Bloque 5: Resumen del gremio ---");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}