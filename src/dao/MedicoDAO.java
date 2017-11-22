package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Medico;

/**
 *
 * @author martin_ruediger
 */
public class MedicoDAO extends AbstractDAO<Medico>{

    public MedicoDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO medico (nome,admissao,salario) VALUES (?,?,?)";
        this.SQL_UPDATE = "UPDATE medico SET nome=?,admissao=?,salario=? WHERE id=?";
    }

    @Override
    public Medico fillObject(ResultSet rs) throws SQLException {
        Medico medico = new Medico();
        medico.setCrm(rs.getInt("crm"));
        medico.setNome(rs.getString("nome"));
        medico.setAdmissao(rs.getDate("admissao").toLocalDate());
        medico.setSalario(rs.getDouble("salario"));
        return medico;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, Medico medico) throws SQLException {
        int ParameterIndex = 1;
        stmt.setString(ParameterIndex++, medico.getNome());
        stmt.setDate(ParameterIndex++, java.sql.Date.valueOf(medico.getAdmissao()));
        stmt.setDouble(ParameterIndex++, medico.getSalario());
        return ParameterIndex;
   }
    
    
    
}
