/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package prototipo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Michel
 */
public class Listerner implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    
    public int userCounter;
    private ServletContext servletContext;

    public Listerner(){
        this.userCounter = 0;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         servletContext = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("logado")){
            userCounter++;
            servletContext.setAttribute("userCounter", Integer.toString(userCounter));
            System.out.println("Atributo adicionado: " + event.getName()+ ", Counter: " + userCounter);
        }  
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        userCounter--;
        servletContext.setAttribute("userCounter", Integer.toString(userCounter));
        System.out.println("Atributo removido: " + event.getName()+ ", Counter: " + userCounter);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        
        if(event.getName().equals("logado")){
            Boolean temp = (Boolean) event.getValue();
            if (temp!=null && temp)
                userCounter--;
            else
                userCounter++;  
            
            servletContext.setAttribute("userCounter", Integer.toString(userCounter));
            
            System.out.println("attributeReplaced: " + event.getName()+ ", Counter: " + userCounter);
        }
    }
}
