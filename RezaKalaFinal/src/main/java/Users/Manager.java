package Users;

import java.sql.SQLException;

public class Manager extends Account {

    private static Manager manager = null;

    public static Manager getManager() throws SQLException {
        if (manager == null)
            manager = new Manager("Reza", "Charrakh", "Reza.charrakh1382@gmail.com", "09304704241");

        return manager;

    }

    public Manager(String name, String family, String email, String number) throws SQLException {
        super(name, family, email, number, "admin", "admin");
    }
}
