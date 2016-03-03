package org.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Data
@XmlRootElement
public class Address {
    @GeneratedValue
    @Id
    private Long id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
