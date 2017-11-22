
package dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity;

/**
 *
 * @author bruno.thomas
 */
public abstract class AbstractDAO<T extends Entity> implements IDao<T> {

    protected String SQL_UPDATE;
    protected String SQL_CREATE;
    protected String SQL_DELETE;
    protected String SQL_FINDBYID;
    protected String SQL_FINDALL;

    private Class clazz;

    public AbstractDAO() {
        clazz = ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]);
        this.SQL_FINDALL = "SELECT * FROM " + clazz.getSimpleName();
        this.SQL_FINDBYID = "SELECT * FROM " + clazz.getSimpleName() + " WHERE ID=?";
        this.SQL_DELETE = "DELETE FROM " + clazz.getSimpleName() + " WHERE ID = ?";
    }

    private static ConnectionManager mngr = ConnectionManager.getInstance();

    public T findById(int id) {
        T object = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(SQL_FINDBYID);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                object = fillObject(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return object;
    }

    public List<T> findAll() {
        List<T> listObjects = new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(SQL_FINDALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                listObjects.add(fillObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return listObjects;
    }

    public void update(T object) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(bindingObject(stmt, object), object.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void create(T object) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(SQL_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            bindingObject(stmt, object);
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                object.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }

    public void delete(T object) {
        delete(object.getId());
    }

    public void delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }

    public abstract T fillObject(ResultSet rs) throws SQLException;

    public abstract int bindingObject(PreparedStatement stmt, T object) throws SQLException;

}
