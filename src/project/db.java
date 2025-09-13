/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author zahaalbaadi
 */
public class db {
    
//    Connection con = null;
    public static Connection java_db(){
    
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopp","root","MySql111");
            return con;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
