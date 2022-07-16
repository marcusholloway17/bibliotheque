package classes;
/**
 * 
 * @author Logan
 */
public class Memoire_Jury {
    private Memoire memoire;
    private Jury jury;
    private boolean actif;

    // Constructeurs
    public Memoire_Jury() {
    }

    public Memoire_Jury(Memoire memoire, Jury jury, boolean actif) {
        this.memoire = memoire;
        this.jury = jury;
        this.actif = actif;
    }

    public Memoire_Jury(Memoire memoire, boolean actif) {
        this.memoire = memoire;
        this.actif = actif;
    }

    public Memoire_Jury(Jury jury, boolean actif) {
        this.jury = jury;
        this.actif = actif;
    }

    // Getters
    public Memoire getMemoire() {
        return memoire;
    }

    public Jury getJury() {
        return jury;
    }

    public boolean isActif() {
        return actif;
    }

    // Setters
    public void setMemoire(Memoire memoire) {
        this.memoire = memoire;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    // toString
    @Override
    public String toString() {
        return "Memoire_Jury [actif=" + actif + ", jury=" + jury + ", memoire=" + memoire + "]";
    }
    
}
