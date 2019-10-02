/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.conductorDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.conductor;

/**
 *
 * @author sebas
 */
public class conductorControlador extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conductorControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet conductorControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
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
        //processRequest(request, response);
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
        //processRequest(request, response);
        
        //Recibir los datos
        int idConductor = Integer.parseInt(request.getParameter("idConductor"));
        int idtipoCond = Integer.parseInt(request.getParameter("idtipoCond"));
        String nombre = request.getParameter("nombre");
        String tipoLicencia = request.getParameter("tipoLicencia");
        String placaVehi = request.getParameter("placaVehi");
        
        //Pasando los datos al modelo
        conductor Conductor = new conductor();
        Conductor.setIdConductor(idConductor);
        Conductor.setIdtipoCond(idtipoCond);
        Conductor.setNombre(nombre);
        Conductor.setPlacaVehi(placaVehi);
        Conductor.setTipoLicencia(tipoLicencia);
        
        if(conductorDao.insertarConductor(Conductor)){
            request.setAttribute("mensaje", "Conductor registrado");
        }else{
            request.setAttribute("mensaje", "Conductor no registrado");
        }
        request.getRequestDispatcher("?").forward(request, response);
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
