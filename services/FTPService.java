package services;

import FTP.FTPConnexion;
import classes.Ressource;

public class FTPService {
    FTPConnexion ftpConnexion = null;
    
    public FTPService(){
        ftpConnexion = new FTPConnexion();
    }

    // upload file service for document
    public boolean uploadDocument(Ressource ressource){
        return ftpConnexion.upload(ressource);
    }

    // upload file service for event
    public boolean uploadEvent(Ressource ressource){
        return ftpConnexion.upload(ressource);  
    }

    public boolean download(Ressource ressource){
        return ftpConnexion.download(ressource);
    }

}
