package model;

/**
 *
 * @author Martin_Ruediger
 */
public class Telefone extends Entity{
    
    private int id;
    private String numero;
    private Paciente paciente;

    public Telefone() {
    }

    public Telefone(int id, String numero, Paciente paciente) {
        this.id = id;
        this.numero = numero;
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}
