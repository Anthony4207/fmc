package data;

import java.sql.Date;


/**
 *
 * @author 6100265615
 */
public class Analytic {
    
    private int analyticID;
    private int userID;
    private int courseID;
    private Date dateAccessed;
         
    
    public Analytic(int analyticID, int userID, int courseID, Date dateAccessed) {  

this.analyticID = analyticID;
this.userID = userID;
this.courseID = courseID;
this.dateAccessed = dateAccessed;

}

    /**
     * @return the analyticID
     */
    public int getAnalyticID() {
        return analyticID;
    }

    /**
     * @param analyticID the analyticID to set
     */
    public void setAnalyticID(int analyticID) {
        this.analyticID = analyticID;
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
     * @return the courseID
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the dateAccessed
     */
    public Date getDateAccessed() {
        return dateAccessed;
    }

    /**
     * @param dateAccessed the dateAccessed to set
     */
    public void setDateAccessed(Date dateAccessed) {
        this.dateAccessed = dateAccessed;
    }
    
}


