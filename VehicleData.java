
/**
 * class VehicleData
 * Basic model of Vehicle containig just the 
 * primary atributes.
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/06
 */
public abstract class VehicleData {
    // registration number
    protected String regNo;
    // manufacturer of the vehicle
    protected String manufacturer;
    // model of the vehicle
    protected String model;
    // price and date of payment
    protected double price;
    protected String paymentDate;
   
    
    /**
     * Creates a Vehicle data
     */
    public VehicleData(String regNo, String manufacturer, String model
                       , double price, String paymentDate)
    {
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.paymentDate = paymentDate;
    }
    
    // /**
     // * Creates a Vehicle data from Vehicle data
     // */
    
    // public abstract VehicleData (VehicleData vehicle);
    // {
        // this.regNo = vehicle.getRegNo();
        // this.manufacturer = vehicle.getManufacturer();
        // this.model = vehicle.getModel();
    // }
        
    /**
     * Returns the registration number
     *
     * @return regNo the registration number
     */
    public String getRegNo()
    {
        return this.regNo;
    }
    
    /**
     * Returns the vehicle manufacturer
     *
     * @return manufacturer the vehicle manufacturer
     */
    public String getManufacturer()
    {
        return this.manufacturer;
    }
    
    /**
     * Returns the vehicle model
     *
     * @return model the vehicle model
     */
    public String getModel()
    {
        return this.model;
    }
    
    /**
     * Returns string with all vehicle data
     * delimited with ";"
     *
     * @return all data in a string
     */
    public abstract String toString();
    // {
        // return String.join(";", getRegNo(), getManufacturer(), getModel());
    // }
    
     /**
     * Returns the price of the payment
     *
     * @return price the price of the payment
     */
    public abstract double getPrice(); 
    // {
        // return this.price;
    // }
    
    /**
     * Returns the date of payment
     *
     * @return paymentDate the date of payment
     */
    public abstract String getPaymentDate(); 
    // {
        // return this.paymentDate;
    // }
    
    /**
     * Returns the date of payment
     *
     * @return paymentDate the date of payment
     */
    public abstract String getType();
}
