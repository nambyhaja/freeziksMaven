package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapping.Musique;
import utilDB.Operations;

public class GetTopMusique extends HttpServlet 
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
            Musique[] musiques = Operations.findMusiquesTopSemaine();
            Gson json = new Gson();
            String ziks = json.toJson(musiques);
            
            response.setContentType("application/json");
            response.getWriter().write(ziks);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
