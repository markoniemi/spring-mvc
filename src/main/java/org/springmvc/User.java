package org.springmvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@NamedQuery(name="User.findAdmins",query="SELECT OBJECT(user) FROM User user WHERE user.role = 'admin'")
public class User {
    @GeneratedValue @Id
    private Long id;
    private String name;
    private String username;
    private String role;
    private String email;
}
