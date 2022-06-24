package classes;

/**
 *
 * @author logan
 */
public class CategorieJury {
    private int id;
    private String titre;
    private boolean actif;

    // Constructeurs
    public CategorieJury() {
    }
    public CategorieJury(String titre) {
        this.titre = titre;
    }
    public CategorieJury(int id, String titre, boolean actif) {
        this.id = id;
        this.titre = titre;
        this.actif = actif;
    }
    public CategorieJury(String titre, boolean actif) {
        this.titre = titre;
        this.actif = actif;
    }

    public CategorieJury(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public boolean isActif() {
        return actif;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    // toString
    @Override
    public String toString() {
        return "CategorieJury{" + "id=" + id + ", titre=" + titre + '}';
    }
    
}