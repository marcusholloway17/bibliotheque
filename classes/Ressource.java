package classes;

import java.io.File;

/**
 *
 *@author Logan
 */
public class Ressource {

  private int id;
  private String titre;
  private String description;
  private long taille;
  private String chemin;
  private boolean actif;

  // Constructeurs
  public Ressource() {}

  public Ressource(File file) {
    this.titre = file.getName();
    this.description = file.getAbsolutePath();
    this.taille = file.length();
    this.chemin = file.getPath();
  }

  public Ressource(
    int id,
    String titre,
    String description,
    long taille,
    String chemin,
    boolean actif
  ) {
    this.id = id;
    this.titre = titre;
    this.description = description;
    this.taille = taille;
    this.chemin = chemin;
    this.actif = actif;
  }

  public Ressource(String titre, long taille, String chemin, boolean actif) {
    this.titre = titre;
    this.taille = taille;
    this.chemin = chemin;
    this.actif = actif;
  }

  public Ressource(String titre, long taille, String chemin) {
    this.titre = titre;
    this.taille = taille;
    this.chemin = chemin;
  }

  public Ressource(int id, String titre, long taille, String chemin) {
    this.id = id;
    this.titre = titre;
    this.taille = taille;
    this.chemin = chemin;
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

  public long getTaille() {
    return taille;
  }

  public String getChemin() {
    return chemin;
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

  public void setDescription(String description) {
    this.description = description;
  }

  public void setTaille(long taille) {
    this.taille = taille;
  }

  public void setChemin(String chemin) {
    this.chemin = chemin;
  }

  public void setActif(boolean actif) {
    this.actif = actif;
  }

  // toString
  @Override
  public String toString() {
    return (
      "Ressource{" +
      "id=" +
      id +
      ", titre=" +
      titre +
      ", description=" +
      description +
      ", taille=" +
      taille +
      ", chemin=" +
      chemin +
      ", actif=" +
      actif +
      '}'
    );
  }
}
