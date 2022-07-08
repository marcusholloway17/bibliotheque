package classes;

import java.time.LocalDateTime;

/**
 *
 * @author logan
 */
public class Evenement {

  private int id;
  private String titre;
  private String description;
  private LocalDateTime date;
  private boolean actif;
  private Utilisateur utilisateur;
  private LocalDateTime datePublication;

  // Constructeurs
  public Evenement(
    int id,
    String titre,
    String description,
    LocalDateTime date,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    this.id = id;
    this.titre = titre;
    this.description = description;
    this.date = date;
    this.actif = actif;
    this.utilisateur = utilisateur;
    this.datePublication = datePublication;
  }

  public Evenement(
    String titre,
    String description,
    LocalDateTime date,
    Utilisateur utilisateur
  ) {
    this.titre = titre;
    this.description = description;
    this.date = date;
    this.utilisateur = utilisateur;
  }

  public Evenement(String titre, String description) {
    this.titre = titre;
    this.description = description;
  }

  public Evenement(int id, String titre, String description) {
    this.id = id;
    this.titre = titre;
    this.description = description;
  }

  public Evenement(String titre, LocalDateTime date) {
    this.titre = titre;
    this.date = date;
  }

  public Evenement(String titre, LocalDateTime date, Utilisateur utilisateur) {
    this.titre = titre;
    this.date = date;
    this.utilisateur = utilisateur;
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

  public void setDate(LocalDateTime date) {
    this.date = date;
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

  public LocalDateTime getDate() {
    return date;
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

  // toString
  @Override
  public String toString() {
    return (
      "Evenement{" +
      "id=" +
      id +
      ", titre=" +
      titre +
      ", description=" +
      description +
      ", date=" +
      date +
      ", auteur=" +
      utilisateur +
      ", datePublication=" +
      datePublication +
      '}'
    );
  }
}
