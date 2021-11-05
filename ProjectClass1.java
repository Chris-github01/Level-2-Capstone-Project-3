public class ProjectClass1
{
    // Attributes
    private final String projNum;
    private final String projName;
    private final String projType;
    private final String projAddress;
    private final String erfNum;
    private final float projValue;
    private float paidToDate;
    private String deadline;
    private final String projComplete;

    // Constructor
    public ProjectClass1(String projNum, String projName, String projType, String projAddress,
                        String erfNum, float projValue, float paidToDate, String deadline, String projComplete)
    {
        this.projNum = projNum;
        this.projName = projName;
        this.projType = projType;
        this.projAddress = projAddress;
        this.erfNum = erfNum;
        this.projValue = projValue;
        this.paidToDate = paidToDate;
        this.deadline = deadline;
        this.projComplete = projComplete;
    }

    // String toString Method
    public String toString()
    {
        String output = "Project number: " + projNum;
        output += "\nProject name: " + projName;
        output += "\nProject type: " + projType;
        output += "\nProject address : " + projAddress;
        output += "\nERF number: " + erfNum;
        output += "\nProject value: R" + projValue;
        output += "\nAmount paid to date: R" + paidToDate;
        output += "\nProject deadline: " + deadline;
        output += "\nProject status: " + projComplete;

        return(output);
    }

    // User method 'projDeadline'
    public void projDeadline(String newDeadline)
    {
        this.deadline = newDeadline;
    }

    // User method 'projNewAmountPaid'
    public void projNewAmountPaid(float newPaidToDate)
    {
        this.paidToDate = newPaidToDate;
    }
}
