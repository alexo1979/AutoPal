import java.util.HashMap;
import java.util.Map;
/**
 * Write a description of class CommandWords here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommandWords
{
        
    // instance variables - replace the example below with your own
    public static final String mainScreen = "main";
    public static final String taskScreen = "task";
    public static final String dataScreen = "data";
    
    private static final String[] mainCommands = {
        "1", "2", "3", "4", "5"
    };
    
    private static final String[] taskCommands = {
        "1", "2", "3", "4"
    };
    
    private static final String[] dataCommands = {
        "1", "2", "3", "4"
    };
   
    private static final Map<String, String[]> commandsMap;
    static
    {
        commandsMap = new HashMap<String, String[]>();
        commandsMap.put(mainScreen, mainCommands);
        commandsMap.put(taskScreen, taskCommands);
        commandsMap.put(dataScreen, dataCommands);
    }


    /**
     * Constructor for objects of class CommandWords
     */
    public CommandWords()
    {
        // initialise instance variables
    }

    /**
     * Check whether a given String is a valid Main command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String screen, String command)
    {
        String[] commands = commandsMap.get(screen);
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals(command))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    
}
