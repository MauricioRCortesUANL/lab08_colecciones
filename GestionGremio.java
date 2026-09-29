import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GestionGremio {

    private ArrayList roster;
    private LinkedList colaTurnos;
    private HashMap inventario;
    private HashSet habilidades;

    public GestionGremio() {
        this.roster = new ArrayList();
        this.colaTurnos = new LinkedList();
        this.inventario = new HashMap();
        this.habilidades = new HashSet();
    }

    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────
    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator it = roster.iterator(); 
        while (it.hasNext()) {
            Personaje p = (Personaje) it.next(); 
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = (Personaje) roster.get(i); 
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = (Personaje) roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                               " | Nivel: " + p.getNivel() +
                               " | Vida: " + p.getPuntosVida());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 2 — LinkedList: cola de turnos
    // ──────────────────────────────────────────
    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);
        System.out.println("[Cola] " + nombre + " en posición " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("[Cola] No hay solicitantes en espera.");
            return null;
        }
        String atendido = (String) colaTurnos.removeFirst();
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int pos = 1;
        for (Object obj : colaTurnos) {
            String nombre = (String) obj;
            System.out.println(pos++ + ". " + nombre);
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 3a — HashMap: inventario de objetos
    // ──────────────────────────────────────────
    public void agregarItem(String item, int cantidad) {
        int cantidadActual = 0;
        if (inventario.containsKey(item)) {
            cantidadActual = (Integer) inventario.get(item);
        }
        inventario.put(item, cantidadActual + cantidad);
        
        if (cantidadActual == 0) {
            System.out.println("[Inventario] " + item + ": " + cantidad);
        } else {
            System.out.println("[Inventario] " + item + ": " + (cantidadActual + cantidad) + " (acumulada)");
        }
    }

    public void usarItem(String item) {
        if (!inventario.containsKey(item)) {
            System.out.println("[Inventario] No existe en inventario: " + item);
            return;
        }
        
        int cantidad = (Integer) inventario.get(item);
        if (cantidad > 0) {
            cantidad--;
            if (cantidad == 0) {
                inventario.remove(item);
                System.out.println("[Inventario] " + item + " agotada/o y eliminada/o del inventario.");
            } else {
                inventario.put(item, cantidad);
                System.out.println("[Inventario] " + item + " usada. Restante: " + cantidad);
            }
        }
    }

    public void mostrarInventario() {
        System.out.println("\n=== Inventario del Gremio ===");
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Object obj : inventario.entrySet()) {
                Map.Entry entry = (Map.Entry) obj;
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 3b — HashSet: habilidades únicas
    // ──────────────────────────────────────────
    public void registrarHabilidad(String habilidad) {
        boolean nueva = habilidades.add(habilidad);
        if (nueva) {
            System.out.println("[Habilidades] " + habilidad + " registrada.");
        } else {
            System.out.println("[Habilidades] " + habilidad + " ya estaba registrada.");
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades() {
        System.out.println("\n=== Habilidades del Gremio ===");
        if (habilidades.isEmpty()) {
            System.out.println("No hay habilidades registradas.");
        } else {
            for (Object obj : habilidades) {
                String hab = (String) obj;
                System.out.println("- " + hab);
            }
        }
    }
}