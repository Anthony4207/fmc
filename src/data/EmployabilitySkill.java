package data;

/**
 *
 * @author 3103503213
 */
public class EmployabilitySkill
{
    
    private int employabilitySkillID;
    private String employabilitySkill;
    private String employabilitySkillRequirements;
    
    public EmployabilitySkill(int employabilitySkillID, String employabilitySkill, String employabilitySkillRequirements)
    {
	this.employabilitySkillID = employabilitySkillID;
	this.employabilitySkill = employabilitySkill;
	this.employabilitySkillRequirements = employabilitySkillRequirements;
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
     * @return the employabilitySkill
     */
    public String getEmployabilitySkill()
    {
	return employabilitySkill;
    }

    /**
     * @param employabilitySkill the employabilitySkill to set
     */
    public void setEmployabilitySkill(String employabilitySkill)
    {
	this.employabilitySkill = employabilitySkill;
    }

    /**
     * @return the employabilitySkillRequirements
     */
    public String getEmployabilitySkillRequirements()
    {
	return employabilitySkillRequirements;
    }

    /**
     * @param employabilitySkillRequirements the employabilitySkillRequirements to set
     */
    public void setEmployabilitySkillRequirements(String employabilitySkillRequirements)
    {
	this.employabilitySkillRequirements = employabilitySkillRequirements;
    }
}
