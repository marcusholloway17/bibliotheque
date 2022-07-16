package classes;

import java.time.LocalDateTime;
import java.time.Year;

/**
 *
 * @author Logan
 */
public class Memoire extends Document {

  private LocalDateTime dateSoutenance;
  private String entreprise;
  private Year anneeAcademique;
  private Etudiant etudiant;
  private Filiere filiere;
  private Professeur professeur;

  public Memoire(){
    super();
  }

  public Memoire(
    int id,
    String titre,
    String description,
    boolean actif,
    Utilisateur utilisateur,
    LocalDateTime datePublication
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
  }

  public Memoire(
    int id,
    String titre,
    String description,
    LocalDateTime dateSoutenance,
    String entreprise,
    Year anneeAcademique,
    boolean actif,
    LocalDateTime datePublication,
    Etudiant etudiant,
    Filiere filiere,
    Utilisateur utilisateur,
    Professeur professeur
  ) {
    super(id, titre, description, actif, utilisateur, datePublication);
    this.dateSoutenance = dateSoutenance;
    this.entreprise = entreprise;
    this.anneeAcademique = anneeAcademique;
    this.etudiant = etudiant;
    this.filiere = filiere;
    this.professeur = professeur;
  }

  // Getters
  public LocalDateTime getDateSoutenance() {
    return dateSoutenance;
  }

  public String getEntreprise() {
    return entreprise;
  }

  public Year getAnneeAcademique() {
    return anneeAcademique;
  }

  public Etudiant getEtudiant() {
    return etudiant;
  }

  public Filiere getFiliere() {
    return filiere;
  }

  public Professeur getProfesseur() {
    return professeur;
  }

  // Setters
  public void setDateSoutenance(LocalDateTime dateSoutenance) {
    this.dateSoutenance = dateSoutenance;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public void setAnneeAcademique(Year anneeAcademique) {
    this.anneeAcademique = anneeAcademique;
  }

  public void setEtudiant(Etudiant etudiant) {
    this.etudiant = etudiant;
  }

  public void setFiliere(Filiere filiere) {
    this.filiere = filiere;
  }

  public void setProfesseur(Professeur professeur) {
    this.professeur = professeur;
  }

  // toString
  @Override
  public String toString() {
    return (
      "Memoire [ id=" +
      super.getId() +
      ", theme=" +
      super.getTitre() +
      ", description=" +
      super.getDescription() +
      ", dateSoutenance=" +
      dateSoutenance +
      ", entreprise=" +
      entreprise +
      ", anneeAcademique=" +
      anneeAcademique +
      ", actif=" +
      super.isActif() +
      ", datePublication=" +
      super.getDatePublication() +
      ", etudiant=" +
      etudiant +
      ", filiere=" +
      filiere +
      ", utilisateur=" +
      super.getUtilisateur() +
      ", professeur=" +
      professeur +
      "]"
    );
  }
}
