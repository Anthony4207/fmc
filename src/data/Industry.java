package data;

/**
 *
 * @author 3103503213
 */
public class Industry
{

    private int industryID;
    private String industryName;

    public Industry(int industryID, String industryName)
    {
	this.industryID = industryID;
	this.industryName = industryName;
    }
    
    @Override
    public String toString()
    {
        return this.industryName;
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
     * @return the industryName
     */
    public String getIndustryName()
    {
	return industryName;
    }

    /**
     * @param industryName the industryName to set
     */
    public void setIndustryName(String industryName)
    {
	this.industryName = industryName;
    }
}
