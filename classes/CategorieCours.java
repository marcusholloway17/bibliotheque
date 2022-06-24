package classes;

/**
 *
 * @author logan
 */
public class CategorieCours {
    private int id;
    private String titre;
    private boolean actif;

    // Constructeurs
    public CategorieCours() {
    }
    public CategorieCours(String titre) {
        this.titre = titre;
    }
    public CategorieCours(int id, String titre, boolean actif) {
        this.id = id;
        this.titre = titre;
        this.actif = actif;
    }
    public CategorieCours(String titre, boolean actif) {
        this.titre = titre;
        this.actif = actif;
    }

    public CategorieCours(int id, String titre) {
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
        return "CategorieCours{" + "id=" + id + ", titre=" + titre + '}';
    }
    
}
