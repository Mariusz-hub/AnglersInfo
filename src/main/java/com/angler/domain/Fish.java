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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fish_descriptions_id")
    private FishDescription description;

    @ManyToMany
    private Set<FishingDistrict> fishingDistricts = new HashSet<>();


    public Fish() {
    }

    public Fish(String name, int protectionSize, LocalDate periodOfProtectionFrom, LocalDate periodOfProtectionTo, List<Picture> fishPicture, FishDescription description) {
        this.name = name;
        this.protectionSize = protectionSize;
        this.periodOfProtectionFrom = periodOfProtectionFrom;
        this.periodOfProtectionTo = periodOfProtectionTo;
        this.fishPicture = fishPicture;
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