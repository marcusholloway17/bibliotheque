package classes;

/**
 *
 * @author logan
 */
public class Jury {
    private int id;
    private String nom;
    private String prenoms;
    private boolean actif;
    private CategorieJury categorieJury;
    
    // Constructeurs
    public Jury() {
    }

    public Jury(int id, String nom, String prenoms, boolean actif, CategorieJury categorieJury) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.actif = actif;
        this.categorieJury = categorieJury;
    }

    public Jury(int id, String nom, String prenoms, CategorieJury categorieJury) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.categorieJury = categorieJury;
    }

    public Jury(int id, String nom, String prenoms, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.actif = actif;
    }

    public Jury(String nom, String prenoms, CategorieJury categorieJury) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.categorieJury = categorieJury;
    }

    public Jury(String nom, CategorieJury categorieJury) {
        this.nom = nom;
        this.categorieJury = categorieJury;
    }

    public Jury(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
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

    public CategorieJury getCategorieJury() {
        return categorieJury;
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

    public void setCategorieJury(CategorieJury categorieJury) {
        this.categorieJury = categorieJury;
    }
    
    // toString
    @Override
    public String toString() {
        return "Jury{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + ", categorieJury=" + categorieJury + '}';
    }
    
    
}
