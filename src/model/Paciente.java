package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Martin_Ruediger
 */
public class Paciente extends Entity{
    
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private LocalDate nascimento;

    public Paciente(int id, String nome, String rg, String cpf, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public Paciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    
    
}
