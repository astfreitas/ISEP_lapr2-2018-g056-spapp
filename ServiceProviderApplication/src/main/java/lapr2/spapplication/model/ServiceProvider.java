package lapr2.spapplication.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class ServiceProvider {
    /**
     * System internal identification number of the Service Provider as String.
     * Generated by system.
     */
    private String number;
    /**
     * Name of the Service Provider.
     */
    private String name;
    /**
     * Abbreviated (short) name of the Service Provider.
     * Generated by system.
     */
    private String abbrevName;
    /**
     * Institutional email address account.
     * Generated by system.
     */
    private String email;
    /**
     * Address of the service provider. Intance of Address.
     */
    private Address spAddress;
    /**
     * List of Categories of service performed by the service provider.
     * Instance of SPCategoryList.
     */
//    private SPCategoryList spCatList;
//    /**
//     * List of Geographic Area where the service provider performs services.
//     * Instance of SPGeographicAreaList.
//     */
//    private SPGeographicAreaList spGeoAreaList;
//    /**
//     * Availability List of the Service Provider.
//     * Instance of AvailabilityList.
//     */
//    private SPAvailabilityList spAvailabilityList;
//    private ArrayList<Evaluation> evalList;
    private double averageRating;
    
    /**
     * Construtor for Service Provider receiving only the attributes name and 
     * and instance of Address by the method parameters.
     * Creates instances for SPCategoryList, SPGeographicAreaList and 
     * SPAvailabilityList.
     * 
     * @param name full name of the service provider
     * @param spAddress instance of Addres to register the service provider.
     */
    public ServiceProvider(String name, Address spAddress) {
        this.name = name;
        this.spAddress = spAddress;
//        spCatList = new SPCategoryList();
//        spGeoAreaList = new SPGeographicAreaList();
//        spAvailabilityList = new SPAvailabilityList();
//        this.evalList=new ArrayList<>();
    }

    //ToDo: do we need a construtor receiving the full name, and the fields for
    // a Address and create a new instance fo address in the construtor?
    
    /**
     * Returns the System internal identification number of the SP.
     * @return 
     */
    public String getNumber() {
        return number;
    }
    /**
     * Sets the System internal identification number of the SP.
     * @param number 
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * Returns the full name of the SP.
     * @return full name of the SP in String.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the full name of the SP.
     * @param name string with full name of SP
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the Abbreviated (short) name of SP.
     * @return abbreviated name
     */
    public String getAbbrevName() {
        return abbrevName;
    }
    /**
     * Sets the Abbreviated (short) name of SP.
     * @param abbrevName abbreviated (shor) name for SP
     */
    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }
    /**
     * Returns Institutional email address
     * @return email address of SP
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets Institutional email address for the Service Provider.
     * @param email email address SP
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Returns the reference for the Address instance of SP. 
     * @return reference for the Address instance of SP
     */
    public Address getSpAddress() {
        return spAddress;
    }
    /**
     * Sets the Address of SP with the reference received by spAddress
     * @param spAddress new reference for the Service Provider.
     */
    public void setSpAddress(Address spAddress) {
        this.spAddress = spAddress;
    }
//    /**
//     * Returns List of Geographic Areas where the SP performs services.
//     * @return List GeographicArea
//     */
//    public SPGeographicAreaList getSpGeoAreaList() {
//        return spGeoAreaList;
//    }
//    /**
//     * Returns List of categories of service performed by SP.
//     * @return SPCategoryregistry
//     */
//    public SPCategoryList getSpCatList() {
//        return spCatList;
//    }
//    /**
//     * Returns instance of SPAvailabilityList containing the list of SP.
//     * @return instance of SPAvailability.
//     */
//    public SPAvailabilityList getSpAvailabilityList() {
//        return spAvailabilityList;
//    }
//    
//    public List<Integer> getRatings() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public double getAverageRating() {
//        return averageRating;
//    }
//
//    public void setAverageRating(double average) {
//        this.averageRating = average;
//    }    

//    public void setClassification(String label) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    public void registerEvaluation(int rating, ServiceOrder servOrder){
//        Evaluation eval = new Evaluation(rating, servOrder);
//        evalList.add(eval);
//        recalculateAverage();
//    }
//    
//    public void recalculateAverage(){
//        double sum = 0;
//        for(Evaluation eval : evalList){
//            sum+=eval.getRating();
//        }
//        double average = sum / evalList.size();
//        this.setAverageRating(average);
//    }

//    boolean isAvailable(SchedulePreference schedule) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
////    boolean worksInGeographicArea(GeographicArea area) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//
//    boolean providesServicesOfCategory(Category category) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}