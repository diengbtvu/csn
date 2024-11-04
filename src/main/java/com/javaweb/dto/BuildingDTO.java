package com.javaweb.dto;

public class BuildingDTO {
    private Long id;
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Double totalArea;
    private String type;
    private String contactNumber;
    private Long districtId; // Add this field

    // Constructors
    public BuildingDTO() {}

    public BuildingDTO(Long id, String name, String address, Integer numberOfFloors, Double totalArea, String type, String contactNumber, Long districtId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.totalArea = totalArea;
        this.type = type;
        this.contactNumber = contactNumber;
        this.districtId = districtId; // Initialize this field
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
}