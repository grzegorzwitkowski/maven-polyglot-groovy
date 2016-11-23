package test;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "userId", "city", "street" })
public class Address {

    private String userId;
    private String city;
    private String street;

    public Address() {}

    public Address(String userId, String city, String street) {
        this.userId = userId;
        this.city = city;
        this.street = street;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }
}
