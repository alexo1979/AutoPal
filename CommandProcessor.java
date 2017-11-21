import java.util.Scanner;

/**
 * Write a description of class Parser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommandProcessor 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input
    private String screen;          // selected option screen
    
    /**
     * Create a processor to read from the terminal window 
     * and control the commands.
     */
    public CommandProcessor(String screen) 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
        this.screen = screen;
    }

    /**
     * @return The next command from the user.
     */
    public String getCommand() 
    {
        String inputLine;   // will hold the full input line
        String command = null;
        //this.screen = screen;
                
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        // Find the first word on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            command = tokenizer.next();      // get first word
            // note: we just ignore the rest of the input line.

        }

        // Now check whether this word is known.
        // If not, create a "null" command (for unknown command).
        if(!commands.isCommand(screen, command)){
            command = null;
        }
        
        return command;
    }
    
    /**
     * @return The next data from the user.
     */
    public String getData() 
    {
        String inputLine;   // will hold the full input line
        String command = null;
        //this.screen = screen;
                
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        // Find the first word on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            command = tokenizer.next();      // get first word
            // note: we just ignore the rest of the input line.

        }
             
        return command;
    }
}
