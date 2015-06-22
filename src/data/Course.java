package data;

class Course
{

    private int courseID;
    private int categoryID;
    private String courseName;
    private String courseDuration;
    private String courseProvider;
    private String courseLink;

    public Course(int courseID, int categoryID, String courseName, String courseDuration, String courseProvider, String courseLink)
    {
	this.courseID = courseID;
	this.categoryID = categoryID;
	this.courseName = courseName;
	this.courseDuration = courseDuration;
	this.courseProvider = courseProvider;
	this.courseLink = courseLink;
    }

    @Override
    public String toString()
    {
	return this.courseName;
    }
    /**
     * @return the courseID
     */
    public int getCourseID()
    {
	return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(int courseID)
    {
	this.courseID = courseID;
    }

    /**
     * @return the categoryID
     */
    public int getCategoryID()
    {
	return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(int categoryID)
    {
	this.categoryID = categoryID;
    }

    /**
     * @return the courseName
     */
    public String getCourseName()
    {
	return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName)
    {
	this.courseName = courseName;
    }

    /**
     * @return the courseDuration
     */
    public String getCourseDuration()
    {
	return courseDuration;
    }

    /**
     * @param courseDuration the courseDuration to set
     */
    public void setCourseDuration(String courseDuration)
    {
	this.courseDuration = courseDuration;
    }

    /**
     * @return the courseProvider
     */
    public String getCourseProvider()
    {
	return courseProvider;
    }

    /**
     * @param courseProvider the courseProvider to set
     */
    public void setCourseProvider(String courseProvider)
    {
	this.courseProvider = courseProvider;
    }

    /**
     * @return the courseLink
     */
    public String getCourseLink()
    {
	return courseLink;
    }

    /**
     * @param courseLink the courseLink to set
     */
    public void setCourseLink(String courseLink)
    {
	this.courseLink = courseLink;
    }
}
