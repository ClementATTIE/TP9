package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import simplejdbc.DAO;
import simplejdbc.DAOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedago
 */
public class selectState extends DAO {

    public selectState(DataSource dataSource) {
        super(dataSource);
    }

    public List<String> states() throws DAOException, SQLException {
        List<String> result = new ArrayList<>();
        String sql = "SELECT DISTINCT STATE FROM CUSTOMER ORDER BY STATE";
        try (Connection connection = myDataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String state = rs.getString("STATE");
                result.add(state);
            }
        } catch (SQLException e) {
            throw new DAOException("erreur"+e.getMessage());
        }
        return result;
    }

}
