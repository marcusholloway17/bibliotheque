package classes;

/**
 *
 * @author logan
 */
public class Etudiant {
    private int id;
    private String nom;
    private String prenoms;
    private boolean actif;
    private Filiere filiere;
    
    // Constructeurs
    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenoms, boolean actif, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.actif = actif;
        this.filiere = filiere;
    }

    public Etudiant(int id, String nom, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.filiere = filiere;
    }
    
    public Etudiant(int id, String nom, String prenoms, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.filiere = filiere;
    }
    

    public Etudiant(String nom, String prenoms, Filiere filiere) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.filiere = filiere;
    }

    public Etudiant(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public Etudiant(String nom, Filiere filiere) {
        this.nom = nom;
        this.filiere = filiere;
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

    public Filiere getFiliere() {
        return filiere;
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

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    // toString
    @Override
    public String toString() {
        return "Etudiant{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + ", filiere=" + filiere + '}';
    }
}
