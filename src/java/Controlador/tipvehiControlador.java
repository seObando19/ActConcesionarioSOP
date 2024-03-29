/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.tipovehiDao;
import dao.vehiculoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.tipovehi;

/**
 *
 * @author sebas
 */
public class tipvehiControlador extends HttpServlet {

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
            out.println("<title>Servlet tipvehiControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tipvehiControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        */}
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
        int IdTv = Integer.parseInt(request.getParameter("txtidtv"));
        String NomTv = request.getParameter("txtnomtv");
        
        //Tomar el parametro que va tener la accion
        String accion = request.getParameter("accion").toLowerCase();
        
        //pasando los datos al modelo
        tipovehi tipoVehi = new tipovehi();
        tipoVehi.setIdtv(IdTv);
        tipoVehi.setNomtv(NomTv);        
        
        switch(accion){
            case "registrar":
                if(tipovehiDao.insertartv(tipoVehi)){
                    request.setAttribute("mensaje", "Tipo Vehiculo registrado");
                }else{
                    request.setAttribute("mensaje", "Tipo Vehiculo no registrado");
                }
                break;
            case "actualizar":
                if(tipovehiDao.actualizarTv(tipoVehi)){
                    request.setAttribute("mensaje", "Tipo vehiculo actualizado");
                }else{
                    request.setAttribute("mensaje", "Tipo vehiculo no actualizado");
                }
                break;                
            case "eliminar":
                if(tipovehiDao.eliminarTv(tipoVehi)){
                    request.setAttribute("mensaje", "Tipo vehiculo eliminado");
                }else{
                    request.setAttribute("mensaje", "Tipo vehiculo no eliminado");
                }
                break;         
        }
        
        request.getRequestDispatcher("registrarTv.jsp").forward(request, response);
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
