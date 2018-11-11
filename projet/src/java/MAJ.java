/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Patient;
import classes.Patients;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HITMAN
 */
@WebServlet(urlPatterns = {"/MAJ"})
public class MAJ extends HttpServlet {

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
        HttpSession session = request.getSession(); 
        processRequest(request, response);
         //Patient p=new Patient(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"));
        if("Modifier".equals(request.getParameter("b1"))){
            out.println("ok");
              session.setAttribute("sos",request.getParameter("id"));
              out.println("ok");
              out.println(session.getAttribute("sos"));
            response.sendRedirect("Modification.jsp");
         /*  Patients p1=new Patients();
            try {
                Patient e=new Patient(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"));
                p1.Update(e);
                response.sendRedirect("rest.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(MAJ.class.getName()).log(Level.SEVERE, null, ex);
            }
             */
        }
        else if("Supprimer".equals(request.getParameter("b1"))){
            // response.sendRedirect("DeletePatient");
                
            try {
                Patients p1=new Patients();
                p1.Delete(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("refresh.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(MAJ.class.getName()).log(Level.SEVERE, null, ex);
            }
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
