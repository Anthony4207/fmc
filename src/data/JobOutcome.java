package data;

public class JobOutcome
{

    private int jobOutcomeID;
    private String jobOutcomeName;
    private boolean jobOutcomeInDemand;

    public JobOutcome(int jobOutcomeID, String jobOutcomeName, boolean jobOutcomeInDemand)
    {
        this.jobOutcomeID = jobOutcomeID;
        this.jobOutcomeName = jobOutcomeName;
        this.jobOutcomeInDemand = jobOutcomeInDemand;
    }

    /**
     * @return the jobOutcomeID
     */
    public int getJobOutcomeID()
    {
        return jobOutcomeID;
    }

    /**
     * @param jobOutcomeID the jobOutcomeID to set
     */
    public void setJobOutcomeID(int jobOutcomeID)
    {
        this.jobOutcomeID = jobOutcomeID;
    }

    /**
     * @return the jobOutcomeName
     */
    public String getJobOutcomeName()
    {
        return jobOutcomeName;
    }

    /**
     * @param jobOutcomeName the jobOutcomeName to set
     */
    public void setJobOutcomeName(String jobOutcomeName)
    {
        this.jobOutcomeName = jobOutcomeName;
    }

    /**
     * @return the jobOutcomeInDemand
     */
    public boolean isJobOutcomeInDemand()
    {
        return jobOutcomeInDemand;
    }

    /**
     * @param jobOutcomeInDemand the jobOutcomeInDemand to set
     */
    public void setJobOutcomeInDemand(boolean jobOutcomeInDemand)
    {
        this.jobOutcomeInDemand = jobOutcomeInDemand;
    }
}
