/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketgraph.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHIRAJ
 */
public class DBConnection {
    
    private static Connection conn;
    
    static {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Sachin-PC/orcl","chatdata","chatapp");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hadoop","root","");
            JOptionPane.showMessageDialog(null,"Connected succesfull to the database","Success!",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        if(conn == null) {
            System.out.println("Not connected");
        }
        else {
            System.out.println("Connected to server");
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void closeConnection() {
        try {
            if(conn != null) 
                conn.close();
            JOptionPane.showMessageDialog(null,"Disconnectd successfully from the database","Success!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error Disconnection from the database" + e,"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }
}