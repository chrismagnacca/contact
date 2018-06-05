package com.cgs.contact.models;

import com.cgs.contact.models.types.NeighborhoodProperties;
import com.cgs.contact.models.types.NeighborhoodPropertiesType;
import com.vividsolutions.jts.geom.MultiPolygon;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "neighborhoods")
@TypeDef(name = "NeighborhoodPropertiesType", typeClass = NeighborhoodPropertiesType.class)
public class Neighborhood {

    @Id
    @Type(type = "pg-uuid")
    private UUID uuid;

    @Column(name = "properties")
    @Type(type = "NeighborhoodPropertiesType")
    private NeighborhoodProperties properties;

    @Column(name = "geom", columnDefinition = "Geometry")
    private MultiPolygon geometry;

    public Neighborhood() {
        // empty Constructor, per JPA specification
    }

    public Neighborhood(UUID uuid, NeighborhoodProperties properties, MultiPolygon geometry) {
        this.uuid = uuid;
        this.properties = properties;
        this.geometry = geometry;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID id) {
        this.uuid = uuid;
    }

    public NeighborhoodProperties getProperties() {
        return properties;
    }

    public void setNeighborhoodProperties(NeighborhoodProperties name) {
        this.properties = properties;
    }

    public MultiPolygon getGeometry() {
        return geometry;
    }

    public void setGeometry(MultiPolygon geometry) {
        this.geometry = geometry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighborhood that = (Neighborhood) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(geometry, that.geometry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, properties, geometry);
    }

    @Override
    public String toString() {
        return "Neighborhood{" +
                "uuid=" + uuid +
                ", properties='" + properties+ '\'' +
                ", geometry=" + geometry +
                '}';
    }
}
