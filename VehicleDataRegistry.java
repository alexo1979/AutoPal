import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.Collections;

/**
 * class VehicleDataRegistry
 * Storage place for all the payments by vehicle.
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/08
 */
public class VehicleDataRegistry
{
    // Map to keep all payment data for all vehicles
    private Map<String, List<VehicleData>> vehicles;
    //private List<VehicleData> vehiclesData;
    /**
     * Constructor for objects of class VehicleDataRegistry
     */
    public VehicleDataRegistry()
    {
        this.vehicles = new HashMap<>();
    }

    /**
     * Adding individual vehicle data in the registry
     *
     * @param vehicle the new vehicle data  
     */
    public void addVehicleData(VehicleData vehicleData)
    {
        boolean newEntenace = true;
        if(vehicles.keySet().size() > 0) {
            for (String key : vehicles.keySet()){
                if (key.equals(vehicleData.getRegNo())){
                    newEntenace = false;
                } 
            }
        }

        if(newEntenace) {
            List<VehicleData> vehicle = new ArrayList<>();
            vehicle.add(vehicleData);
            vehicles.put(vehicleData.getRegNo(), vehicle);
        }
        else {
            List<VehicleData> vehicle = vehicles.get(vehicleData.getRegNo());
            vehicle.add(vehicleData);
            vehicles.put(vehicleData.getRegNo(), vehicle);
        }

    }
    /**
     * Removes individual vehicle data in the registry
     * NOTE: I'll have to implement a chek if the actual task
     * is in the list.
     * 
     * @param  regNo Registration number of the vehicle.
     * @param  index The position of the data in the list.
     */
    public void deleteVehicleData(String regNo, int index)
    {
        List<VehicleData> vehicle = vehicles.get(regNo);
        vehicle.remove(index);
        vehicles.put(regNo, vehicle);
    }

    /**
     * Adding vehicle complete data
     *
     * @param regNo    registration number of vehicle
     * @param vehicle  list of all data of a vehicle
     */
    public void addVehicle(String regNo, List<VehicleData> vehicle)
    {
        vehicles.put(regNo, vehicle);
    }

    /**
     * Deleting complete vehicle complete data
     *
     * @param regNo    registration number of vehicle
     */
    public void deleteVehicle(String regNo)
    {
        vehicles.remove(regNo);
    }

    /**
     * Sorts all vehicles data by date in the same list
     * ////////////////////////////////////////////////////////////////
     */
    public void sortByDate(List<VehicleData> vehicle)
    {
        Collections.sort(vehicle, new Comparator<VehicleData>()
            {
                public int compare(VehicleData data1, VehicleData data2)
                {
                    return (int) data1.getPaymentDate().compareTo(data1.getPaymentDate());
                }
            });
    }

    /**
     * Used for passing the registry data in statistic methods
     *
     * @return regNo    registration number of vehicle
     */
    public Map<String, List<VehicleData>> getRegistryData()
    {
        return vehicles;
    }
}
