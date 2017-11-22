package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Telefone;

/**
 *
 * @author Martin_Ruediger
 */
public class TelefoneDAO extends AbstractDAO<Telefone>{

    @Override
    public Telefone fillObject(ResultSet rs) throws SQLException {
        Telefone telefone = new Telefone();
        telefone.setId(rs.getInt("id"));
        telefone.setNumero(rs.getString("numero"));
        telefone.setPaciente(new PacienteDAO().findById(rs.getInt("paciente_id")));
        return telefone;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, Telefone telefone) throws SQLException {
        int ParameterIndex = 1;
        stmt.setString(ParameterIndex++, telefone.getNumero());
        stmt.setInt(ParameterIndex++, telefone.getPaciente().getId());
        return ParameterIndex;
    }

    
    
}
