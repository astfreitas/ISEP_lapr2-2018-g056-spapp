package lapr.project.spa.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class ServiceOrder {
    private final String name;
    private final String email;
    private final LocalDate schedPrefDay;
    private final LocalTime schePrefTime;
    private final String category;
    private final String service;
    
    /**
     * Constructor ServiceOrder C
     * @param name name of the client
     * @param email email of the client
     * @param schedPrefDay date preference
     * @param schePrefTime time preference
     * @param category service category
     * @param service service
     */
    public ServiceOrder(String name, String email, String schedPrefDay, String schePrefTime, String category, String service) {
        this.name = name;
        this.email = email;
        this.schedPrefDay = LocalDate.parse(schedPrefDay);
        this.schePrefTime = LocalTime.parse(schePrefTime);
        this.category = category;
        this.service = service;
    }
    
    /**
     * Method hasEmail returns true if the ServiceOrder was registered with the same email.
     * @param email
     * @return true if it has the same email.
     */
    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    /**
     * Method returns the client name
     * @return client name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method returns the email of the client
     * @return email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method returns  the day when the service occurs.
     * @return instance of LocalDate when then date occurs.
     */
    public LocalDate getSchedPrefDay() {
        return schedPrefDay;
    }
    
    /**
     * Method returns the time when the service occurs.
     * @return instance of LocalTime when then date occurs.
     */
    public LocalTime getSchePrefTime() {
        return schePrefTime;
    }

    /**
     * Method returns the order's category
     * @return instance of the order's category
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Method returns the service that was executed.
     * @return returns the service that was executed.
     */
    public String getService() {
        return service;
    }
    
}