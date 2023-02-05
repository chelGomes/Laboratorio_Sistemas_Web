/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package code;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michel
 */
@WebServlet(name = "valida_login", urlPatterns = {"/valida_login"}, initParams = {
    @WebInitParam(name = "usuario", value = "michel"),
    @WebInitParam(name = "password", value = "12345")})
public class valida_login extends HttpServlet {
    
        String login;
        String senha;
    
   
        @Override
        public void init(){
            login = getInitParameter("usuario");
            senha = this.getInitParameter("password");
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
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("password");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Valida_login</title>");            
            out.println("</head>");
            out.println("<body>");
            
              if (!login.equals(usuario)) {
                out.println("<div class=\"erro\"><h1> Usuário não encontrado.</h1></div>");
            } else if (!senha.equals(senha)) {
                    response.sendRedirect("erro");
            } else {
                out.println("<div class=\"acerto\"><h1 class=\"item\">Bem vindo!</h1></div>");
            }  
            out.println("</body>");
            out.println("</html>");
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
        
         /*String firstName = request.getParameter("firstname");
         String password = request.getParameter("password");
                
        ServletContext sc = getServletContext();
        
        String versao = sc.getInitParameter("versao");
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("<body>");
        out.println("<h1>"+login+" "+firstName+"</h1>");
        out.println("<h1>"+senha+" "+password+"</h1>");
        out.println("<br><br><p>Versao:"+versao+"</p>");
        out.println("</body>");*/
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
