package com.angler.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "fishing_district")
public class FishingDistrict extends AbstractEntity{

    @Column(name = "name")
    private String name;


    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "logo_id")
    private Picture logo;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "district_fish",joinColumns = {@JoinColumn(name = "district_id")},
            inverseJoinColumns =@JoinColumn(name = "fish_id") )
    private Set<Fish> fish = new HashSet<>();

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
