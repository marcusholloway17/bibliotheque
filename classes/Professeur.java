package classes;

/**
 *
 * @author logan
 */
public class Professeur {
    private int id;
    private String nom;
    private String prenoms;
    boolean actif;
    
    // Constructeurs

    public Professeur() {
    }

    public Professeur(int id, String nom, String prenoms, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.actif = actif;
    }

    public Professeur(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public Professeur(String nom) {
        this.nom = nom;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public boolean isActif() {
        return actif;
    }
    
    // toString
    @Override
    public String toString() {
        return "Professeur{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + '}';
    }
    
}


