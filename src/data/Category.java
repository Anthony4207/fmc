package data;

/**
 *
 * @author 3103503213
 */
public class Category
{

    private int categoryID;
    private int industryID;
    private int employabilitySkillID;
    private int skillsInDemandID;
    private String categoryName;

    public Category(int categoryID, int industryID, int employabilitySkillID, int skillsInDemandID, String categoryName)
    {
	this.categoryID = categoryID;
	this.industryID = industryID;
	this.employabilitySkillID = employabilitySkillID;
	this.skillsInDemandID = skillsInDemandID;
	this.categoryName = categoryName;
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
     * @return the industryID
     */
    public int getIndustryID()
    {
	return industryID;
    }

    /**
     * @param industryID the industryID to set
     */
    public void setIndustryID(int industryID)
    {
	this.industryID = industryID;
    }

    /**
     * @return the employabilitySkillID
     */
    public int getEmployabilitySkillID()
    {
	return employabilitySkillID;
    }

    /**
     * @param employabilitySkillID the employabilitySkillID to set
     */
    public void setEmployabilitySkillID(int employabilitySkillID)
    {
	this.employabilitySkillID = employabilitySkillID;
    }

    /**
     * @return the skillsInDemandID
     */
    public int getSkillsInDemandID()
    {
	return skillsInDemandID;
    }

    /**
     * @param skillsInDemandID the skillsInDemandID to set
     */
    public void setSkillsInDemandID(int skillsInDemandID)
    {
	this.skillsInDemandID = skillsInDemandID;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName()
    {
	return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName)
    {
	this.categoryName = categoryName;
    }

}
