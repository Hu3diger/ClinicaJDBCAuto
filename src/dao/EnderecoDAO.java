package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;

/**
 *
 * @author Aluno
 */
public class EnderecoDAO extends AbstractDAO<Endereco>{

    public EnderecoDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO endereco (rua,bairro,cidade,paciente_id) VALUES (?,?,?,?)";
        this.SQL_UPDATE = "UPDATE endereco SET rua=?,bairro=?,cidade=?,paciente_id=? WHERE id=?";
    }

    @Override
    public Endereco fillObject(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setRua(rs.getString("rua"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setPaciente(new PacienteDAO().findById(rs.getInt("paciente_id")));
        return endereco;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, Endereco endereco) throws SQLException {
        int parameterIndex = 1;
        stmt.setString(parameterIndex++, endereco.getRua());
        stmt.setString(parameterIndex++, endereco.getBairro());
        stmt.setString(parameterIndex++, endereco.getCidade());
        stmt.setInt(parameterIndex++, endereco.getPaciente().getId());
        return parameterIndex;
    }
}
    

