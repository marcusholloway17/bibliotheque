package classes;

import java.io.File;

/**
 *
 * @author Logan
 */

public class Ressource_documents extends Ressource {

  private Document document;

  // Constructeurs
  public Ressource_documents(
    Document document,
    int id,
    String titre,
    long taille,
    String chemin
  ) {
    super(id, titre, taille, chemin);
    this.document = document;
  }

  public Ressource_documents(
    Document document,
    String titre,
    long taille,
    String chemin
  ) {
    super(titre, taille, chemin);
    this.document = document;
  }

  public Ressource_documents(
    Document document,
    int id,
    String titre,
    String description,
    long taille,
    String chemin,
    boolean actif
  ) {
    super(id, titre, description, taille, chemin, actif);
    this.document = document;
  }

  public Ressource_documents(
    Document document,
    String titre,
    long taille,
    String chemin,
    boolean actif
  ) {
    super(titre, taille, chemin, actif);
    this.document = document;
  }

  public Ressource_documents(int id, String titre, String description, long taille, String chemin, Boolean actif,Document document) {
    super(id, titre, description, taille, chemin, actif);
    this.document = document;
  }

  public Ressource_documents(File file, Document document) {
    super(file);
    this.document = document;
  }

  // Getters
  public Document getDocument() {
    return document;
  }

  // Setters
  public void setDocument(Document document) {
    this.document = document;
  }

  // toString

  @Override
  public String toString() {
    return (
      "Ressource{" +
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
      ", Document=" +
      this.getDocument() +
      '}'
    );
  }
}
