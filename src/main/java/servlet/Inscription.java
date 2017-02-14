package servlet;

import exception.UtilisateurException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapping.Utilisateur;
import utilDB.Operations;

public class Inscription extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String nom = request.getParameter("nom");
            String prenoms = request.getParameter("prenoms");
            String dateNaissance = request.getParameter("datenaissance");
            String email = request.getParameter("email");
            String mdp = request.getParameter("mdp");
            String cmdp = request.getParameter("cmdp");
            
            Operations.findUtilisateur(email);
            if(!mdp.equals(cmdp))
            {
                response.getWriter().write("Les mots de passes ne sont pas identiques");
            }
            else
            {
                Utilisateur nouveau = new Utilisateur(nom, prenoms, dateNaissance, email, mdp, "");
                Operations.insertUtilisateur(nouveau);
                response.getWriter().write("True");
            }
        }
        catch(UtilisateurException ex)
        {
            response.getWriter().write(ex.getMessage());
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) 
        {
            response.getWriter().write("Erreur d'insertion a la base de données");
        } 
        
        
    }
}
