/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.tipoConductorDao;
import dao.vehiculoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.tipoConductor;

/**
 *
 * @author sebas
 */
public class tipconducControlador extends HttpServlet {

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
            out.println("<title>Servlet tipconducControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tipconducControlador at " + request.getContextPath() + "</h1>");
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
        
        //Recibir datos
        int idtipoCon = Integer.parseInt(request.getParameter("txtidtipCond"));
        String nombre = request.getParameter("txtnomtipCond");
        
        //Tomar el parametro que va a tener la accion (registrar,actualizar  eliminar)
        String accion = request.getParameter("accion").toLowerCase();
        
        //pasando los datos al modelo
        tipoConductor tipoconductor = new tipoConductor();
        tipoconductor.setIdtipoCon(idtipoCon);
        tipoconductor.setNombre(nombre);
        
        switch(accion){
            case "registrar":
                if(tipoConductorDao.insertartipConductor(tipoconductor)){
                    request.setAttribute("mensaje", "Tipo conductor registrado");
                }else{
                    request.setAttribute("mensaje", "Tipo conductor no registrado");
                }
                break;
            case "actualizar":
                if(tipoConductorDao.actualizarTC(tipoconductor)){
                    request.setAttribute("mensaje", "Tipo conductor actualizado");
                }else{
                    request.setAttribute("mensaje", "Tipo conductor no actualizado");
                }
                break;                
            case "eliminar":
                if(tipoConductorDao.eliminarTC(tipoconductor)){
                    request.setAttribute("mensaje", "Tipo conductor eliminado");
                }else{
                    request.setAttribute("mensaje", "Tipo conductor no eliminado");
                }
                break;           
        }
        request.getRequestDispatcher("tipoconductor.jsp").forward(request, response);
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
