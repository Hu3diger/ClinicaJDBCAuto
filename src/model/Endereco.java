package model;

/**
 *
 * @author Martin_Ruediger
 */
public class Endereco extends Entity {
    
    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private Paciente paciente;

    public Endereco() {
    }

    public Endereco(int id, String rua, String bairro, String cidade, Paciente paciente) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.paciente = paciente;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
}
