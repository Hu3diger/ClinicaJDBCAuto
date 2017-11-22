package model;

import java.sql.Time;

/**
 *
 * @author Martin_Ruediger
 */
public class pac_vis extends Entity{
    
    private int id;
    private Time horario_inicial;
    private Time horario_final;
    private String status;
    private Paciente paciente;
    private quarto quarto;
    private Medico medico;

    public pac_vis() {
    }

    public pac_vis(int id, Time horario_inicial, Time horario_final, String status, Paciente paciente, quarto quarto, Medico medico) {
        this.id = id;
        this.horario_inicial = horario_inicial;
        this.horario_final = horario_final;
        this.status = status;
        this.paciente = paciente;
        this.quarto = quarto;
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

    public Time getHorario_inicial() {
        return horario_inicial;
    }

    public void setHorario_inicial(Time horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public Time getHorario_final() {
        return horario_final;
    }

    public void setHorario_final(Time horario_final) {
        this.horario_final = horario_final;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(quarto quarto) {
        this.quarto = quarto;
    }
    
    
}
