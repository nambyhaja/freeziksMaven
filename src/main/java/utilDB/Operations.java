package utilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mapping.CategorieMusique;
import mapping.Musique;
import mapping.Utilisateur;

public class Operations
{
    // Operations sur les Utilisateurs
    public static Utilisateur findUtilisateur(String email,String motdepasse) throws Exception
    {
        Connection c = UtilDB.getPostgresConnection();
        String sql = "select * from utilisateur where email=? and motdepasse=?";
        
        PreparedStatement prd = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        prd.setString(1, email);
        prd.setString(2, motdepasse);
        ResultSet rs = prd.executeQuery();
        rs.last();
        int taille = rs.getRow(),i=0;
        if(taille==0)
        {
            c.close();
            throw new Exception("Email ou mot de passe invalide");
        }
        else
        {
            rs.beforeFirst();
            rs.next();
            Utilisateur utilisateur = new Utilisateur(rs.getInt("idutilisateur"), rs.getString("nomutilisateur"), 
                    rs.getString("prenomsutilisateur"), rs.getDate("datenaissance"), 
                    rs.getString("email"), rs.getString("motdepasse"), rs.getString("descriptionutilisateur"));
            c.close();
            return utilisateur;
        }
    }
    
    // Operations sur les Musiques
    public static Musique[] findMusique(int idUtilisateur) throws Exception
    {
        Connection c = UtilDB.getPostgresConnection();
        String sql = "select * from musique where idutilisateur=?";
        
        PreparedStatement prd = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        prd.setInt(1, idUtilisateur);
        
        ResultSet rs = prd.executeQuery();
        rs.last();
        int taille = rs.getRow(),i=0;
        
        Musique[] musiques = new Musique[taille];
        rs.beforeFirst();
        while(rs.next())
        {
            musiques[i] = new Musique(rs.getInt("idmusique"), rs.getInt("idutilisateur"), 
                    rs.getInt("idcategoriemusique"), rs.getString("titremusique"), 
                    rs.getString("artistemusique"), rs.getString("imagemusique"), rs.getString("lienmusique"));
        }
        c.close();
        return musiques;
    }
    public static void insererMusique(Musique musique) throws Exception
    {
        Connection c = UtilDB.getPostgresConnection();
        String sql="insert into musique (idutilisateur,idcategoriemusique,titremusique,artistemusique,imagemusique,lienmusique) "
                + "values(?,?,?,?,?,?)";
        PreparedStatement prd = c.prepareStatement(sql);
        prd.setInt(1, musique.getIdUtilisateur());
        prd.setInt(2, musique.getIdCategorieMusique());
        prd.setString(3, musique.getTitreMusique());
        prd.setString(4, musique.getArtisteMusique());
        prd.setString(5, musique.getImageMusique());
        prd.setString(6, musique.getLienMusique());
        
        prd.executeUpdate();
        c.close();
    }
    
    // Operations sur les Categories
    public static CategorieMusique findCategorie(int idMusique) throws Exception
    {
        Connection c = UtilDB.getPostgresConnection();
        String sql = "select * from categoriemusique cm join musique m on m.idcategoriemusique=cm.idcategoriemusique "
                + "where m.idmusique=?";
        
        PreparedStatement prd = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        prd.setInt(1, idMusique);
        
        ResultSet rs = prd.executeQuery();
        rs.next();
        
        CategorieMusique categorie = new CategorieMusique(rs.getInt("idcategoriemusique"), rs.getString("nomcategorie"));
        
        c.close();
        return categorie;
    }
    public static CategorieMusique[] findCategorie() throws Exception
    {
        Connection c = UtilDB.getPostgresConnection();
        String sql = "select * from categoriemusique";
        
        PreparedStatement prd = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
        ResultSet rs = prd.executeQuery();
        rs.last();
        int taille = rs.getRow(),i=0;
        CategorieMusique[] categories = new CategorieMusique[taille];
        
        rs.beforeFirst();       
        while(rs.next())
        {
            categories[i] = new CategorieMusique(rs.getInt("idcategoriemusique"), rs.getString("nomcategorie"));
            i++;
        }
        c.close();
        return categories;
    }
    // Operations sur les Playlists
}
