/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package prototipo_2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
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
public class Contador_Listeners implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    public static int userCounter = 0;
    private ServletContext servletContext;
    
    @Override
    public void contextInitialized(ServletContextEvent scae) {
        servletContext = scae.getServletContext();
        servletContext.setAttribute("userCounter", Integer.toString(userCounter));
        System.out.println("contextInitialized " );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        if(scae.getName().equals("logado")){
            userCounter++;
            servletContext.setAttribute("userCounter", Integer.toString(userCounter));
            System.out.println("Atributo adicionado: " + scae.getName()+ ", Counter: " + userCounter);
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        userCounter--;
        servletContext.setAttribute("userCounter", Integer.toString(userCounter));
        System.out.println("Atributo removido: " + scae.getName()+ ", Counter: " + userCounter);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        if(scae.getName().equals("logado")){
            String temp = (String) scae.getValue();
            if (temp!=null && temp.equals("TRUE"))
                userCounter--;
            else
                userCounter++;  
            
            servletContext.setAttribute("userCounter", Integer.toString(userCounter));
            
            System.out.println("attributeReplaced: " + scae.getName()+ ", Counter: " + userCounter);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
    }
}
