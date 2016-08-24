package com.compozed.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studios")
@Data
//@Getter
//@Setter
public class Studio {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Column (nullable = false)
    private  String name;

    @Temporal(TemporalType.DATE)
    private Date est;

    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name="updated_at", nullable = false)
    private Date updatedAt;

    public Studio() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Studio(int id) {
        this();
        this.id = id;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
