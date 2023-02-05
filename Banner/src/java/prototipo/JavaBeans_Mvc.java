/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package prototipo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michel
 */
@WebServlet(name = "JavaBeans_Mvc", urlPatterns = {"/JavaBeans_Mvc"})
public class JavaBeans_Mvc extends HttpServlet {
    
    String bancodb;
    String sessaodb;

    @Override
    public void init() {
        /*bd_us = this.getServletContext().getInitParameter("bd_user");
        bd_pw = this.getServletContext().getInitParameter("bd_pw");*/
        bancodb = "prototipo";
       sessaodb = "senhabd";
    }
    

    public boolean validaLogin(String _nome, String _senha) throws ServletException {

        // return _nome.equalsIgnoreCase(no) && _senha.equals(pw);
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/Prototipo_I";
        //  Database credentials
        Connection conn = null;
        java.sql.Statement stmt = null;
        String resp = "EXECUTOU";
        // Set response content type
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, bancodb, sessaodb);
            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nomeusuario, senha FROM prototipo_i where upper(nomeusuario) = '"
                    + _nome.toUpperCase() + "' and senha='" + _senha + "'";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            if (rs.next()) {
                result = true;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            //Handle errors for JDBC
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            //Handle errors for Class.forName
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        } finally {
            System.out.printf(resp);
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }//end finally try
        } //end try    
        return result;
    }
}
