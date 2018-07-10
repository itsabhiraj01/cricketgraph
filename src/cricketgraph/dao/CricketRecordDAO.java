/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketgraph.dao;

import cricketgraph.pojo.CricketRecord;
import cricketgraph.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ABHIRAJ
 */
public class CricketRecordDAO {
    
    public static ResultSet getRecord() throws SQLException {
        String qry = "SELECT * FROM cricket";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecord(int year) throws SQLException {
        String qry = "SELECT * FROM cricket where year=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecord(String first) throws SQLException {
        String qry = "SELECT * FROM cricket where first=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,first);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecordFormat(String format) throws SQLException {
        String qry = "SELECT * FROM cricket where format=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,format);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecord(String first, String format) throws SQLException {
        String qry = "SELECT * FROM cricket where first=? AND format=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,first);
        ps.setString(2,format);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecord(String format, int year) throws SQLException {
        String qry = "SELECT * FROM cricket where year=? and format=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setInt(1,year);
        ps.setString(2,format);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecordWOFormat(String first, int year) throws SQLException {
        String qry = "SELECT * FROM cricket where first=? and year=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,first);
        ps.setInt(2,year);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet getRecord(String first, String format, int year) throws SQLException {
        String qry = "SELECT * FROM cricket where first=? and format=? AND year=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,first);
        ps.setString(2,format);
        ps.setInt(3,year);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public static boolean addRecord(CricketRecord cricketRecord) throws SQLException {
        String qry = "INSERT INTO cricket(first,format,year,score,last) values(?,?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,cricketRecord.getFirst());
        ps.setString(2,cricketRecord.getFormat());
        ps.setInt(3,cricketRecord.getYear());
        ps.setInt(4,cricketRecord.getScore());
        ps.setString(5,cricketRecord.getLast());
        boolean result = ps.execute();
        return result;
    }
    
    public static ResultSet getAllNames() throws SQLException {
        String qry = "SELECT * FROM cricket";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
