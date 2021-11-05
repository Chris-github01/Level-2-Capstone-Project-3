import java.io.*;
import java.util.*;
import java.text.*; // java.text package is imported to validate date format
import java.time.*; // java.time package is imported to edit due date

import static java.lang.System.out;

public class PoisedProgram1
{
    // Method 'updateFile' is used to update information for projects
    static void updateFile(String oldInfo, String newInfo)
    {
        File fileUpdate = new File("projectsFile.txt");

        StringBuilder oldContent = new StringBuilder();

        BufferedReader reader = null;
        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileUpdate));

            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null)
            {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent  `
            String newContent = oldContent.toString().replaceAll(oldInfo, newInfo);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileUpdate);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                assert reader != null;
                reader.close();

                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        try {
            // Variables are defined
            String menu;
            String menuUpdate;
            String deadline = "";
            String newDeadline;
            String erfNum;
            String projAddress;
            String projType;
            String projName;
            String projNum;
            String conEmail;
            String cliEmail;
            String cliName;
            String projComplete;
            float projValue = 0;
            float paidToDate = 0;
            float paidToDateNew;
            int arcTeleNum = 0;
            int cliTeleNum = 0;
            int conTeleNum = 0;
            int newTeleNum = 0;

            //The following objects are created
            PersonClass1 PersonArcObj;
            PersonClass1 PersonCliObj;
            PersonClass1 PersonConObj;
            ProjectClass1 ProjectObj;

            // A scanner object is created
            Scanner input = new Scanner(System.in);

            do {
                // A user menu is provided to either add a project of edit a specific one
                System.out.println("""
                                                
                        Please select one of the following by number:
                        1 - Add project
                        2 - Edit specific project
                        3 - View projects status
                        4 - View project
                        5 - Exit""");

                menu = input.nextLine();

                // switch-while loop is used as a conditional statement for the menu options
                switch (menu) {
                    // case 1 is used to add a project
                    case "1" -> {

                        input = new Scanner(System.in); // Reset Scanner

                        System.out.println("What is the project name?");
                        projName = input.nextLine();

                        // Each project will be written to its own text file for printing purposes
                        File newFile = new File(projName + ".txt");
                        FileWriter fw = new FileWriter(newFile);

                        System.out.println("Please enter the following info for " + projName);

                        // Persons information to be recorded
                        // Architect Input
                        System.out.println("\nArchitect Information");

                        System.out.println("\nWhat is your name?");
                        String arcName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (arcTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                System.out.println("What is your telephone number?");
                                arcTeleNum = input.nextInt();
                                input.nextLine();
                                break;
                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        System.out.println("What is your email address?");
                        String arcEmail = input.nextLine();

                        System.out.println("What is your company address?");
                        String arcCompAddress = input.nextLine();

                        // PersonClass is called to print Architect's info
                        PersonArcObj = new PersonClass1(arcName, arcTeleNum, arcEmail, arcCompAddress);

                        // PersonClass is called to write Architect's info to file 'projectsFile.txt'
                        fw.write("Architect Information\n" + PersonArcObj + "\n");
                        fw.flush();

                        // Client Input
                        System.out.println("\nClient Information");

                        System.out.println("\nWhat is your name?");
                        cliName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (cliTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                System.out.println("What is your telephone number?");
                                cliTeleNum = input.nextInt();
                                input.nextLine();
                                break;

                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        System.out.println("What is your email address?");
                        cliEmail = input.nextLine();

                        System.out.println("What is your company address?");
                        String cliCompAddress = input.nextLine();

                        // PersonClass is called to print Client's info
                        PersonCliObj = new PersonClass1(cliName, cliTeleNum, cliEmail, cliCompAddress);

                        // PersonClass is called to write Client's info to file 'projectFile.txt'
                        fw.write("\nClient Information\n" + PersonCliObj + "\n");
                        fw.flush();

                        // Contractor Input
                        System.out.println("\nContractor's Information");

                        System.out.println("\nWhat is your name?");
                        String conName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (conTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                System.out.println("What is your telephone number?");
                                conTeleNum = input.nextInt();
                                input.nextLine();
                                break;

                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        System.out.println("What is your email address?");
                        conEmail = input.nextLine();

                        System.out.println("What is your company address?");
                        String conCompAddress = input.nextLine();

                        // PersonClass is called to print Contractor's info
                        PersonConObj = new PersonClass1(conName, conTeleNum, conEmail, conCompAddress);

                        // PersonClass is called to write Client's info to file 'projectFile.txt'
                        fw.write("\nContractor's Information\n" + PersonConObj + "\n");
                        fw.flush();

                        // All user input variables are printed
                        System.out.println("\nArchitect Information");
                        System.out.println(PersonArcObj);

                        System.out.println("\nClient Information");
                        System.out.println(PersonCliObj);

                        System.out.println("\nContractor Information");
                        System.out.println(PersonConObj);

                        // Project information to be recorded
                        System.out.println("\nProject information");

                        System.out.println("\nWhat is the project number?");
                        projNum = input.nextLine();

                        System.out.println("What is the project type?");
                        projType = input.nextLine();

                        System.out.println("What is the project address?");
                        projAddress = input.nextLine();

                        System.out.println("What is the ERF number?");
                        erfNum = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (projValue >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                System.out.println("What is the project value?");
                                projValue = input.nextFloat();
                                input.nextLine();
                                break;
                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (paidToDate >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                System.out.println("What is the total amount paid to date?");
                                paidToDate = input.nextFloat();
                                input.nextLine();
                                break;

                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        while (true) {
                            // The date format is set as dd/mm/yyyy
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            dateFormat.setLenient(false);

                            // A try catch block is used to validate the date format
                            try {
                                System.out.println("What is the project deadline? (dd/mm/yyyy)");
                                deadline = input.nextLine();
                                Date userDate = dateFormat.parse(deadline);
                                break;

                            }
                            // An error message will appear if the input format is incorrect
                            catch (ParseException e) {
                                System.out.println("Invalid format. Please enter correct format as dd/mm/yyyy");
                            }
                        }
                        System.out.println("Is the project complete? Yes/ No");
                        projComplete = input.nextLine();

                        // ProjectClass is called to print Project's info
                        ProjectObj = new ProjectClass1(projNum, projName, projType, projAddress, erfNum,
                                projValue, paidToDate, deadline, projComplete);

                        System.out.println("\nProject Information");
                        System.out.println(ProjectObj);

                        // ProjectClass is called to write the project's info to file 'projectFile.txt'
                        fw.write("\nProject information\n" + ProjectObj + "\n");
                        fw.flush();

                        FileWriter fw2 = null;
                        BufferedWriter bw2 = null;
                        PrintWriter pw2 = null;

                        // try catch block used to add new projects to file 'projectsFile.txt'
                        try {
                            fw2 = new FileWriter("projectsFile.txt", true);
                            bw2 = new BufferedWriter(fw2);
                            pw2 = new PrintWriter(bw2);

                            // The below variables are cast to String values, to be written to the text file
                            String arcNumber = Integer.toString(arcTeleNum);
                            String cliNumber = Integer.toString(cliTeleNum);
                            String conNumber = Integer.toString(conTeleNum);
                            String value = Float.toString(projValue);
                            String paid = Float.toString(paidToDate);

                            // The recorded info is written to 'projectsFile.txt'
                            String[] projectSummary = {projName, arcName, arcNumber, arcEmail, arcCompAddress,
                                    cliName, cliNumber, cliEmail, cliCompAddress,
                                    conName, conNumber, conEmail, conCompAddress,
                                    projNum, projType, projAddress,
                                    erfNum, value, paid, deadline, projComplete};

                            // The above array is cast to a string to be written to the text file 'projectsFile.txt'
                            pw2.write(Arrays.toString(projectSummary) + "\n");
                            pw2.flush();

                        }
                        // An error message will be displayed if the file is not found
                        catch (IOException e) {
                            out.println("File not found");
                        }
                    }
                    // case 2 is used to edit a specific project
                    case "2" -> {
                        try
                        {
                            // FileReader and BufferedReader is used to read the content in projectsFile.txt
                            FileReader fr = new FileReader("projectsFile.txt");
                            BufferedReader br = new BufferedReader(fr);

                            // Variables are defined to be used
                            String line;
                            String strLine;
                            String[] lineSubstring;
                            String projectName;
                            String oldDeadline;

                            System.out.println("\nThe following projects are recorded:");

                            // The while loop is used to print all the projects that are recorded in projectsFile.txt
                            while ((line = br.readLine()) != null)
                            {
                                // Remove first and last character
                                strLine = line.substring(1, line.length() -1);

                                // Create substrings by splitting the line between the commas ','
                                lineSubstring = strLine.split(", ");

                                // lineSubstring[0] is the first string in the line, in this case the project name
                                projectName = lineSubstring[0];

                                // All the project names are printed for the user to choose which project to be edited
                                System.out.println(projectName);
                            }

                            input = new Scanner(System.in); // Scanner reset

                            System.out.println("\nSelect a project from the list by name:");
                            String project = input.nextLine();

                            // project info to be printed is defined as a string variable 'projInfo'
                            String projInfo;

                            // This try block will check if the user enters the correct project name
                            // and if the file exists. If not, an error message will be displayed
                            try
                            {
                                // FileReader and BufferedReader is used to read the content in projectsFile.txt
                                FileReader fr2 = new FileReader(project + ".txt");
                                BufferedReader br2 = new BufferedReader(fr2);

                                while ((projInfo = br2.readLine()) != null) {

                                    // The project info for the selected project from the list is printed
                                    System.out.println(projInfo);
                                }
                                br2.close();
                            }
                            catch(IOException e)
                            {
                                // An error message will be displayed if the user input does not match the list
                                // of projects
                                System.out.println("File not found");
                                break;
                            }

                            // A do-while loop is used to loop through the below menu until the user enters '5'
                            do
                            {
                                // User menu is created to edit information of the project and contractor
                                System.out.println("""
                                                                   
                                        Please select one of the following by number:
                                        1 - Change due date
                                        2 - Change total amount paid
                                        3 - Change contractor's details
                                        4 - Finalise project
                                        5 - Return to main menu""");

                                menuUpdate = input.nextLine();

                                // A switch block is used for 'menuUpdate' to allow the user to select the options
                                // in the given menu.
                                switch (menuUpdate)
                                {
                                    // Option one is used to change the due date of the project
                                    case "1" -> {
                                        input = new Scanner(System.in); // Reset scanner

                                        while (true)
                                        {
                                            // The date format is set as dd/mm/yyyy. If the user enters a date in a
                                            // different format, an error message will be displayed
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            dateFormat.setLenient(false);

                                            // A try catch block is used to validate the date format
                                            try {
                                                System.out.println(deadline);
                                                System.out.println("What is the new deadline? (dd/mm/yyyy)");
                                                newDeadline = input.nextLine();

                                                // FileReader and BufferedReader is used to read the content
                                                // in projectsFile.txt
                                                FileReader fr1 = new FileReader("projectsFile.txt");
                                                BufferedReader br1 = new BufferedReader(fr1);

                                                while ((line = br1.readLine()) != null)
                                                {
                                                    // Remove first and last character
                                                    strLine = line.substring(1, line.length() -1);

                                                    // Create substrings by splitting the line between the commas ','
                                                    lineSubstring = strLine.split(", ");

                                                    // The if statement checks if the user input matches the projects
                                                    // listed in file 'projectsFile.txt'
                                                    if(Objects.equals(lineSubstring[0], project))
                                                    {
                                                        // lineSubstring[19] is the due date in projectsFile
                                                        oldDeadline = lineSubstring[19];

                                                        // Initial deadline is replaced with new user input deadline
                                                        String strNewLine = strLine.replace(oldDeadline, newDeadline);

                                                        // Method 'updateFile' is called to update the deadline. It is
                                                        // overwritten in the projectsFile
                                                        updateFile(strLine, strNewLine);
                                                    }
                                                }
                                                Date userDate = dateFormat.parse(newDeadline);

                                                // User is informed that the date is updated
                                                System.out.println("\nDeadline is updated");
                                                break;
                                            }
                                            catch (ParseException e)
                                            {
                                                // An error message will appear if the input format is incorrect
                                                System.out.println("Invalid format. Please enter correct format as dd/mm/yyyy");
                                            }
                                        }
                                    }
                                    // Option 2 is used to change the amount paid for the project
                                    case "2" -> {
                                        while (true)
                                        {
                                            // A try catch block is used to validate the date format
                                            try {
                                                input = new Scanner(System.in); // Reset scanner

                                                System.out.println("What is the new amount paid to date?");
                                                paidToDateNew = input.nextInt();
                                                input.nextLine();

                                                // FileReader and BufferedReader is used to read the content
                                                // in projectsFile.txt
                                                FileReader fr1 = new FileReader("projectsFile.txt");
                                                BufferedReader br1 = new BufferedReader(fr1);

                                                while ((line = br1.readLine()) != null)
                                                {
                                                    // Remove first and last character
                                                    strLine = line.substring(1, line.length() -1);

                                                    // Create substrings by splitting the line between the commas ','
                                                    lineSubstring = strLine.split(", ");

                                                    // The if statement checks if the user input matches the projects
                                                    // listed in file 'projectsFile.txt'
                                                    if(Objects.equals(lineSubstring[0], project))
                                                    {
                                                        // 'paidToDate' variable is cast to a String value to be written
                                                        // to the text file
                                                        String strNewAmount = Float.toString(paidToDateNew);

                                                        // lineSubstring[18] is the amount paid in projectsFile
                                                        String strOldAmount = lineSubstring[18];

                                                        // Initial amount paid is replaced with new user input
                                                        String strNewLine = strLine.replace(strOldAmount, strNewAmount);

                                                        // Method 'updateFile' is called to update the payment. It is
                                                        // overwritten in the projectsFile
                                                        updateFile(strLine, strNewLine);
                                                    }
                                                }
                                                // User is informed that the payment is updated
                                                System.out.println("\nPayment is updated");
                                                break;
                                            }
                                            // An error message will appear if the input format is incorrect
                                            catch (InputMismatchException e) {
                                                System.out.println("Invalid number. Please enter correct number");
                                            }
                                        }
                                    }
                                    // Option 3 is used to change the contractor's info
                                    case "3" -> {
                                        input = new Scanner(System.in); // Reset Scanner

                                        // A second menu is created to update the contact details of the contractor
                                        System.out.println("""
                                                                           
                                                Please select one of the following by number:
                                                1 - Update client telephone number
                                                2 - Update client email address
                                                """);
                                        String contractorInfoUpdate = input.nextLine();

                                        while (true)
                                        {
                                            // A nested if statement is used to change the telephone number and email address
                                            // Option 1 is used to change the telephone number
                                            if (Objects.equals(contractorInfoUpdate, "1")) {

                                                input = new Scanner(System.in); // Reset Scanner

                                                // A try-catch block inside a while loop is used to validate that the user input
                                                // is a number and not a string value
                                                while (newTeleNum >= 0)
                                                {
                                                    try {
                                                        input = new Scanner(System.in); // Reset scanner

                                                        System.out.println("What is the new telephone number?");
                                                        newTeleNum = input.nextInt();
                                                        input.nextLine();

                                                        // FileReader and BufferedReader is used to read the content
                                                        // in projectsFile.txt
                                                        FileReader fr1 = new FileReader("projectsFile.txt");
                                                        BufferedReader br1 = new BufferedReader(fr1);

                                                        while ((line = br1.readLine()) != null)
                                                        {
                                                            // Remove first and last character
                                                            strLine = line.substring(1, line.length() -1);

                                                            // Create substrings by splitting the line between the commas ','
                                                            lineSubstring = strLine.split(", ");

                                                            // The if statement checks if the user input matches the projects
                                                            // listed in file 'projectsFile.txt'
                                                            if(Objects.equals(lineSubstring[0], project))
                                                            {
                                                                // 'newTeleNum' variable is cast to a String value to be written
                                                                // to the text file
                                                                String strNewNumber = Integer.toString(newTeleNum);

                                                                // lineSubstring[10] is the contractor's telephone number
                                                                // in projectsFile to be updated
                                                                String strOldNumber = lineSubstring[10];

                                                                // Initial telephone number is replaced with new user input
                                                                String strNewLine = strLine.replace(strOldNumber, strNewNumber);

                                                                // Method 'updateFile' is called to update the telephone
                                                                // number. It is overwritten in the projectsFile
                                                                updateFile(strLine, strNewLine);
                                                            }
                                                        }
                                                        // User is informed that the telephone number is updated
                                                        System.out.println("\nContractor telephone number is updated");
                                                        break;
                                                    }
                                                    // An error message will appear if the input format is incorrect
                                                    catch (InputMismatchException e) {
                                                        System.out.println("Invalid number. Please enter a valid number");
                                                    }
                                                }
                                                break;
                                            }

                                            // Option 2 is used to change the email address
                                            else if (Objects.equals(contractorInfoUpdate, "2")) {

                                                input = new Scanner(System.in); // Reset Scanner

                                                System.out.println("What is the new email address?");
                                                String emailNew = input.nextLine();

                                                // FileReader and BufferedReader is used to read the content
                                                // in projectsFile.txt
                                                FileReader fr1 = new FileReader("projectsFile.txt");
                                                BufferedReader br1 = new BufferedReader(fr1);

                                                while ((line = br1.readLine()) != null)
                                                {
                                                    // Remove first and last character
                                                    strLine = line.substring(1, line.length() -1);

                                                    // Create substrings by splitting the line between the commas ','
                                                    lineSubstring = strLine.split(", ");

                                                    // The if statement checks if the user input matches the projects
                                                    // listed in file 'projectsFile.txt'
                                                    if(Objects.equals(lineSubstring[0], project))
                                                    {
                                                        // lineSubstring[11] is the contractor's email address
                                                        // in projectsFile to be updated
                                                        String strOldEmail = lineSubstring[11];

                                                        // Initial email address is replaced with new user input
                                                        String strNewLine = strLine.replace(strOldEmail, emailNew);

                                                        // Method 'updateFile' is called to update the telephone
                                                        // number. It is overwritten in the projectsFile
                                                        updateFile(strLine, strNewLine);
                                                    }
                                                }
                                                // User is informed that the email address is updated
                                                System.out.println("\nContractor email address is updated");
                                                break;
                                            }

                                            // An error message will display if an invalid option is entered
                                            else {
                                                System.out.println("Invalid input. Please enter a valid number.");

                                                // If an error message is displayed, the user will be redirected to
                                                // contractorInfoUpdate menu
                                                contractorInfoUpdate = input.nextLine();
                                            }
                                        }
                                    }

                                    // Option 4 is used to generate an invoice
                                    case "4" -> {

                                        // FileReader and BufferedReader is used to read the content
                                        // in projectsFile.txt
                                        FileReader fr1 = new FileReader("projectsFile.txt");
                                        BufferedReader br1 = new BufferedReader(fr1);

                                        while ((line = br1.readLine()) != null)
                                        {
                                            // Remove first and last character
                                            strLine = line.substring(1, line.length() - 1);

                                            // Create substrings by splitting the line between the commas ','
                                            lineSubstring = strLine.split(", ");

                                            // The if statement checks if the user input matches the projects
                                            // listed in file 'projectsFile.txt'
                                            if (Objects.equals(lineSubstring[0], project)) {

                                                // 'ProjValue' and 'PaidToDate' are two substrings used to calculate
                                                // the amount due
                                                String strProjValue = lineSubstring[17];
                                                String strPaidToDate = lineSubstring[18];

                                                // 'ProjValue' and 'PaidToDate' are cast to float values to calculate
                                                // the amount due
                                                float floatProjectValue = Float.parseFloat(strProjValue);
                                                float floatPaidToDate = Float.parseFloat(strPaidToDate);

                                                float amountDue = (floatProjectValue - floatPaidToDate);

                                                // Final amount due is formatted to two decimal places
                                                String strAmountDue = String.format("%.02f", amountDue);

                                                // If the project is paid off, no invoice will be generated
                                                if (amountDue <= 0) {
                                                    System.out.println("\nNo invoice needed. The project is paid off.");
                                                }

                                                // If there is an outstanding balance on the project, an invoice will be generated
                                                else if (amountDue > 0) {

                                                    System.out.println("\nInvoice"
                                                            + "\nClient name:\t" + lineSubstring[5]
                                                            + "\nClient number: \t" + "0" + lineSubstring[6]
                                                            + "\nClient email:\t" + lineSubstring[7]
                                                            + "\nProject name:\t" + lineSubstring[0]
                                                            + "\nProject number:\t" + lineSubstring[13]
                                                            + "\nDue date:\t\t" + lineSubstring[19]
                                                            + "\nAmount due: \t" + "R" + strAmountDue);
                                                }
                                            }
                                        }
                                    }
                                    // Case 5 will return to the main menu
                                    case "5" -> {
                                    }
                                    // If the user input for 'menu_update' is invalid, the user will be notified
                                    // and the loop will start at the user menu
                                    default -> System.out.print("\nInvalid option. Please enter correct number\n");
                                }
                            }
                            // The session from menuUpdate will end if the user enters '5'
                            while (!menuUpdate.equals("5"));

                            br.close();
                        }
                        // An error message will appear if the file is not found
                        catch (IOException e) {
                            System.out.println("File not found");
                        }
                    }
                    // case 3 is used to view projects status from the main menu
                    case "3" -> {
                        try
                        {
                            // FileReader and BufferedReader is used to read the content
                            // in projectsFile.txt
                            FileReader fr = new FileReader("projectsFile.txt");
                            BufferedReader br = new BufferedReader(fr);

                            // String variables are defined to be used below
                            String line;
                            String strLine;
                            String[] lineSubstring;

                            input = new Scanner(System.in); // Reset Scanner

                            // A third menu is created to view incomplete and past due date projects
                            System.out.println("""
                                                               
                                    Please select one of the following by number:
                                    1 - View incomplete projects
                                    2 - View projects overdue
                                    """);
                            String projectStatus = input.nextLine();

                            while (true)
                            {
                                // A nested if statement is used to view incomplete projects as well as projects that
                                // are overdue
                                if (Objects.equals(projectStatus, "1")) {

                                    // FileReader and BufferedReader is used to read the content
                                    // in projectsFile.txt
                                    FileReader fr1 = new FileReader("projectsFile.txt");
                                    BufferedReader br1 = new BufferedReader(fr1);

                                    System.out.println("The following projects are incomplete:");

                                    while ((line = br1.readLine()) != null) {

                                        // Remove first and last character
                                        strLine = line.substring(1, line.length() - 1);

                                        // Create substrings by splitting the line between the commas ','
                                        lineSubstring = strLine.split(", ");
                                        String incomplete = lineSubstring[20];

                                        // If lineSubstring[20] is equal to "No" the projects will be displayed
                                        if(Objects.equals(incomplete, "No")) {
                                            System.out.println(lineSubstring[0]);
                                        }
                                    }
                                    break;
                                }
                                // The else if statement check for projects that are overdue
                                else if (Objects.equals(projectStatus, "2")) {

                                    // 'LocalDate.now()' function is used to compare the current date to the recorded
                                    // date in the text file
                                    LocalDate currentDate = LocalDate.now();

                                    // The date format is split between the year and month which will be used seperately
                                    // to check if the due date is overdue
                                    int intCurrentYear = currentDate.getYear();
                                    int intCurrentMonth = currentDate.getMonthValue();

                                    // FileReader and BufferedReader is used to read the content
                                    // in projectsFile.txt
                                    FileReader fr1 = new FileReader("projectsFile.txt");
                                    BufferedReader br1 = new BufferedReader(fr1);

                                    System.out.println("The following projects are overdue:");

                                    while ((line = br1.readLine()) != null)
                                    {

                                        // Remove first and last character
                                        strLine = line.substring(1, line.length() - 1);

                                        // Create substrings by splitting the line between the commas ','
                                        lineSubstring = strLine.split(", ");
                                        String date = lineSubstring[19];

                                        // The date substring is split again between the forward slash '/' to use the
                                        // year and month seperately to check if the date is overdue
                                        String[] dateSplit = date.split("/");
                                        String strDateYear = dateSplit[2];
                                        String strDateMonth = dateSplit[1];

                                        // The year and month values are cast to integer values to calculate the overdue
                                        // value
                                        int intDateYear = Integer.parseInt(strDateYear);
                                        int intDateMonth = Integer.parseInt(strDateMonth);

                                        int overdueYear = (intCurrentYear - intDateYear);
                                        int overdueMonth = (intCurrentMonth - intDateMonth);

                                        // If the year value is less than zero and the month value is less that zero,
                                        // the project will be displayed as overdue
                                        if((overdueYear < 0 && overdueMonth < 0) || (overdueYear < 0)){
                                            System.out.println(lineSubstring[0]);
                                        }
                                    }
                                    break;
                                }
                                else{
                                    // An error message will be displayed if an invalid menu option is entered
                                    System.out.println("Invalid input. Please enter a valid number.");

                                    // If an error message is displayed, the user will be redirected to
                                    // projectStatus menu
                                    projectStatus = input.nextLine();
                                }
                            }
                        }
                        // An error message will be displayed if the file is not found
                        catch (IOException e) {
                            System.out.println("File not found");
                        }
                    }
                    // Case 4 will print a specific project onto the screen
                    case "4" ->{
                        try{
                            // FileReader and BufferedReader is used to read the content
                            // in projectsFile.txt
                            FileReader fr = new FileReader("projectsFile.txt");
                            BufferedReader br = new BufferedReader(fr);

                            // String variables are defined to be used below
                            String line;
                            String strLine;
                            String[] lineSubstring;
                            String projectName;

                            System.out.println("\nThe following projects are recorded:");

                            while ((line = br.readLine()) != null)
                            {
                                // Remove first and last character
                                strLine = line.substring(1, line.length() -1);

                                // Create substrings by splitting the line between the commas ','
                                lineSubstring = strLine.split(", ");
                                projectName = lineSubstring[0];

                                // The recorded projects are printed on the screen for the user to select which project
                                // info to be displayed on the screen
                                System.out.println(projectName);
                            }

                            input = new Scanner(System.in); // Scanner reset

                            System.out.println("\nSelect a project from the list by name:");
                            String project = input.nextLine();

                            String projInfo;

                            // This try block will check if the user enters the correct project name
                            // and if the file exists. If not, an error message will be displayed
                            try
                            {
                                // FileReader and BufferedReader is used to read the content
                                // in projectsFile.txt
                                FileReader fr2 = new FileReader(project + ".txt");
                                BufferedReader br2 = new BufferedReader(fr2);

                                // The selected project info is printed on the screen
                                while ((projInfo = br2.readLine()) != null) {
                                    System.out.println(projInfo);
                                }
                                br2.close();
                            }
                            catch(IOException e)
                            {
                                System.out.println("File not found");
                            }
                        }
                        catch (IOException e)
                        {
                            System.out.println("File not found");
                        }
                    }
                    // case 5 is used to terminate the program
                    case "5" -> {
                        System.out.println("Session ended");
                    }

                    // If the user input for 'menu_update' is invalid, the user will be notified
                    // and the loop will start at the user menu
                    default -> System.out.print("\nInvalid option. Please enter correct number\n");
                }
            }
            // The session from menu will end if the user enters '5'
            while (!menu.equals("5"));
        }
        catch (FileNotFoundException e)
        {
            out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException ioe)
        {
            System.out.println("Could not write to file");
        }
    }
}

 /*
References:
https://beginnersbook.com/2013/04/oops-concepts/
https://beginnersbook.com/2013/03/constructors-in-java/
https://codescracker.com/java/java-objects-classes.htm
https://www.javatpoint.com/java-oops-concepts
https://www.w3schools.com/java/java_methods.asp
https://www.w3schools.com/java/java_classes.asp
https://beginnersbook.com/2013/05/java-date-format/
 */
