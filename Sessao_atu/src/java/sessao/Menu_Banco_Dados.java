/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sessao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michel
 */
public class Menu_Banco_Dados extends HttpServlet {
    
    String bancodb;
    String sessaodb;

    public void init() {
        bancodb = getInitParameter("bancodb");
        sessaodb = getInitParameter("sessaodb");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loggedIn = null;
        HttpSession session = request.getSession(false);
        // Sessão não existe
        if(session == null || session.getAttribute("loggedIn") == null){
                //Valida Login
                String user = request.getParameter("usuario");
                String password = request.getParameter("senha");
                if(logar(user, password)){
                    //Cria sessão e cria variável
                    session=request.getSession(true);
                    session.setAttribute("loggedIn", new String("true"));
                    response.sendRedirect("menu_sessao.html");
                }
                else
                    response.sendRedirect("Menu_Banco_Dados2");
            }
        
        //sessão existe
        else {
            loggedIn = (String) session.getAttribute("loggedIn");
            if(!(loggedIn != null && loggedIn.equals("true")))
                response.sendRedirect("index.html");
                
            else
               response.sendRedirect("menu_sessao.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
public boolean logar(String user, String pass) throws IOException, ServletException {
        String resp;
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/Aula_Banco_Dados";
        //  Database credentials
        Connection conn = null;
        Statement stmt = null;
        // Set response content type
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, bancodb, sessaodb);
            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nome, senha FROM usuario where nome = '"
                    + user + "' and senha='" + pass + "'";
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
        if (result) {
            return true;
        } else {
            return false;
        }
    }

}
