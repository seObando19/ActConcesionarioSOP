/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.vehiculoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.vehiculo;

/**
 *
 * @author sebas
 */
public class vehiControlador extends HttpServlet {

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
        
        String placa = request.getParameter("txtplacaVehi");
        String marca = request.getParameter("txtmarcaVehi");
        String referencia = request.getParameter("txtreferenciaVehi");
        int modelo = Integer.parseInt(request.getParameter("txtmodeloVehi"));
        int idtv = Integer.parseInt(request.getParameter("txtidtv"));
        
        //Tomar el parametro que va a tener la accion (registrar,actualizar  eliminar)
        String accion = request.getParameter("accion").toLowerCase();
        
        //Asignar al objeto los valores que se recogieron en las variables pero que vienen del formulario
        vehiculo vehi = new vehiculo();
        vehi.setPlacaVehi(placa);
        vehi.setMarca(marca);
        vehi.setReferencia(referencia);
        vehi.setModelo(modelo);
        vehi.setIdTipoV(idtv);
        
        //validar cual es la accion que se va a gestionar(va a controlar)
        //if(accion.equals("registrar")){}
        
        switch(accion){
            case "registrar":
                if(vehiculoDao.insertarVehiculo(vehi)){
                    request.setAttribute("mensaje", "Vehiculo registrado");
                }else{
                    request.setAttribute("mensaje", "Vehiculo no registrado");
                }
                break;
            case "actualizar":
                if(vehiculoDao.actualizarvehi(vehi)){
                    request.setAttribute("mensaje", "Vehiculo actualizado");
                }else{
                    request.setAttribute("mensaje", "Vehiculo no actualizado");
                }
                break;                
            case "eliminar":
                if(vehiculoDao.eliminarVehi(vehi)){
                    request.setAttribute("mensaje", "Vehiculo eliminado");
                }else{
                    request.setAttribute("mensaje", "Vehiculo no eliminado");
                }
                break;
            case "eliminaruno":
                if(vehiculoDao.eliminarVehi(vehi)){
                String placaUno = request.getParameter("txtvUno");
                vehi.setPlacaVehi(placaUno);
                vehiculoDao.eliminarVehiuno(placaUno);                
                    request.setAttribute("mensaje", "Vehiculo eliminado");
                }else{
                    request.setAttribute("mensaje", "Vehiculo no eliminado");
                }
                break;
            
        }
        request.getRequestDispatcher("registrarVehi.jsp").forward(request, response);        
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
