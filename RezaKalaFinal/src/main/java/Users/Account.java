package Users;

import java.sql.SQLException;

//Accounts
abstract public class Account {
    //---------------(Fields)---------------
    private String Name;
    private String Family;
    private String Email;
    private String Number;
    private String Username;
    private String Password;


    @Override
    public String toString() {
        return  "Name: " + Name + '\n' +
                "Family: " + Family + '\n' +
                "Email: " + Email + '\n' +
                "Number: " + Number + '\n' +
                "Username: " + Username + '\n' +
                "Password: " + Password + '\n';
    }

    //---------------(Constructor)---------------
    public Account(String name, String family, String email, String number, String username, String password) throws SQLException {
        setName(name);
        setFamily(family);
        setEmail(email);
        setNumber(number);
        setUsername(username);
        setPassword(password);
    }

    //--------------(Setters & Getters)--------------
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
