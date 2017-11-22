package model;

/**
 *
 * @author Martin_Ruediger
 */
public class med_form extends Entity{
    
    private int id;
    private Formacao formacao;
    private Medico medico;

    public med_form() {
    }

    public med_form(int id, Formacao formacao, Medico medico) {
        this.id = id;
        this.formacao = formacao;
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }
        
        
    
}
