package com.javaweb.repository.entity;

import javax.persistence.*;

/**
 * Entity class representing an apartment equipment.
 */
@Entity
@Table(name="apartment_equipment")
public class ApartmentEquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="apartment_id", nullable=false)
    private ApartmentEntity apartment;

    @ManyToOne
    @JoinColumn(name="equipment_id", nullable=false)
    private EquipmentEntity equipment;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApartmentEntity getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentEntity apartment) {
        this.apartment = apartment;
    }

    public EquipmentEntity getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEntity equipment) {
        this.equipment = equipment;
    }
}