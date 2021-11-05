public class PersonClass1
{
    // Attributes
    String name;
    int teleNum;
    String email;
    String compAddress;

    // Constructor
    public PersonClass1(String name, int teleNum, String email, String compAddress)
    {
        this.name = name;
        this.teleNum = teleNum;
        this.email = email;
        this.compAddress = compAddress;
    }

    // String toString Method
    public String toString()
    {
        String output = "Name: " + name;
        output += "\nTelephone Number: 0" + teleNum;
        output += "\nEmail Address: " + email;
        output += "\nCompany Address: " + compAddress;

        return(output);
    }

    // User method 'phoneNum'
    public void phoneNum(int newTeleNum)
    {
        this.teleNum = newTeleNum;
    }

    // User method 'emailAddress'
    public void emailAddress(String newEmail)
    {
        this.email = newEmail;
    }
}
