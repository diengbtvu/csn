package com.javaweb.repository.entity;

import javax.persistence.*;

/**
 * Entity class representing an equipment.
 */
@Entity
@Table(name="equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="status")
    private String status;

    @Column(name="broken_fee")
    private Double brokenFee;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBrokenFee() {
        return brokenFee;
    }

    public void setBrokenFee(Double brokenFee) {
        this.brokenFee = brokenFee;
    }
}