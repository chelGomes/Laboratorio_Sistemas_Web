/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michel
 */
public class usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String bancodb;
    String sessaodb;
    
    public void init(){
       /* bancodb = getInitParameter("bancodb");
        sessaodb = getInitParameter("sessaodb");*/
       bancodb = "aula";
       sessaodb = "aula";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            //session.setAttribute("loggedIn", new String("false"));
            //session.invalidate(); //invalida os atributos da sessão
            response.sendRedirect("index.jsp");
        } else {
            boolean result = false;
            String resp;
            String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
            String DB_URL = "jdbc:derby://localhost:1527/Usuario_JSP";
            //  Database credentials
            Connection conn = null;
            Statement stmt = null;
            try {
                // Register JDBC driver
                Class.forName(JDBC_DRIVER);
                // Open a connection
                conn = DriverManager.getConnection(DB_URL, bancodb, sessaodb);
                // Execute SQL query
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT * FROM usuario";

                ResultSet rs = stmt.executeQuery(sql);
                PrintWriter out = response.getWriter();

                ArrayList<String> listaNomes = new ArrayList();
                while (rs.next()) {
                    listaNomes.add(rs.getString("NOME"));
                }                
                request.setAttribute("nomes", listaNomes);
                getServletContext().getRequestDispatcher("/usuario.jsp").forward(request, response);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Usuário </h1>");
                while (rs.next()) {
                    out.println("<p>" + rs.getString("nome") + "</p>" + "<br>");
                }
                out.println("<a href=\"menu.jsp\">Voltar</a>");
                out.println("</body>");
                out.println("</html>");

                // Extract data from result set
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
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
