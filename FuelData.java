
/**
 * class FuelData
 * Stores data of a Fuel payment
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/06
 */
public class FuelData extends VehicleData
{
    // price and date of payment
    //private double price;
    //private String paymentDate;
    //private final String identifier;
    private final String type = "FUEL";
    /**
     * Constructor for objects of class FuelData
     */
    public FuelData(String regNo, String manufacturer, String model
                       , double price, String paymentDate)
    {
        super(regNo, manufacturer, model, price, paymentDate);
        //this.price = price;
        //this.paymentDate = paymentDate;
        //this.identifier = "FUEL";
    }
        
    /**
     * Returns the price of the payment
     *
     * @return price the price of the payment
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Returns the date of payment
     *
     * @return paymentDate the date of payment
     */
    public String getPaymentDate() {
        return this.paymentDate;
    }
    
    /**
     * Returns the type of payment
     *
     * @return paymentType the date of payment
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Returns string with all Fuel data
     * including information about the vehicle
     * delimited with ";"
     *
     * @return all data in a string
     */
    @ Override
    public String toString()
    {
        return String.join(";",getType(), getRegNo(), getManufacturer(), getModel()
                            , Double.toString(getPrice()), getPaymentDate());
    }
}
