package com.telusko.SpringRestXmlJson.model;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "user") // Defines the top-level XML tag
public class User {
    
    private String firstName;
    private String email;

    // Standard no-args constructor (Required for XML)
    public User() {}

    @XmlElement(name = "first_name") // Changes <firstName> to <first_name>
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}