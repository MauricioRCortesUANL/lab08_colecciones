public class Guerrero extends Personaje {
    private int energia;

    public Guerrero(String nombre, int nivel, int puntosVida, int energia) {
        super(nombre, nivel, puntosVida);
        this.energia = energia;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        
        if (energia < 20) {
            throw new RecursoInsuficienteException("energía", energia);
        }
        
        energia -= 20;
        System.out.println("[" + getNombre() + "] asesta un golpe devastador con su espada. Energía restante: " + energia);
    }

    @Override
    public int calcularDanio() {
        return 60; 
    }
}