public class Carta {
    private String nombre;
    private String clase;
    private int costoMana;
    private int ataque;
    private int vida;

    public Carta(String nombre, String clase, int costoMana, int ataque, int vida) {
        this.nombre = nombre;
        this.clase = clase;
        this.costoMana = costoMana;
        this.ataque = ataque;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " | Clase: " + clase + " | Maná: " + costoMana + " | Ataque: " + ataque + " | Vida: " + vida;
    }
}
