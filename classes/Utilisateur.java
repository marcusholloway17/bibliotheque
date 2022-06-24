package classes;

/**
 *
 * @author logan
 */
public class Utilisateur {
    private int id;
    private String login;
    private String password;
    private boolean actif;
    private Role role;
    
    // Constructeurs
    public Utilisateur() {
    }
    
    public Utilisateur(int id, String login, String password, boolean actif, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.actif = actif;
        this.role = role;
    }

    public Utilisateur(int id, String login, boolean actif, Role role) {
        this.id = id;
        this.login = login;
        this.actif = actif;
        this.role = role;
    }

    public Utilisateur(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Utilisateur(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Utilisateur(int id, String login, Role role){
        this.id = id;
        this.login = login;
        this.role = role;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActif() {
        return actif;
    }

    public Role getRole() {
        return role;
    }
    
    // toString
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + '}';
    }
    
    
    
}
