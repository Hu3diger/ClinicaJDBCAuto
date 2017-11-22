package model;

/**
 *
 * @author Martin_Ruediger
 */
public class quarto extends Entity{
    
    private int id;
    private int andar;
    private int numero;

    public quarto() {
    }

    public quarto(int id, int andar, int numero) {
        this.id = id;
        this.andar = andar;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
    
    
    
}
