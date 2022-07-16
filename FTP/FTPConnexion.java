package FTP;

import classes.Ressource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author Logan
 */
public class FTPConnexion {

  String serveur = "devtech.free.netmaster.tg";
  String username = "sqvlehvg";
  String password = "Q07Luex53e";

  public FTPClient getConnection() {
    FTPClient ftpClient = new FTPClient();
    try {
      ftpClient.connect(serveur);
      ftpClient.login(username, password);
      System.out.println("connexion réussi");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return ftpClient;
  }

  public boolean logout() {
    FTPClient ftpClient = new FTPClient();
    boolean status = true;
    try {
      ftpClient.logout();
      ftpClient.disconnect();
      System.out.println("Déconnexion réussi");
    } catch (IOException e) {
      status = false;
      System.out.println("echec de déconnexion");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return status;
  }

  public boolean upload(Ressource ressource) {
    boolean status = true;
    String upfile = ressource.getDescription(); //File to upload passed on command line
    String chemin = ressource.getTitre();
    String remdir = "/public_html/assets/biblio"; //Remote directory for file upload
    FTPClient ftpClient = getConnection();

    try {
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
      ftpClient.cwd(remdir);
      File file = new File(upfile);
      InputStream inputStream = new FileInputStream(file);
      boolean res = ftpClient.storeFile(chemin, inputStream);
      inputStream.close();
      if (res == true) {
        System.out.println(
          "Le fichier " + chemin + " a été transféré avec succès"
        );
      }
    } catch (IOException e) {
      status = false;
      System.out.println(e.getMessage());
    } finally {
      try {
        if (ftpClient.isConnected()) {
          //fermer la connexion FTP
          ftpClient.logout();
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    return status;
  }

  public boolean download(Ressource ressource) {
    boolean res = true;
    String remdir = "/public_html/assets/biblio";
    FTPClient ftpClient = getConnection();

    try {
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
      ftpClient.cwd(remdir);

      String nomFichier = ressource.getTitre();
      // Approche 2: téléchargement d'un fichier en utilisant OutputStream
      String nomFichier2 = nomFichier;
      String CheminFichierDistant = nomFichier2;
      File fichierlocal = new File(nomFichier);

      // lister le dossier ou se trouve le fichier et
      // puis le rechercher avec le nom pour obtenir
      // sa taille qui va etre utilisée pour calculer
      // le ratio du téléchargement
      FTPFile[] files1 = ftpClient.listFiles(remdir);
      long size = 0;
      for (int i = 0; i < files1.length; i++) {
        if (
          files1[i].getName().equals(nomFichier2)
        ) //obtenir la taille du fichier
        size = files1[i].getSize();
      }

      OutputStream outputStream2 = new BufferedOutputStream(
        new FileOutputStream(fichierlocal)
      );
      InputStream inputStream2 = ftpClient.retrieveFileStream(
        CheminFichierDistant
      );

      byte[] bytesArray = new byte[4096];
      int bytesRead = -1;
      //tant qu'on a pas atteint la fin
      int transferé = 0;
      int pourcentage = 0;
      while ((bytesRead = inputStream2.read(bytesArray)) != -1) {
        //on écrit les octets dans l'emplacement précisé
        outputStream2.write(bytesArray, 0, bytesRead);
        transferé += bytesRead;
        pourcentage = (int) (transferé * 100 / size);
        System.out.println(pourcentage + "%");
      }
      //fermer les flux de lecture de d'écriture
      inputStream2.close();
      outputStream2.close();

      //résultat d
      res = ftpClient.completePendingCommand();
      if (res) {
        System.out.println(
          "Le fichier " + nomFichier2 + " a été téléchargé avec succès"
        );
      }
    } catch (IOException e) {
      res = false;
      System.out.println(e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        if (ftpClient.isConnected()) {
          //fermer la connexion FTP
          ftpClient.logout();
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    return res;
  }

  
}
