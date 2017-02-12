package mapping;

public class Musique 
{
    // Attributs
    private int idMusique;
    private int idUtilisateur;
    private int idCategorieMusique;
    private String titreMusique;
    private String artisteMusique;
    private String imageMusique;
    private String lienMusique;
    
    // Constructeur(s)
    public Musique(int idMusique, int idUtilisateur, int idCategorieMusique, String titreMusique, String artisteMusique, String imageMusique, String lienMusique)
    {
        this.setIdMusique(idMusique);
        this.setIdUtilisateur(idUtilisateur);
        this.setIdCategorieMusique(idCategorieMusique);
        this.setTitreMusique(titreMusique);
        this.setArtisteMusique(artisteMusique);
        this.setImageMusique(imageMusique);
        this.setLienMusique(lienMusique);
    }
    public Musique(int idUtilisateur, int idCategorieMusique, String titreMusique, String artisteMusique, String imageMusique, String lienMusique)
    {
        this.setIdUtilisateur(idUtilisateur);
        this.setIdCategorieMusique(idCategorieMusique);
        this.setTitreMusique(titreMusique);
        this.setArtisteMusique(artisteMusique);
        this.setImageMusique(imageMusique);
        this.setLienMusique(lienMusique);
    }
    
    // Getters
    public int getIdMusique()
    {
        return idMusique;
    }

    public int getIdUtilisateur()
    {
        return idUtilisateur;
    }

    public int getIdCategorieMusique()
    {
        return idCategorieMusique;
    }

    public String getTitreMusique()
    {
        return titreMusique;
    }

    public String getArtisteMusique()
    {
        return artisteMusique;
    }

    public String getImageMusique()
    {
        return imageMusique;
    }

    public String getLienMusique()
    {
        return lienMusique;
    }
    
    // Setters
    public void setIdMusique(int idMusique)
    {
        this.idMusique = idMusique;
    }

    public void setIdUtilisateur(int idUtilisateur)
    {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdCategorieMusique(int idCategorieMusique)
    {
        this.idCategorieMusique = idCategorieMusique;
    }

    public void setTitreMusique(String titreMusique)
    {
        this.titreMusique = titreMusique;
    }

    public void setArtisteMusique(String artisteMusique)
    {
        this.artisteMusique = artisteMusique;
    }

    public void setImageMusique(String imageMusique)
    {
        this.imageMusique = imageMusique;
    }

    public void setLienMusique(String lienMusique)
    {
        this.lienMusique = "http://docs.google.com/uc?export=open&id="+lienMusique;
    }
    
}