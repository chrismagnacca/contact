package com.cgs.contact.jobs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.jersey.api.client.GenericType;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Event {
    public static final GenericType<List<Event>> LIST_TYPE = new GenericType<List<Event>>() {};

    final DateTime datetime;
    final String address;
    final Double longitude;
    final Double latitude;
    final String incidentNumber;
    final String type;

    @JsonCreator
    public Event(@JsonProperty("datetime") DateTime datetime,
                      @JsonProperty("address") String address,
                      @JsonProperty("longitude") Double longitude,
                      @JsonProperty("latitude") Double latitude,
                      @JsonProperty("incidentNumber") String incidentNumber,
                      @JsonProperty("type") String type) {
        this.datetime = datetime;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.incidentNumber = incidentNumber;
        this.type = type;
    }

    @JsonProperty("datetime")
    public DateTime getDatetime() {
        return datetime;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("incident_number")
    public String getIncidentNumber() {
        return incidentNumber;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        final Event that = (Event) o;
        return Objects.equals(datetime, that.datetime) &&
                Objects.equals(address, that.address) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(incidentNumber, that.incidentNumber) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, address, longitude, latitude, incidentNumber, type);
    }

    @Override
    public String toString() {
        return "Event{" +
                "datetime='" + datetime + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", incidentNumber='" + incidentNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
