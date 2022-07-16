package classes;

import java.io.File;

/**
 *
 * @author logan
 */
public class Ressource_Evenements extends Ressource {

  private Evenement evenement;

  // Constructeurs
  public Ressource_Evenements(
    int id,
    String titre,
    String description,
    long taille,
    String chemin,
    boolean actif,
    Evenement evenement
  ) {
    super(id, titre, description, taille, chemin, actif);
    this.evenement = evenement;
  }

  public Ressource_Evenements(
    Evenement evenement,
    String titre,
    long taille,
    String chemin,
    boolean actif
  ) {
    super(titre, taille, chemin, actif);
    this.evenement = evenement;
  }

  public Ressource_Evenements(
    Evenement evenement,
    String titre,
    long taille,
    String chemin
  ) {
    super(titre, taille, chemin);
    this.evenement = evenement;
  }

  public Ressource_Evenements(
    Evenement evenement,
    int id,
    String titre,
    long taille,
    String chemin
  ) {
    super(id, titre, taille, chemin);
    this.evenement = evenement;
  }

  public Ressource_Evenements(File file, Evenement evenement) {
    super(file);
    this.evenement = evenement;
}

// Getters
  public Evenement getEvenement() {
    return evenement;
  }

  // Setters
  public void setEvenement(Evenement evenement) {
    this.evenement = evenement;
  }

  // toString
  @Override
  public String toString() {
    return (
      "Ressource Evenements{" +
      "id=" +
      this.getId() +
      ", titre=" +
      this.getTitre() +
      ", description=" +
      this.getDescription() +
      ", taille=" +
      this.getTaille() +
      ", chemin=" +
      this.getChemin() +
      ", actif=" +
      this.isActif() +
      ", Evenement=" +
      this.getEvenement() +
      '}'
    );
  }
}
