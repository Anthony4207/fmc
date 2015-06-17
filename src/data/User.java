package data;

import java.sql.Date;

/**
 *
 * @author 6100265615
 */
public class User {

    private int userID;
    private String userEmail;
    private Date userDateOfBirth;
    private int userContactNumber;
    private Date userCreationDate;
    private Date userLastLoginDate;
    private boolean userAdmin;

    public User(int userID) {

        this.userID = userID;
    }
    
    public User(int userID, String userEmail, Date userDateOfBirth, int userContactNumber, Date userCreationDate, Date userLastLoginDate, boolean userAdmin) {

        this.userID = userID;
        this.userEmail = userEmail;
        this.userDateOfBirth = userDateOfBirth;
        this.userContactNumber = userContactNumber;
        this.userCreationDate = userCreationDate;
        this.userLastLoginDate = userLastLoginDate;
        this.userAdmin = userAdmin;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userDateOfBirth
     */
    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    /**
     * @param userDateOfBirth the userDateOfBirth to set
     */
    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    /**
     * @return the userContactNumber
     */
    public int getUserContactNumber() {
        return userContactNumber;
    }

    /**
     * @param userContactNumber the userContactNumber to set
     */
    public void setUserContactNumber(int userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    /**
     * @return the userCreationDate
     */
    public Date getUserCreationDate() {
        return userCreationDate;
    }

    /**
     * @param userCreationDate the userCreationDate to set
     */
    public void setUserCreationDate(Date userCreationDate) {
        this.userCreationDate = userCreationDate;
    }

    /**
     * @return the userLastLoginDate
     */
    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    /**
     * @param userLastLoginDate the userLastLoginDate to set
     */
    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    /**
     * @return the userAdmin
     */
    public boolean isUserAdmin() {
        return userAdmin;
    }

    /**
     * @param userAdmin the userAdmin to set
     */
    public void setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
    }
}
