import java.util.Comparator;

/**
 * class Task.
 * Single Task used for storing
 * task information.
 * 
 * @author Aleksandar Dimeski
 * @version 2017/11/08
 */
public class Task
{
    // when this task is going to be activated
    private String taskDate;
    // to wich vehicle does this task addresses
    private VehicleData vehicle;
    // a description of the task
    private String taskDescription;

    /**
     * Constructor for objects of class Task
     */
    public Task(VehicleData vehicle, String taskDate, String taskDescription)
    {
        this.taskDate = taskDate;
        this.vehicle = vehicle;
        this.taskDescription = taskDescription;        
    }

    /**
     * Returns the activation date of this task.
     *
     * @return taskDate the date when to be reminded
     */
    public String getTaskDate()
    {
        return this.taskDate;
    }
    
    /**
     * Returns the vehicle data object.
     *
     * @return vehicle 
     */
    public VehicleData getVehicle()
    {
        return this.vehicle;
    }
    
    /**
     * Returns information about the vehicle that
     * this task is ment for.
     *
     * @return all vehicle data to string 
     */
    public String getVehicleDataToString()
    {
        return this.vehicle.toString();
    }
    
    /**
     * Returns the description of this task.
     * NOTE: This also be an empty field 
     * 
     * @return taskDescription
     */
    public String getTaskDescription()
    {
        return this.taskDescription;
    }
    
    /**
     * Returns string with all Task data
     * including information about the vehicle
     * delimited with ";"
     *
     * @return all data in a string
     */
    @ Override
    public String toString()
    {
        return String.join(";", getVehicleDataToString(),getTaskDate()
                            , getTaskDescription());
    }  
        
}
