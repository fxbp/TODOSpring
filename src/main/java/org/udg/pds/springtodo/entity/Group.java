package org.udg.pds.springtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="groups")
public class Group {

    public Group(){

    }

    // This tells JAXB that this field can be used as ID
    // Since XmlID can only be used on Strings, we need to use LongAdapter to transform Long <-> String
    @Id
    // Don't forget to use the extra argument "strategy = GenerationType.IDENTITY" to get AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
}
