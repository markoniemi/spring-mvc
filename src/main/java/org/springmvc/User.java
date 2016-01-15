package org.springmvc;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * User Data Transfer Object. User class would normally contain JPA annotations as well.
 * @Data annotation from Lombok adds getters and setter to User.
 * @XmlRootElement is required for REST/XML.
 */
@Data
@XmlRootElement
public class User {
    private Long id;
    private String name;
    private String email;
}
