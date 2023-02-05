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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michel
 */
public class Control_Sessao_Prototipo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*Prototipo, senhabd*/
    
    String bancodb;
    String sessaodb;

    @Override
    public void init() {
        /*bd_us = this.getServletContext().getInitParameter("bd_user");
        bd_pw = this.getServletContext().getInitParameter("bd_pw");*/
        bancodb = "prototipo";
       sessaodb = "senhabd";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pega a sessao
        HttpSession session = request.getSession(true);
        String code = request.getParameter("code");
        if (code != null && code.equals("sair")) {
            session.setAttribute("logado", false);
            
        }
       
        if (code != null && code.equals("menu")) {
            session.setAttribute("logado", false);
            
        }
        boolean logado = false;
        Object tmp = session.getAttribute("logado");
        if (tmp != null && (boolean) tmp) {
            logado = true;
        }

        String nome = request.getParameter("Prototipo");
        String senha = request.getParameter("senhabd");

        if (!logado) {
            if (nome != null) {
                // quer fazer login
                if (validaLogin(nome, senha)) {
                    session.setAttribute("logado", true);
                    logado = true;
                } else {
                    session.setAttribute("msg", "Login inválido!");
                }
            } /*else {
                session.setAttribute("msg", "Sessão expirou!!");
                // expirou a sessao
            }*/
        }
        if (logado) {
            if(code == null){
                response.sendRedirect("Menu_Prototipo.jsp");
            }else{
                System.out.println(code);
                switch (code){
                    case("welcome"):
                        response.sendRedirect("Welcome.jsp");
                        break;
                        
                    case("Menu_Prototipo"):
                        response.sendRedirect("Menu_Prototipo.jsp");
                        break;
                        
                    case("erroJava"):
                        response.sendRedirect("erro.jsp");
                        break;
                        
                    case("erro404"):
                        response.sendRedirect("erro2.jsp");
                        break;
                        
                    case("voltamenu"):
                        response.sendRedirect("Menu_Prototipo.jsp");
                        break;
                        
                    case("ajudaMvc"):
                        response.sendRedirect("Ajuda_Mvc.jsp");
                        break;
                        
                    default:
                        session.setAttribute("loggedIn", "FALSE");
                        response.sendRedirect("index.jsp");
                        break;    
                }
                    
            
            }
            
            
        } else {
              response.sendRedirect("index.jsp");
        }
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
