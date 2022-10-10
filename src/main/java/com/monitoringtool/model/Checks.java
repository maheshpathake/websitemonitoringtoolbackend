package com.monitoringtool.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="checks")
public class Checks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String websiteName;
    private String websiteUrl;
    private Float websiteFrequency;
}
