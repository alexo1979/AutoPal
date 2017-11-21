import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.text.ParseException;

/**
 * Write a description of class Manager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Manager extends Statistic
{
    // instance variables - replace the example below with your own
    private Reminder reminder;
    private TaskRegistry taskRegistry;
    private VehicleDataRegistry vehicleRegistry;
    private ComunicatorIO dataManager;
    private ConverterIO cio;
    /**
     * Constructor for objects of class Manager
     */
    public Manager()
    {
        
        this.taskRegistry = new TaskRegistry();
        this.vehicleRegistry = new VehicleDataRegistry();
        this.dataManager = new ComunicatorIO();
        this.cio = new ConverterIO();
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void addTask(String task)
    {
        // put your code here
        taskRegistry.addTask(cio.fileToTask(task));
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void addData(String vehicleData)
    {
        // put your code here
        vehicleRegistry.addVehicleData(cio.fileToVehicle(vehicleData));
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getAllTasks()
    {
        // put your code here
        return cio.tasksToFile(taskRegistry.getTasks());
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getTasksByDate(String startDate, String endDate)
    {
        // put your code here
        try {
        return cio.tasksToFile(findTaskByDate(startDate, endDate, taskRegistry.getTasks()));
        } catch (ParseException e) {
                e.printStackTrace();
            }

        return null;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getTasksByVehicle(String regNo)
    {
        // put your code here
        return cio.tasksToFile(findTaskByVehicle(regNo, taskRegistry.getTasks()));
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getDataByVehicle(String regNo)
    {
        // put your code here               
        return cio.vehicleToFile(findByVehicle(regNo, vehicleRegistry.getRegistryData()));
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getDataByDate(String regNo, String startDate, String endDate)
    {
        // put your code here
        try {
               return cio.vehicleToFile(findVehicleByDate(regNo, startDate, endDate,
                                                    vehicleRegistry.getRegistryData())); 
            } catch (ParseException e) {
                e.printStackTrace();
            }

        return null;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public List<String> getDataByType(String regNo, String type)
    {
        // put your code here
        return cio.vehicleToFile(findVehicleByDataType(regNo, type,
                                                        vehicleRegistry.getRegistryData()));
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void loadBase()
    {
        // put your code here
        cio.fileToTasks(dataManager.loadTasks(), taskRegistry);
        cio.filesToVehicles(dataManager.loadVehicles(), vehicleRegistry);
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void saveBase()
    {
        // put your code here
        dataManager.saveTasks(cio.tasksToFile(taskRegistry.getTasks()));
        dataManager.saveVehicles(cio.vehiclesToFiles(vehicleRegistry.getRegistryData()));
        
    }
}
