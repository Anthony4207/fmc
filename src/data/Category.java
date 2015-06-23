package data;

/**
 *
 * @author 3103503213
 */
public class Category
{

    private int categoryID;
    private int industryID;
    private String categoryName;

    public Category(int categoryID, int industryID, String categoryName)
    {
	this.categoryID = categoryID;
	this.industryID = industryID;
	this.categoryName = categoryName;
    }
    
    @Override
    public String toString()
    {
        return this.categoryName;
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
