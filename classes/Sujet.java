package classes;

import java.time.LocalDateTime;

/**
 *
 * @author logan
 */
public class Sujet extends Document {

  private String duree;
  private String type;
  private Filiere filiere;
  private Matiere matiere;
  private CategorieSujet categoriSujet;

  // Construteurs
  public Sujet() {
    super();
  }

  public Sujet(String titre, String description, Utilisateur utilisateur) {
    super(titre, description, utilisateur);
  }

  public Sujet(String titre, Utilisateur utilisateur) {
    super(titre, utilisateur);
  }

  public Sujet(String titre, String description) {
    super(titre, description);
  }

  public Sujet(
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
  }

  public Sujet(
    int id,
    String titre,
    String description,
    String duree,
    String type,
    boolean actif,
    Filiere filiere,
    Matiere matiere,
    CategorieSujet categorieSujet,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.duree = duree;
    this.type = type;
    this.filiere = filiere;
    this.matiere = matiere;
    this.categoriSujet = categorieSujet;
  }

  public Sujet(
    int id,
    String titre,
    String description,
    String duree,
    String type,
    boolean actif,
    LocalDateTime datePublication,
    Filiere filiere,
    Matiere matiere,
    Utilisateur utilisateur,
    CategorieSujet categorieSujet
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.duree = duree;
    this.type = type;
    this.filiere = filiere;
    this.matiere = matiere;
    this.categoriSujet = categorieSujet;
  }

  // Getters
  public String getDuree() {
    return duree;
  }

  public String getType() {
    return type;
  }

  public Filiere getFiliere() {
    return filiere;
  }

  public Matiere getMatiere() {
    return matiere;
  }

  public CategorieSujet getCategoriSujet() {
    return categoriSujet;
  }

  // Setters
  public void setDuree(String duree) {
    this.duree = duree;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setFiliere(Filiere filiere) {
    this.filiere = filiere;
  }

  public void setMatiere(Matiere matiere) {
    this.matiere = matiere;
  }

  public void setCategoriSujet(CategorieSujet categoriSujet) {
    this.categoriSujet = categoriSujet;
  }

  // toString

  @Override
  public String toString() {
    return (
      "Sujet [categoriSujet=" +
      categoriSujet +
      "id=" +
      super.getId() +
      ", titre=" +
      super.getTitre() +
      ", description=" +
      super.getDescription() +
      ", auteur=" +
      super.getUtilisateur() +
      ", datePublication=" +
      super.getDatePublication() +
      ", duree=" +
      duree +
      ", filiere=" +
      filiere +
      ", matiere=" +
      matiere +
      ", type=" +
      type +
      ", actif=" +
      super.isActif() +
      "]"
    );
  }
}
