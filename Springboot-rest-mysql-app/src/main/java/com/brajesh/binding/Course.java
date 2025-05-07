package com.brajesh.binding;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "COURSE_LIST")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer cid;
    private String name;
    private Double price;

}
