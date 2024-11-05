// BuildingAnalyticsDTO.java
package com.javaweb.dto;

public class BuildingAnalyticsDTO {
    private String name;
    private int totalApartments;

    public BuildingAnalyticsDTO(String name, int totalApartments) {
        this.name = name;
        this.totalApartments = totalApartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalApartments() {
        return totalApartments;
    }

    public void setTotalApartments(int totalApartments) {
        this.totalApartments = totalApartments;
    }
}