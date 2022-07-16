import java.io.File;
import java.util.Scanner;

import classes.Ressource;
import services.FTPService;
/**
 *
 * @author logan
 */
public class Main{
    public static void main(String[] args){
        FTPService fileUpload = new FTPService();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("insert file: ");
            String fichier = sc.next();
            File file = new File(fichier);
            Ressource ressource = new Ressource(file);
        

            fileUpload.download(ressource);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        
    }
}