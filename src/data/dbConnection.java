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

	    rs = ps.executeQuery();

	    while (rs.next()) {
		industries.add(new Industry(rs.getInt("IndustryID"), rs.getString("Name")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return industries;
    }

    public void insertIndustry(Industry i)
    {
	String sql = "insert into `industries` (`IndustryID`, `Name`) values (?, ?);";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, i.getIndustryID());
	    ps.setString(2, i.getIndustryName());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    ps.execute();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
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

	    rs = ps.executeQuery();

	    while (rs.next()) {
		categories.add(new Category(rs.getInt("CategoryID"), rs.getInt("IndustryID"), rs.getInt("EmployabilitySkillID"), rs.getString("Name")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return categories;
    }

    public ArrayList<Category> getCategories()
    {
	String sql = "select * from `Categories`;";
	ArrayList<Category> categories = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    rs = ps.executeQuery();

	    while (rs.next()) {
		categories.add(new Category(rs.getInt("CategoryID"), rs.getInt("IndustryID"), rs.getInt("EmployabilitySkillID"), rs.getString("Name")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return categories;
    }

    public void updateCategory(Category c, Category cc)
    {
	String sql = "update `Categories` set `Name` = ? where `CategoryID` = ?;";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, cc.getCategoryName());
	    ps.setInt(2, c.getCategoryID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    // ps.execute();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
    }

    public void deleteCategory(Category c)
    {
	String sql = "delete from `Categories` where `CategoryID` = ?;";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, c.getCategoryID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    // ps.execute();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
    }

    public void insertCategory(Category c)
    {
	String sql = "insert into `Categories` (`CategoryID`, `IndustryID`, `EmployabilitySkillID`, `Name`) values (?, ?, ?, ?);";
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, c.getCategoryID());
	    ps.setInt(2, c.getIndustryID());
	    ps.setInt(3, c.getEmployabilitySkillID());
	    ps.setString(4, c.getCategoryName());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());

	    // ps.execute();
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Courses">
    public ArrayList<Course> getCoursesForCategory(Category c)
    {
	String sql = "select * from `Courses` where `CategoryID` = ?;";
	ArrayList<Course> courses = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, c.getCategoryID());
	    
	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, ps.toString());
	    
	    rs = ps.executeQuery();
	    while (rs.next()) {
		courses.add(new Course(rs.getInt("CourseID"), rs.getInt("CategoryID"), rs.getString("Name"), rs.getString("Duration"), rs.getString("Provider"), rs.getString("Link")));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return courses;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="EmployabilitySkills">
    public ArrayList<String> getEmployabilitySkillsForCategory(Category c)
    {
	String sql = "select EmployabilitySkills.*, CategoryEmployabilitySkills.* from Categories join CategoryEmployabilitySkills on Categories.CategoryID = CategoryEmployabilitySkills.CategoryID join EmployabilitySkills on CategoryEmployabilitySkills.EmployabilitySkillID = EmployabilitySkills.EmployabilitySkillID where Categories.CategoryID = ?";
	ArrayList<String> employabilitySkillsForCategory = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, c.getCategoryID());

	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, String.format("Connection %s:%s@%s:%d/%s", dbUsername, dbPassword, dbServerAddress, dbServerPort, dbDatabaseName));

	    rs = ps.executeQuery();
	    while (rs.next()) {
		employabilitySkillsForCategory.add(rs.getString("Skill") + "\n" + rs.getString("Requirements"));
	    }
	} catch (SQLException e) {
	    Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, e.getMessage(), e);
	}
	return employabilitySkillsForCategory;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Career Pathways">
    public ArrayList<String> getCareerPathwaysForCategory(Category c)
    {
	String sql = ";";
	ArrayList<String> careerPathwaysForCategory = new ArrayList<>();
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, c.getCategoryID());
	    
	    Logger.getLogger(dbConnection.class.getName()).log(Level.INFO, String.format("Connection %s:%s@%s:%d/%s", dbUsername, dbPassword, dbServerAddress, dbServerPort, dbDatabaseName));

	    rs = ps.executeQuery();
	    while (rs.next()) {
		careerPathwaysForCategory.add(rs.getString("Skill") + "\n" + rs.getString("Requirements"));
	    }
	} catch (SQLException e) {
	}
	return careerPathwaysForCategory;
    }
    //</editor-fold>
}
