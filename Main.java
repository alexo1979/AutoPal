
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    
    private View view;
    private Manager manager;
    
     /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        this.view = new View();
        this.manager = new Manager();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void start() 
    {            
        manager.loadBase();
        view.printWelcome();
        view.printMainOptions();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            String command = view.getProcessor().getCommand();
            if (command == null) {
                //Invalid command...
                view.printInvalidCommand();
            }
            //finished = view.processCommand(command);
            finished = proccessCommands(command);
        }
        System.out.println("Thank you for using AUTOPAL.  Good bye.");
    }
    
    public boolean proccessCommands(String command)
    {
        boolean wantToQuit = false;
        
        if(view.getCurrentScreen().equals(CommandWords.mainScreen)) {
            
            switch (command){
                case "1" :                
                {
                    //add task selected
                    String newTask = view.colectTask();
                    manager.addTask(newTask);
                    view.printMainOptions();
                    break;
                }
                case "2" :
                {
                    // change the screen show tasks selected
                    view.setCurrentScreen(CommandWords.taskScreen);
                    view.printTaskOptions();
                    break;
                }
                case "3" :
                {
                    //add data selected
                    String newData = view.colectData();
                    manager.addData(newData);
                    view.printMainOptions();
                    break;
                }
                case "4" :
                {
                    //change the screen show data selected
                    view.setCurrentScreen(CommandWords.dataScreen);
                    view.printDataOptions();
                    break;
                }
                case "5" :
                {
                    //quit th application selected
                    manager.saveBase();
                    wantToQuit = true;
                    break;
                }
                
            }
            
        }

        else if(view.getCurrentScreen().equals(CommandWords.taskScreen)) {
            switch (command){
                case "1" :
                {
                    //print all tasks selected
                    view.printTasks(manager.getAllTasks());
                    view.printTaskOptions();
                    break;
                }
                case "2" :
                {
                    //print tasks by date selected
                    String startDate = view.getStartDate();
                    String endDate = view.getEndDate();
                    view.printTasks(manager.getTasksByDate(startDate, endDate));
                    view.printTaskOptions();
                    break;
                }
                case "3" :
                {
                    //print tasks by vehicle selected
                    String regNo = view.getRegNo();
                    view.printTasks(manager.getTasksByVehicle(regNo));
                    view.printTaskOptions();
                    break;
                }
                case "4" :
                {
                    //back to main options selected
                    view.setCurrentScreen(CommandWords.mainScreen);
                    view.printMainOptions();
                    break;
                }
                
            }
        }

        else if(view.getCurrentScreen().equals(CommandWords.dataScreen)) {
            
            switch (command){
                case "1" :
                {
                    //print data by vehicle selected
                    String regNo = view.getRegNo();
                    view.printVehicleData(manager.getDataByVehicle(regNo));
                    view.printDataOptions();
                    break;
                }
                case "2" :
                {
                    //print data for vehicle by date selected
                    String regNo = view.getRegNo();
                    String startDate = view.getStartDate();
                    String endDate = view.getEndDate();
                    view.printVehicleData(manager.getDataByDate(regNo, startDate, endDate));
                    view.printDataOptions();
                    break;
                }
                case "3" :
                {
                    //print data for vehicle by type selected
                    String regNo = view.getRegNo();
                    String type = view.getType();
                    view.printVehicleData(manager.getDataByType(regNo, type));
                    view.printDataOptions();
                    break;
                }
                case "4" :
                {
                    //back to main options selected
                    view.setCurrentScreen(CommandWords.mainScreen);
                    view.printMainOptions();
                    break;
                }

            }
        
        }

        // implementations of user commands:

        return wantToQuit;

    }
               
}
