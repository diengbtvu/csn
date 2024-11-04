package com.javaweb.repository.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class representing an apartment.
 */
@Entity
@Table(name="apartment")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="min_rate")
    private Double minRate;

    @Column(name="floor_area")
    private Double floorArea;

    @Column(name="number_of_bedrooms")
    private Integer numberOfBedrooms;

    @Column(name="number_of_bathrooms")
    private Integer numberOfBathrooms;

    @Column(name="rented")
    private Boolean rented;

    @Column(name="move_in_date")
    private Date moveInDate;

    @Column(name="move_out_date")
    private Date moveOutDate;

    @ManyToOne
    @JoinColumn(name="building_id", nullable=false)
    private BuildingEntity building;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}