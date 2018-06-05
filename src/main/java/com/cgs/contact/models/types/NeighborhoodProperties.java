package com.cgs.contact.models.types;


import java.io.Serializable;

public class NeighborhoodProperties implements Serializable {
    private String city;
    private String name;
    private Double area;
    private String nested;
    private String county;
    private String nhood;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getNested() {
        return nested;
    }

    public void setNested(String nested) {
        this.nested = nested;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getNhood() {
        return nhood;
    }

    public void setNhood(String nhood) {
        this.nhood = nhood;
    }

    @Override
    public String toString() {
        return "NeighborhoodProperties{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", nested='" + nested + '\'' +
                ", county='" + county + '\'' +
                ", nhood='" + nhood + '\'' +
                '}';
    }
}
