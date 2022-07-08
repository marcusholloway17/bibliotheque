package classes;

/**
 *
 * @author logan
 */
public class Role {

  private int id;
  private String titre;
  private boolean actif;

  // Constructeurs
  public Role() {}

  public Role(String titre) {
    this.titre = titre;
  }

  public Role(int id, String titre, boolean actif) {
    this.id = id;
    this.titre = titre;
    this.actif = actif;
  }

  public Role(String titre, boolean actif) {
    this.titre = titre;
    this.actif = actif;
  }

  public Role(int id, String titre) {
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
    return "Role{" + "id=" + id + ", titre=" + titre + '}';
  }
}
