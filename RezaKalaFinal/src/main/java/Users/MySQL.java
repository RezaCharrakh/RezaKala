package Users;

import java.sql.*;

public class MySQL {
    String URL = "jdbc:mysql://localhost/rezakala";
    String UserName = "root";
    String Password = "Rexa*xh82";
    Connection Con;

    static MySQL mySQL = null;
    public static MySQL getMySQL()
    {
        if (mySQL == null)
        {
            mySQL = new MySQL();
        }
        return mySQL;
    }

    public ResultSet ExecuteQuery(String SQLCom) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SQLCom);
            ResultSet rs = s.executeQuery(SQLCom);
            return rs;
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean Execute(String SQLCom) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SQLCom);;
            s.execute(SQLCom);
            Con.close();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    int GetMaxIntCustomer() throws SQLException
    {
        String SqlCmd = String.format("SELECT MAX(Id) FROM customers");
        ResultSet rs = MySQL.getMySQL().ExecuteQuery(SqlCmd);
        if(rs.next())
        {
            return rs.getInt(1);
        }
        else return 0;
    }

    int GetMaxIntSeller() throws SQLException
    {
        String SqlCmd = String.format("SELECT MAX(Id) FROM sellers");
        ResultSet rs = MySQL.getMySQL().ExecuteQuery(SqlCmd);
        if(rs.next())
        {
            return rs.getInt(1);
        }
        else return 0;
    }
}