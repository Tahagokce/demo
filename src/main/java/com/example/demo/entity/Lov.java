package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class Lov implements Serializable {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Lov lov;

    private String displayName;

    private String type;

    private boolean enabled;

    private String group;
}
