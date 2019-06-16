package lapr.project.spa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ServiceOrder implements Serializable {

    private final String name;
    private final String email;
    private final String schedPrefDayStr;
    private final LocalDate schedPrefDay;
    private final String schedPrefTimeStr;
    private final LocalTime schedPrefTime;
    private final String category;
    private final String service;

    /**
     * Constructor ServiceOrder
     *
     * @param name
     * @param email
     * @param schedPrefDayStr
     * @param schedPrefTimeStr
     * @param category
     * @param service
     */
    public ServiceOrder(String name, String email, String schedPrefDayStr, String schedPrefTimeStr, String category, String service) {
        this.name = name;
        this.email = email;
        this.schedPrefDayStr = schedPrefDayStr;
        this.schedPrefTimeStr = schedPrefTimeStr;
        this.schedPrefDay = LocalDate.parse(schedPrefDayStr);
        this.schedPrefTime = LocalTime.parse(schedPrefTimeStr);
        this.category = category;
        this.service = service;
    }

    /**
     * Method hasEmail returns true if the ServiceOrder was registered with the
     * same email.
     *
     * @param email
     * @return true if it has the same email.
     */
    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    /**
     * Method returns the client name
     *
     * @return client name
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns the email of the client
     *
     * @return email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method returns the day when the service occurs.
     *
     * @return instance of LocalDate when then date occurs.
     */
    public LocalDate getSchedPrefDay() {
        return schedPrefDay;
    }

    public String getSchedPrefDayStr() {
        return schedPrefDay.toString();
    }

    /**
     * Method returns the time when the service occurs.
     *
     * @return instance of LocalTime when then date occurs.
     */
    public LocalTime getSchePrefTime() {
        return schedPrefTime;
    }

    public String getSchePrefTimeStr() {
        return schedPrefDay.toString();
    }

    /**
     * Method returns the order's category
     *
     * @return instance of the order's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method returns the service that was executed.
     *
     * @return returns the service that was executed.
     */
    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" + "name=" + name + ", email=" + email + ", schedPrefDay=" + schedPrefDay + ", schedPrefTime=" + schedPrefTime + ", category=" + category + ", service=" + service + '}';
    }

    /**
     * Property propertyDayTime
     *
     * @return
     */
    public String getPropertyDayTime() {
        return schedPrefDayStr + " " + schedPrefTimeStr;
    }

    /**
     * Property propertyCategory
     *
     * @return
     */
    public String getPropertyCategory() {
        return category;
    }

    /**
     * Property propertyService
     *
     * @return
     */
    public String getPropertyService() {
        return service;
    }

    /**
     * Returns the property name by String
     *
     * @return property name by String
     */
    public String getPropertyName() {
        return name;
    }

    /**
     * Returns the property email by String
     *
     * @return property name by String
     */
    public String getPropertyEmail() {
        return email;
    }

    @Override
    public boolean equals(Object otherServiceOrder) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherServiceOrder) {
            return true;
        }
        // null check
        if (otherServiceOrder == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherServiceOrder.getClass()) {
            return false;
        }
        // field comparison
        ServiceOrder so = (ServiceOrder) otherServiceOrder;
        return (Objects.equals(name, so.name)
                || Objects.equals(email, so.email)
                || Objects.equals(schedPrefDayStr, so.schedPrefDayStr)
                || Objects.equals(schedPrefTimeStr, so.schedPrefTimeStr)
                || Objects.equals(category, so.category)
                || Objects.equals(service, so.service));
    }

}
