package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3103503213
 */
public class dbConnection
{

    private final String dbServerAddress = "localhost";
    private final int dbServerPort = 3306;
    private final String dbDatabaseName = "findmycareer";
    private final String dbUsername = "root";
    private final String dbPassword = "";

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public dbConnection()
    {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", dbServerAddress, dbServerPort, dbDatabaseName), dbUsername, dbPassword);
	    st = con.createStatement();

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, String.format("Connection %s:%s@%s:%d/%s", dbUsername, dbPassword, dbServerAddress, dbServerPort, dbDatabaseName));
	} catch (ClassNotFoundException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, "Could not find JDBC library.", e);
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, "Could not connect to the database.", e);
	}
    }

    //<editor-fold desc="User">
    public boolean isUserExist(User u)
    {
	String sql = "select 1 from `Users` where `userID` = ?;";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, u.getUserID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    rs = ps.executeQuery();
	    return rs.first();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return false;
    }

    public boolean isUserAdmin(User u)
    {
	String sql = "select `Admin` from `Users` where `userID` = ?;";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, u.getUserID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    rs = ps.executeQuery();
	    while (rs.first()) {
		return rs.getBoolean("Admin");
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return false;
    }

    public User populateUserFields(User u)
    {
	String sql = "select 1 from `Users` where `UserID` = ?;";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, u.getUserID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    rs = ps.executeQuery();

	    u.setUserEmail(rs.getString("Email"));
	    u.setUserDateOfBirth(rs.getDate("DateOfBirth"));
	    u.setUserContactNumber(rs.getString("ContactNumber"));
	    u.setUserCreationDate(rs.getDate("CreationDate"));
	    u.setUserLastLoginDate(rs.getDate("LastLoginDate"));
	    u.setUserAdmin(rs.getBoolean("Admin"));
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return u;
    }

    public void insertUser(User u)
    {
	String sql = "insert into `Users` (`userID`, `Email`, `DateOfBirth`, `ContactNumber`, `CreationDate`, `LastLoginDate`, `Admin`) values (?, ?, ?, ?, ?, ?);";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, 0);
	    ps.setString(2, u.getUserEmail());
	    ps.setString(3, u.getUserContactNumber());
	    ps.setDate(4, u.getUserCreationDate());
	    ps.setDate(5, u.getUserLastLoginDate());
	    ps.setBoolean(6, u.isUserAdmin());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    ps.executeQuery();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
    }

    //</editor-fold>
    //<editor-fold desc="Industry">
    public ArrayList<Industry> getIndustries()
    {
	String sql = "select * from `Industries`;";
	ArrayList<Industry> industries = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    while (rs.next()) {
		industries.add(new Industry(rs.getInt("IndustryID"), rs.getString("Name")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return industries;
    }

    //</editor-fold>
    //<editor-fold desc="Category">
    public ArrayList<Category> getCategoriesForIndustry(Industry i)
    {
	String sql = "select * from `Categories` where `IndustryID` = ?;";
	ArrayList<Category> categories = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, i.getIndustryID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    while (rs.next()) {
		categories.add(new Category(rs.getInt("CategoryID"), rs.getInt("IndustryID"), rs.getInt("EmployabilitySkillID"), rs.getInt("SkillsInDemandID"), rs.getString("Name")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return categories;
    }

    //</editor-fold>
}