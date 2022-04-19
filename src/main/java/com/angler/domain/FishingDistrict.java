package com.angler.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "district")
public class FishingDistrict extends AbstractEntity {

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "fish_district_relation",joinColumns = {@JoinColumn(name = "district_id")},
            inverseJoinColumns = {@JoinColumn(name = "fish_id")})
    private Set<Fish> fishSet = new HashSet<>();

    public FishingDistrict() {
    }

    public void addFish(Fish fish){
        this.fishSet.add(fish);
    }

    public FishingDistrict(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Fish> getFishSet() {
        return fishSet;
    }

    public void setFishSet(Set<Fish> fishSet) {
        this.fishSet = fishSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishingDistrict)) return false;
        if (!super.equals(o)) return false;
        FishingDistrict that = (FishingDistrict) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(fishSet, that.fishSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, fishSet);
    }

    @Override
    public String toString() {
        return "FishingDistrict{" +
                "name='" + name + '\'' +
                ", fishSet=" + fishSet +
                '}';
    }
}
