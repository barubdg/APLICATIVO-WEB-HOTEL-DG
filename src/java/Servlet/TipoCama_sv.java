/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


//Se asigna un nombre al servlet y la tipificación de la url para su llamado
@WebServlet(name = "TipoCama_sv", urlPatterns = {"/TipoCama_sv"})
public class TipoCama_sv extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Se crea un objeto de la clase TipoHabitacion para su trabajo
            beans.TipoCama tc = new beans.TipoCama();
            //Si se presiona el boton de nombre btntipocama, se inserta el nombre del tipo
            if(request.getParameter("btntipocama") != null){
                String nombre = request.getParameter("nombretipocama").toString();
                
                tc.setNombretipocama(nombre);
                tc.insert();
                //si se presiona el bon de nombre btnborrartipocama, elimina la habitación con la id correspondiente
            }if(request.getParameter("btnborrartipocama") != null){
                int id = Integer.parseInt(request.getParameter("idtipo").toString());
                
                tc.setIdtipocama(id);
                tc.delete();
                
            }
            
            //Una vez realizada la transacción, se redirecciona a la pagina de habitaciones
            response.sendRedirect("index.jsp?pag=/habitaciones");
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
