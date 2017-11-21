import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
/**
 * Abstract class Statistic
 * 
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/16
 */
public abstract class Statistic 
{
    // instance variables - replace the example below with your own
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static double calculate(List<VehicleData> vehicle)
    {
        double total = 0;
        
        for (VehicleData vehicleData : vehicle) {
            total += vehicleData.getPrice();
        }
        
        return total;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static List<VehicleData> findByVehicle(String regNo,
                                  Map<String, List<VehicleData>> vehicles)
    {
        return vehicles.get(regNo);
    }
        
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static List<VehicleData> findVehicleByDate(String regNo,
                              String startDate, String endDate,
                              Map<String, List<VehicleData>> vehicles)throws ParseException
    {
        List<VehicleData> vehicle = findByVehicle(regNo, vehicles);
        List<VehicleData> vehicleByDate = new ArrayList <>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dateStart = sdf.parse(startDate);
        Date dateEnd = sdf.parse(endDate);
        
        for (VehicleData vehicleData : vehicle){
            Date date = sdf.parse(vehicleData.getPaymentDate());
            
            if(date.compareTo(dateStart) >= 0 && date.compareTo(dateEnd) <= 0){
                vehicleByDate.add(vehicleData);
            }
        }
        // put your code here
        return vehicleByDate;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static List<VehicleData> findVehicleByDataType(String regNo,String type,
                                        Map<String, List<VehicleData>> vehicles)
    {
        List<VehicleData> vehicle = findByVehicle(regNo, vehicles);
        List<VehicleData> vehicleByType = new ArrayList <>();
        
        for (VehicleData vehicleData : vehicle){
            
            if(type.equals(vehicleData.getType())){
                vehicleByType.add(vehicleData);
            }
        }
        return vehicleByType;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static List<Task> findTaskByDate(String startDate, String endDate,
                              List<Task> tasks)throws ParseException
    {
        List<Task> tasksByDate = new ArrayList <>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dateStart = sdf.parse(startDate);
        Date dateEnd = sdf.parse(endDate);
        
        for (Task task : tasks){
            Date date = sdf.parse(task.getTaskDate());
            
            if(date.compareTo(dateStart) >= 0 && date.compareTo(dateEnd) <= 0){
                tasksByDate.add(task);
            }
        }
        // put your code here
        return tasksByDate;
    }
            
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static List<Task> findTaskByVehicle(String regNo,
                              List<Task> tasks)
    {
        List<Task> tasksByVehicle = new ArrayList <>();
                       
        for (Task task : tasks){
                        
            if(regNo.equals(task.getVehicle().getRegNo())) {
                tasksByVehicle.add(task);
            }
        }
        // put your code here
        return tasksByVehicle;
    }
}
