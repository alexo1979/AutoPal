
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * class ComunicatorIO.
 * This class is responsible for storing 
 * vehicle and task data in files in a local folder
 * called "data".
 * Everytime the application starts thic class is going
 * to provide the stored data. And when the application
 * is closed it's going to store the data in different
 * files for every vehicle an one file for upcomming tasks.
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/13
 */
public class ComunicatorIO
{
    // the folder for storing data
    String fileFolder;
    String fileExtension;
    String vehicleExtension;
    String tasksFileName;
    /**
     * Constructor for objects of class ComunicatorIO
     */
    public ComunicatorIO()
    {
        // Set the folder for storing data.
        this.fileFolder = "data";
        this.fileExtension = ".txt";
        this.tasksFileName = "tasks";
    }

    /**
     * Creates the path to where the file is 
     * going to be stored.
     *
     * @param  fileName The name of the file that needs to be manipulated.
     * @return          The complete path to the file.
     */
    public String createFilePath(String fileName)
    {
        if (this.tasksFileName.equals(fileName)){
            return this.fileFolder + File.separator + fileName + this.fileExtension;
        }
        else{
            return this.fileFolder + File.separator + fileName +
            vehicleExtension+ this.fileExtension;
        }

    }

    /**
     * Search for a storage file for tasks in folder "data"
     * If there is not one it creates it.
     * 
     * @return     tasksPath     The complete path to the file.
     */
    public String findTaskFile()
    {
        String tasksPath = createFilePath(this.tasksFileName);

        File folder = new File(this.fileFolder);
        if (folder.isDirectory()) {

            FilenameFilter filter = new FilenameFilter() {
                    public boolean accept(File file, String name) {
                        if (name.endsWith("tasks.txt")) {
                            // filters files whose extension is .mp3
                            return true;
                        } else {
                            return false;
                        }
                    }
                };

            File[] listOfFiles = folder.listFiles();

            if (listOfFiles.length < 1){
                System.out.println("There is no File inside Folder.");
                createFile(this.tasksFileName);
            }

        }
        else {
            System.out.println("There is no Folder @ given path :" + tasksPath);
            createFile(this.tasksFileName);
        }

        return tasksPath;
    }

    /**
     * Search for a storage file for tasks in folder "data"
     *
     * @return    vehiclePaths     The array of complete path to the files.
     */
    public String[] findVehicleFiles()
    {
        //String tasksPath = createFilePath(this.tasksFileName);

        File folder = new File(this.fileFolder);
        if (folder.isDirectory()) {

            FilenameFilter filter = new FilenameFilter() {
                    public boolean accept(File file, String name) {
                        if (name.endsWith("CAR.txt")) {
                            // filters files whose extension is .mp3
                            return true;
                        } else {
                            return false;
                        }
                    }
                };

            File[] listOfFiles = folder.listFiles();

            String [] fileNames = new String[listOfFiles.length];
            for (int i = 0; i < listOfFiles.length; i++) {
                fileNames[i] = listOfFiles[i].getName();
            }

            String [] vehiclePaths = new String[fileNames.length];
            for (int i = 0; i < fileNames.length; i++) {
                vehiclePaths[i] = createFilePath(fileNames[i]);
            }
            if (listOfFiles.length < 1){
                System.out.println("There is no File inside Folder.");
                return null;
            }
            else {
                return vehiclePaths;
            }

        }
        else {
            System.out.println("There is no Folder @ given path " );
            return null;
        }
        
    }

    /**
     * Creates a new file.
     * Creates new file if there isn't a file.
     *
     *
     * @param  fileName The name of the file that needs to be created.
     * @return newFile  If a file is created returns true.
     */
    public boolean createFile(String fileName)
    {
        //Tells is it a new file or not
        boolean newFile = true;
        String filePath = createFilePath(fileName);

        try {

            File file = new File(filePath);

            if (file.createNewFile()){
                System.out.println("File creation successfull");
                newFile = false;
            }
            else {
                System.out.println("File already exists in specified path");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFile;
    }

    /**
     * Reads from an existing file.
     *
     * @param  fileName The name of the file to read.
     * @return file     List of strings. Every string represents a line.
     */
    public List<String> readFile(String fileName)
    {
        // This will reference one line at a time
        String line = null;
        //For storing the file
        List<String> file = new ArrayList<>();
        String filePath = createFilePath(fileName);

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filePath);

            // Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //Store the file in a List of strings(lines)
                file.add(line);
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        return file;
    }

    /**
     * Writes to a file.
     *
     * @param  file     The list to write in a file.
     * @param  fileName The name of the file for writing.
     */
    public void writeFile(List<String> file, String fileName)
    {        
        String filePath = createFilePath(fileName);

        try {

            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(filePath);

            // wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Write every string in the list file in a new line
            for(String line : file)
            {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            // close file.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    /**
     * Load the tasks string file into a list of strings.
     * 
     * @return  The list of tasks.
     */
    public List<String> loadTasks()
    {        
        //String tasksFN = findTaskFile();
        return readFile(findTaskFile());
    }
    
    /**
     * Load the vehicle string file into a list of lists of strings.
     * 
     * @return  vehicles The map of all vehicle lists
     */
    public Map<String,List<String>> loadVehicles()
    {        
        String[] listOfVehicles = findVehicleFiles();
        
        Map <String,List<String>> vehicles = new HashMap<>();
        for (int i = 0; i < listOfVehicles.length; i++) {
            List <String> vehicle = readFile(listOfVehicles[i]);    
            vehicles.put(listOfVehicles[i], vehicle);
            }
        return vehicles;
    }    
    
    /**
     * Save the tasks into a tasks .txt file.
     * 
     * @return  The list of tasks.
     */
    public void saveTasks(List<String> tasks)
    {        
        writeFile(tasks, this.tasksFileName);
    }
    
    
    /**
     * Save the vehicles in diferent vehicle .txt files.
     * 
     * @return  vehicles The map of all vehicle lists
     */
    public void saveVehicles(Map<String,List<String>> vehicles)
    {        
        
        for (String key : vehicles.keySet()) {
            writeFile(vehicles.get(key), key);
        }
        
    }    
}
