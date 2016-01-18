package org.springmvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * User Data Transfer Object. User class would normally contain JPA annotations as well.
 * @Data annotation from Lombok adds getters and setter to User.
 * @XmlRootElement is required for REST/XML.
 */
@Entity
@Data
@XmlRootElement
public class User {
    @GeneratedValue @Id
    private Long id;
    private String name;
    private String email;
}
