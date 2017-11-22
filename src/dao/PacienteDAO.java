package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Paciente;

/**
 *
 * @author Martin_Ruediger
 */
public class PacienteDAO extends AbstractDAO<Paciente> {

    public PacienteDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO paciente (nome,rg,cpf,nascimento) VALUES (?,?,?,?)";
        this.SQL_UPDATE = "UPDATE paciente SET nome=?,rg=?,cpf=?,nascimento=? WHERE id=?";
    }

    @Override
    public Paciente fillObject(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(rs.getInt("id"));
        paciente.setNome(rs.getString("nome"));
        paciente.setRg(rs.getString("rg"));
        paciente.setCpf(rs.getString("cpf"));
        paciente.setNascimento(rs.getDate("nascimento").toLocalDate());
        return paciente;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, Paciente paciente) throws SQLException {
        int ParameterIndex = 1;
        stmt.setString(ParameterIndex++, paciente.getNome());
        stmt.setString(ParameterIndex++, paciente.getRg());
        stmt.setString(ParameterIndex++, paciente.getCpf());
        stmt.setDate(ParameterIndex++, java.sql.Date.valueOf(paciente.getNascimento()));
        return ParameterIndex;
    }

}
