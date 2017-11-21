import java.util.List;

/**
 * Write a description of class View here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class View
{
    private CommandProcessor processor;
    private String currentScreen;

    /**
     * Create the game and initialise its internal map.
     */
    public View() 
    {
        //createScreens();
        currentScreen = CommandWords.mainScreen;
        processor = new CommandProcessor(currentScreen);

    }

    /**
     * Get the CommandProcessor.
     */
    public CommandProcessor getProcessor()
    {
        return processor;                
    }
    
    /**
     * Get the Current Screen name.
     */
    public String getCurrentScreen()
    {
        return currentScreen;                
    }
    
    /**
     * Set the Current Screen name.
     */
    public void setCurrentScreen(String screen)
    {
        this.currentScreen = screen;                
    }

    /**
     * Print out the opening message for the user.
     */
    public void printInvalidCommand()
    {
        System.out.println();
        System.out.println("===================INVALID COMMAND!!!===================");
        System.out.println();

    }
    
    /**
     * Print out the opening message for the user.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("==================Welcome to AUTOPAL!===================");
        System.out.println("   Here you can store and overview all expences about   ");
        System.out.println("your vehicles and save future tasks that you need to do.");
        System.out.println();

    }

    public void printMainOptions()
    {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("               You are in the Main Options              ");
        System.out.println("              Choose what do you want to do             ");
        System.out.println("========================================================");
        System.out.println("-For adding a new TASK ...............press 1");
        System.out.println("-For listing of TASKS ................press 2");
        System.out.println("-For adding a new DATA ...............press 3");
        System.out.println("-For listing of DATA .................press 4");
        System.out.println("-If you want to exit .................press 5");
        System.out.println();

    }

    public void printTaskOptions()
    {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("               You are in the Task Options              ");
        System.out.println("              Choose what do you want to do             ");
        System.out.println("========================================================");
        System.out.println("-For viewing of all TASKS ..................press 1");
        System.out.println("-For viewing TASKS by date .................press 2");
        System.out.println("-For viewing TASKS by vehicle ..............press 3");
        System.out.println("-If you want to go back ....................press 4");
        System.out.println();

    }

    public void printDataOptions()
    {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("               You are in the Data Options              ");
        System.out.println("              Choose what do you want to do             ");
        System.out.println("========================================================");
        System.out.println("-For viewing DATA of vehicle ...............press 1");
        System.out.println("-For viewing DATA of vehicle by date .......press 2");
        System.out.println("-For viewing DATA of vehicle by type .......press 3");
        System.out.println("-If you want to go back ....................press 4");
        System.out.println();

    }
    
    public String colectTask()
    {
        String newTask = null;
        String command = null;
        
        System.out.println();
        System.out.println("========================================================");
        System.out.println("           You are in the ADD TASK Options              ");
        System.out.println("      Please follow the walk through help dialog        ");
        System.out.println("      Please fill all the required data                 ");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Please enter the type of the payment task of the vehicle");
        System.out.println("You can choose one of the following options:");
        System.out.println("CARLOAN, FUEL, ACCESORIE, REGISTRATION, INSURANCE, SERVICEREPAIR");
        command = getProcessor().getData();
        newTask = command;
        
        System.out.println("Please enter the registration number of the vehicle");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter the manufacturer of the vehicle");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter the model of the vehicle");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter the amount for payment of the task");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter the payment date of the task");
        System.out.println("Enter the date in format yyyyMMdd (e.g. 20171206)");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter the reminder date of the task");
        System.out.println("Enter the date in format yyyyMMdd (e.g. 20171206)");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println("Please enter s short description of the task");
        command = getProcessor().getData();
        newTask += ";" + command;
        
        System.out.println();
        
        return newTask;

    }
    
    public String colectData()
    {
        String newData = null;
        String command = null;
        
        System.out.println();
        System.out.println("========================================================");
        System.out.println("           You are in the ADD DATA Options              ");
        System.out.println("      Please follow the walk through help dialog        ");
        System.out.println("      Please fill all the required data                 ");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Please enter the type of the payment data of the vehicle");
        System.out.println("You can choose one of the following options:");
        System.out.println("CARLOAN, FUEL, ACCESORIE, REGISTRATION, INSURANCE, SERVICEREPAIR");
        command = getProcessor().getData();
        newData = command;
        
        System.out.println("Please enter the registration number of the vehicle");
        command = getProcessor().getData();
        newData += ";" + command;
        
        System.out.println("Please enter the manufacturer of the vehicle");
        command = getProcessor().getData();
        newData += ";" + command;
        
        System.out.println("Please enter the model of the vehicle");
        command = getProcessor().getData();
        newData += ";" + command;
        
        System.out.println("Please enter the amount for payment of the task");
        command = getProcessor().getData();
        newData += ";" + command;
        
        System.out.println("Please enter the payment date");
        System.out.println("Enter the date in format yyyyMMdd (e.g. 20171206)");
        command = getProcessor().getData();
        newData += ";" + command;
        
        System.out.println();
        
        return newData;

    }
    
    public void printVehicleData(List<String> vehicle)
    {
        
        for(String vData : vehicle) {
            System.out.println();
            System.out.println(vData);
            System.out.println();        
        }         

    }
    
    public void printTasks(List<String> tasks)
    {
        for(String tData : tasks) {
            System.out.println();
            System.out.println(tData);
            System.out.println();        
        }         

    }
    
    public String getStartDate()
    {
        String command = null;
                    
        System.out.println("Please enter the start date");
        System.out.println("Enter the date in format yyyyMMdd (e.g. 20171206)");
        command = getProcessor().getData();
        
        System.out.println();
        
        return command;

    }
    
    public String getEndDate()
    {
        String command = null;
                    
        System.out.println("Please enter the end date");
        System.out.println("Enter the date in format yyyyMMdd (e.g. 20171206)");
        command = getProcessor().getData();
        
        System.out.println();
        
        return command;

    }
    
    public String getRegNo()
    {
        String command = null;
                    
        System.out.println("Please enter the registration number of the vehicle");
        command = getProcessor().getData();
                
        System.out.println();
        
        return command;

    }
    
    public String getType()
    {
        String command = null;
                    
        System.out.println("Please enter the type of the payment data of the vehicle");
        System.out.println("You can choose one of the following options:");
        System.out.println("CARLOAN, FUEL, ACCESORIE, REGISTRATION, INSURANCE, SERVICEREPAIR");
        command = getProcessor().getData();
                
        System.out.println();
        
        return command;

    }
}