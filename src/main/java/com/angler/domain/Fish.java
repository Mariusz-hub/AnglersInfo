package com.angler.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fish")
public class Fish extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int protectionSize;

    @Column(nullable = false)
    private LocalDate periodOfProtection;

    @OneToMany(mappedBy = "fish",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Picture> fishPicture;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "fish_descriptions_id")
    private FishDescription description;

    public Fish() {
    }

    public Fish(String fishName, int protectionSize, LocalDate periodOfProtection) {
        this.name = fishName;
        this.protectionSize = protectionSize;
        this.periodOfProtection = periodOfProtection;
    }

    public List<Picture> getFishImage() {
        return fishPicture;
    }

    public void setFishImage(List<Picture> fishPicture) {
        this.fishPicture = fishPicture;
    }

    public FishDescription getDescription() {
        return description;
    }

    public void setDescription(FishDescription description) {
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

    public LocalDate getPeriodOfProtection() {
        return periodOfProtection;
    }

    public void setPeriodOfProtection(LocalDate periodOfProtection) {
        this.periodOfProtection = periodOfProtection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fish)) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return protectionSize == fish.protectionSize &&
                Objects.equals(name, fish.name) &&
                Objects.equals(periodOfProtection, fish.periodOfProtection) &&
                Objects.equals(fishPicture, fish.fishPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, protectionSize, periodOfProtection, fishPicture);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishName='" + name + '\'' +
                ", protectionSize=" + protectionSize +
                ", periodOfProtection=" + periodOfProtection +
                '}';
    }
}
