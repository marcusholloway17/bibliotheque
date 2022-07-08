package classes;

import java.time.LocalDateTime;

/**
 *
 * @author logan
 */
public class Document {

  private int id;
  private String titre;
  private String description;
  private boolean actif;
  private Utilisateur utilisateur;
  private LocalDateTime datePublication;

  // Contructeurs
  public Document(
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    this.id = id;
    this.titre = titre;
    this.description = description;
    this.actif = actif;
    this.utilisateur = utilisateur;
    this.datePublication = datePublication;
  }

  public Document(String titre, String description, Utilisateur utilisateur) {
    this.titre = titre;
    this.description = description;
    this.utilisateur = utilisateur;
  }

  public Document(String titre, Utilisateur utilisateur) {
    this.titre = titre;
    this.utilisateur = utilisateur;
  }

  public Document(String titre, String description) {
    this.titre = titre;
    this.description = description;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getTitre() {
    return titre;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActif() {
    return actif;
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public LocalDateTime getDatePublication() {
    return datePublication;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setActif(boolean actif) {
    this.actif = actif;
  }

  public void setUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public void setDatePublication(LocalDateTime datePublication) {
    this.datePublication = datePublication;
  }

  // toString
  @Override
  public String toString() {
    return (
      "Document{" +
      "id=" +
      id +
      ", titre=" +
      titre +
      ", description=" +
      description +
      ", auteur=" +
      utilisateur +
      ", datePublication=" +
      datePublication +
      '}'
    );
  }
}
