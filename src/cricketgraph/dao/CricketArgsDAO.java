/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketgraph.dao;

import cricketgraph.pojo.CricketArgs;
import cricketgraph.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ABHIRAJ
 */
public class CricketArgsDAO {
    public static boolean addCricketArgs(CricketArgs cricketArgs) throws SQLException {
        String qry = "INSERT INTO cricketargs(first,format,year) values(?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,cricketArgs.getFirst());
        ps.setString(2,cricketArgs.getFormat());
        ps.setInt(3,cricketArgs.getYear());
        boolean result = ps.execute();
        return result;
    }
    public static boolean truncateCricketArgs() throws SQLException {
        String qry = "DELETE FROM cricketargs";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        boolean result = ps.execute();
        return result;
    }
}
