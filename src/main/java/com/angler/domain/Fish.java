package com.angler.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "fish")
public class Fish extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int protectionSize;

    @Column(nullable = false)
    private LocalDate periodOfProtectionFrom;

    @Column(nullable = false)
    private LocalDate periodOfProtectionTo;


    @OneToMany(mappedBy = "fish", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Picture> fishPicture = new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "fish_descriptions_id")
    private FishDescription description;

    @ManyToMany()
    @JoinTable(name = "fish_district_relation",joinColumns = {@JoinColumn(name = "fish_id")},
                                     inverseJoinColumns = {@JoinColumn(name = "district_id")})
    private Set<FishingDistrict> fishingDistricts = new HashSet<>();


    public Fish() {
    }

    public Fish(String name, int protectionSize, LocalDate periodOfProtectionFrom, LocalDate periodOfProtectionTo, FishDescription description) {
        this.name = name;
        this.protectionSize = protectionSize;
        this.periodOfProtectionFrom = periodOfProtectionFrom;
        this.periodOfProtectionTo = periodOfProtectionTo;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProtectionSize() {
        return protectionSize;
    }

    public void setProtectionSize(int protectionSize) {
        this.protectionSize = protectionSize;
    }

    public LocalDate getPeriodOfProtectionFrom() {
        return periodOfProtectionFrom;
    }

    public void setPeriodOfProtectionFrom(LocalDate periodOfProtectionFrom) {
        this.periodOfProtectionFrom = periodOfProtectionFrom;
    }

    public LocalDate getPeriodOfProtectionTo() {
        return periodOfProtectionTo;
    }

    public void setPeriodOfProtectionTo(LocalDate periodOfProtectionTo) {
        this.periodOfProtectionTo = periodOfProtectionTo;
    }

    public List<Picture> getFishPicture() {
        return fishPicture;
    }

    public void setFishPicture(List<Picture> fishPicture) {
        this.fishPicture = fishPicture;
    }

    public FishDescription getDescription() {
        return description;
    }

    public void setDescription(FishDescription description) {
        this.description = description;
    }

    public Set<FishingDistrict> getFishingDistricts() {
        return fishingDistricts;
    }

    public void setFishingDistricts(Set<FishingDistrict> fishingDistricts) {
        this.fishingDistricts = fishingDistricts;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", protectionSize=" + protectionSize +
                ", periodOfProtectionFrom=" + periodOfProtectionFrom +
                ", periodOfProtectionTo=" + periodOfProtectionTo +
                ", fishPicture=" + fishPicture +
                ", description=" + description +
                ", fishingDistricts=" + fishingDistricts +
                '}';
    }
}