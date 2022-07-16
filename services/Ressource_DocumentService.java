package services;

import java.util.List;

import DAO.Ressource_DocumentsDao;
import classes.Ressource_documents;

public class Ressource_DocumentService {
    Ressource_DocumentsDao ressource_DocumentsDao = null;

    public Ressource_DocumentService(){
        ressource_DocumentsDao = new Ressource_DocumentsDao();
    }

    public boolean create(Ressource_documents t){
        return ressource_DocumentsDao.create(t);
    }

    public List<Ressource_documents> getAllCourses(){
        return ressource_DocumentsDao.getAllCourses();
    }

    public List<Ressource_documents> getAllSubjects(){
        return ressource_DocumentsDao.getAllSubjects();
    }

    public List<Ressource_documents> getAllMemories(){
        return ressource_DocumentsDao.getAllMemories();
    }

    public boolean update(Ressource_documents t){
        return ressource_DocumentsDao.update(t);
    }

    public boolean delete(Ressource_documents t){
        return ressource_DocumentsDao.delete(t);
    }

    public Ressource_documents getSubjectById(int id){
        return ressource_DocumentsDao.getSubjectById(id);
    }

    public Ressource_documents getCoursById(int id){
        return ressource_DocumentsDao.getCoursById(id);
    }

    public Ressource_documents getMemoryById(int id){
        return ressource_DocumentsDao.getMemoryById(id);
    }

}
