package code;

public class UsersEntity {
    private int id;
    private int state;
    private String name;
    private String email;
    private String rfc;
    private String user;
    private String pass;
    private String age;
    
    public UsersEntity(){
        
    }
    
    public UsersEntity(int id, int state, String name, String email, String rfc, String user, String pass){
        this.id = id;
        this.state = state;
        this.name = name;
        this.email = email;
        this.rfc = rfc;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    
    
    
    
}
