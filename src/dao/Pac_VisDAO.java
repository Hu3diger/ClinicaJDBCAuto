package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.pac_vis;

/**
 *
 * @author Martin_Ruediger
 */
public class Pac_VisDAO extends AbstractDAO<pac_vis>{

    public Pac_VisDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO paciente_visita (horario_inicial, horario_final, state, paciente_id, quarto_id, medico_id) VALUES (?,?,?,?,?,?)";
        this.SQL_UPDATE = "UPDATE paciente_visita SET horario_inicial=?,horario_final=?,state=?,paciente_id=?,quarto_id=?,medico_id=? WHERE id=?";
    }
    
    
    
    @Override
    public pac_vis fillObject(ResultSet rs) throws SQLException {
        pac_vis pacvis = new pac_vis();
        pacvis.setHorario_inicial(rs.getTime("horario_inicial"));
        pacvis.setHorario_final(rs.getTime("horario_final"));
        pacvis.setStatus(rs.getString("state"));
        pacvis.setPaciente(new PacienteDAO().findById(rs.getInt("paciente_id")));
        pacvis.setQuarto(new QuartoDAO().findById(rs.getInt("quarto_id")));
        pacvis.setMedico(new MedicoDAO().findById(rs.getInt("medico_crm")));
        return pacvis;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, pac_vis pacvis) throws SQLException {
        int ParameterIndex = 1;
        stmt.setTime(ParameterIndex++, pacvis.getHorario_inicial());
        stmt.setTime(ParameterIndex++, pacvis.getHorario_final());
        stmt.setString(ParameterIndex++, pacvis.getStatus());
        stmt.setInt(ParameterIndex++, pacvis.getPaciente().getId());
        stmt.setInt(ParameterIndex++, pacvis.getQuarto().getId());
        stmt.setInt(ParameterIndex++, pacvis.getMedico().getId());
        return ParameterIndex;
    }

    
    
}
