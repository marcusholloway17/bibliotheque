package classes;

import java.time.LocalDateTime;

/**
 *
 * @author logan
 */
public class Cours extends Document {

  private Filiere filiere;
  private Matiere matiere;
  private CategorieCours categorieCours;

  // Constructeurs
  public Cours(
    Filiere filiere,
    Matiere matiere,
    CategorieCours categorieCours,
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.filiere = filiere;
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    String description,
    Utilisateur utilisateur
  ) {
    super(titre, description, utilisateur);
    this.filiere = filiere;
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    Utilisateur utilisateur
  ) {
    super(titre, utilisateur);
    this.filiere = filiere;
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    String description
  ) {
    super(titre, description);
    this.filiere = filiere;
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Matiere matiere,
    CategorieCours categorieCours,
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    String description,
    Utilisateur utilisateur
  ) {
    super(titre, description, utilisateur);
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    Utilisateur utilisateur
  ) {
    super(titre, utilisateur);
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Matiere matiere,
    CategorieCours categorieCours,
    String titre,
    String description
  ) {
    super(titre, description);
    this.matiere = matiere;
    this.categorieCours = categorieCours;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.filiere = filiere;
    this.matiere = matiere;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    String titre,
    String description,
    Utilisateur utilisateur
  ) {
    super(titre, description, utilisateur);
    this.filiere = filiere;
    this.matiere = matiere;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    String titre,
    Utilisateur utilisateur
  ) {
    super(titre, utilisateur);
    this.filiere = filiere;
    this.matiere = matiere;
  }

  public Cours(
    Filiere filiere,
    Matiere matiere,
    String titre,
    String description
  ) {
    super(titre, description);
    this.filiere = filiere;
    this.matiere = matiere;
  }

  public Cours(
    int id,
    String titre,
    String description,
    boolean actif,
    LocalDateTime datePublication,
    Utilisateur utilisateur,
    CategorieCours categorieCours,
    Filiere filiere,
    Matiere matiere
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.categorieCours = categorieCours;
    this.filiere = filiere;
    this.matiere = matiere;
  }

  // Getters
  public Filiere getFiliere() {
    return filiere;
  }

  public Matiere getMatiere() {
    return matiere;
  }

  public CategorieCours getCategorieCours() {
    return categorieCours;
  }

  // Setters
  public void setFiliere(Filiere filiere) {
    this.filiere = filiere;
  }

  public void setMatiere(Matiere matiere) {
    this.matiere = matiere;
  }

  public void setCategorieCours(CategorieCours categorieCours) {
    this.categorieCours = categorieCours;
  }

  // toString

  @Override
  public String toString() {
    return (
      "Cours{" +
      "filiere=" +
      filiere +
      ", matiere=" +
      matiere +
      ", categorieCours=" +
      categorieCours +
      '}'
    );
  }
}
