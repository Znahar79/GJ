package getjobinc.mp_35a.getjob;

public class User {
    private String password;
    private String login;
    private String name;
    private String surname;
    public User(String name,String surname,String login,String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;	
    }
}