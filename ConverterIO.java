import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * class ConverterIO
 * It converts the data from file to objects
 * when we have to fill the application model.
 * And the oposite converts application data
 * for storing.
 * 
 * NOTE I MIGHT MAKE IT ABSTRACT!!!!!!!!!
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/13
 */
public class ConverterIO
{

    /**
     * Constructor for objects of class ConverterIO
     */
    public ConverterIO()
    {
        // initialise instance variables

    }

    /**
     * Transforms the applications task data
     * from the TaskRegistry for file saving
     *
     * @param  tasks     The task registry data
     * @return tasksList List that contains the data from
     *                   the task registry as strings delimited
     *                   with ";".
     */
    public List<String> tasksToFile(List<Task> tasks)
    {
        List<String> tasksList = new ArrayList<>();

        for(Task task : tasks) {
            tasksList.add(task.toString());
        }

        return tasksList;
    }

    /**
     * Transforms the file task data
     * from the saved file to TaskRegistry
     *
     * @param  tasksFile The task data from the saved file.
     * @param  tasks     The task registry to store the data
     *                   from the saved file.
     * 
     */
    public void fileToTasks(List<String> tasksFile, TaskRegistry tasks)
    {

        for(String task : tasksFile) {
            if(task.contains(";")){
                String[] splitTask = task.split(";");
                if(splitTask.length!=8){
                    throw new IllegalArgumentException(splitTask +
                        " - invalid format!");
                }
                else{
                    switch (splitTask[0]) {
                        case "CARLOAN" :
                        {
                            tasks.addTask(new Task ((new CarLoanData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        case "FUEL" :
                        {
                            tasks.addTask(new Task ((new FuelData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        case "ACCESORIE" :
                        {
                            tasks.addTask(new Task ((new AccesorieData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        case "REGISTRATION" :
                        {
                            tasks.addTask(new Task ((new RegistrationData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        case "INSURANCE" :
                        {
                            tasks.addTask(new Task ((new InsuranceData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        case "SERVICEREPAIR" :
                        {
                            tasks.addTask(new Task ((new ServiceRepairData(splitTask[1],
                                splitTask[2], splitTask[3], Double.parseDouble(splitTask[4]),
                                splitTask[5])), splitTask[6], splitTask[7]));
                        }
                        //DEFAULT SHOULD BE ABLE TO THROW EXEPTION!!!!!!!!!!!!
                    }
                    
                }
            }
            else{
                throw new IllegalArgumentException(task +
                    " - invalid format!");
            }

        }
    }

    /**
     * Transforms the applications vehicle data
     * from the VehicleRegistry for file saving
     *
     * @param  vehicles      The vehicle registry data
     * @return vehiclesList  Map of Lists that contains the data from
     *                       the vehicle registry as strings delimited
     *                       with ";".
     */
    public Map<String,List<String>> vehiclesToFiles(Map<String,List<VehicleData>> vehicles)
    {
        Map<String,List<String>> vehiclesList = new HashMap<>();

        for (String key : vehicles.keySet()) {
            List<VehicleData> vehicle = vehicles.get(key);
            List<String> vehicleToString = new ArrayList<>();

            for (VehicleData vehicleData : vehicle) {
                vehicleToString.add(vehicleData.toString());            
            }

            vehiclesList.put(key, vehicleToString);
        }

        return vehiclesList;
    }

    /**
     * Transforms the files of vehicles  data
     * from the saved file to VehicleRegistry
     *
     * @param  vehiclesFiles The vehicles data from the saved files.
     * @param  vehicles      The vehicle registry to store the data
     *                       from the saved files.
     * 
     */
    public void filesToVehicles(Map<String,List<String>> vehiclesFiles, VehicleDataRegistry vehicles)
    {

        for (String key : vehiclesFiles.keySet()) {
            List<String> vehicleFile = vehiclesFiles.get(key);
            List<VehicleData> vehicle = new ArrayList<>();
            
            for(String vehicleData : vehicleFile) {
                //List<VehicleData> vehicle = new ArrayList<>();
                if(vehicleData.contains(";")){
                    String[] splitVehicleData = vehicleData.split(";");
                    if(splitVehicleData.length!=6){
                        throw new IllegalArgumentException(splitVehicleData +
                            " - invalid format!");
                    }
                    else{
                        
                        if(splitVehicleData[0].equals("CARLOAN")){
                            vehicle.add(new CarLoanData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                        else if(splitVehicleData[0].equals("FUELDATA")){
                            vehicle.add(new FuelData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                        else if(splitVehicleData[0].equals("ACCESORIE")){
                            vehicle.add(new AccesorieData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                        else if(splitVehicleData[0].equals("REGISTRATION")){
                            vehicle.add(new RegistrationData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                        else if(splitVehicleData[0].equals("INSURANCE")){
                            vehicle.add(new InsuranceData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                        else if(splitVehicleData[0].equals("SERVICEREPAIR")){
                            vehicle.add(new ServiceRepairData (splitVehicleData[1],
                                                    splitVehicleData[2], splitVehicleData[3],
                                                    Double.parseDouble(splitVehicleData[4]),
                                                    splitVehicleData[5]));
                        }
                    }
                }
                else{
                    throw new IllegalArgumentException(vehicleData +
                        " - invalid format!");
                }
                
            }
            vehicles.addVehicle(key,vehicle);
        }
    }
}
