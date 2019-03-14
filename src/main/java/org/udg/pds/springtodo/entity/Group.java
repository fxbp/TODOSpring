package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;

@Entity(name="groups")
public class Group {

    public Group(){

    }

    public Group(String name, String description){
        this.name=name;
        this.description=description;
    }

    // This tells JAXB that this field can be used as ID
    // Since XmlID can only be used on Strings, we need to use LongAdapter to transform Long <-> String
    @Id
    // Don't forget to use the extra argument "strategy = GenerationType.IDENTITY" to get AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_owner")
    private User owner;

    public void setUser(User user) {
        this.owner=user;
    }

    @JsonView(Views.Private.class)
    public Long getId() {
        return id;
    }



    @JsonView(Views.Private.class)
    public String getName() {
        return name;
    }

    @JsonView(Views.Private.class)
    public String getDescription() {
        return description;
    }


}
