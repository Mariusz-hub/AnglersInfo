package com.angler.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fishing_district")
public class FishingDistrict extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "logo_id")
    private Picture logo;

    public FishingDistrict(String name, Picture logo) {
        this.name = name;
        this.logo = logo;
    }

    public FishingDistrict() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getLogo() {
        return logo;
    }

    public void setLogo(Picture logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishingDistrict)) return false;
        if (!super.equals(o)) return false;
        FishingDistrict that = (FishingDistrict) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, logo);
    }

    @Override
    public String toString() {
        return "FishingDistrict{" +
                "name='" + name + '\'' +
                ", logo=" + logo +
                '}';
    }
}
