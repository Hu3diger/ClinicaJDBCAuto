package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Martin_Ruediger
 */
public class Medico extends Entity{
    
    private int crm;
    private String nome;
    private LocalDate admissao;
    private Double salario;

    public Medico() {
    }

    public Medico(int crm, String nome, LocalDate admissao, Double salario) {
        super(crm);
        this.crm = crm;
        this.nome = nome;
        this.admissao = admissao;
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    @Override
    public void setId(int crm) {
        super.setId(crm);
    }

    @Override
    public int getId() {
        return super.getId();
    }
    
    
    
}
