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

    @OneToOne(mappedBy = "fish")
    private FishDescription description;

    public Fish() {
    }

    public Fish(String name, int protectionSize, LocalDate periodOfProtectionFrom, LocalDate periodOfProtectionTo) {
        this.name = name;
        this.protectionSize = protectionSize;
        this.periodOfProtectionFrom = periodOfProtectionFrom;
        this.periodOfProtectionTo = periodOfProtectionTo;
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

    public FishDescription getDescription() {
        return description;
    }

    public void setDescription(FishDescription description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fish)) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return protectionSize == fish.protectionSize &&
                Objects.equals(name, fish.name) &&
                Objects.equals(periodOfProtectionFrom, fish.periodOfProtectionFrom) &&
                Objects.equals(periodOfProtectionTo, fish.periodOfProtectionTo) &&
                Objects.equals(description, fish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, protectionSize, periodOfProtectionFrom, periodOfProtectionTo, description);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", protectionSize=" + protectionSize +
                ", periodOfProtectionFrom=" + periodOfProtectionFrom +
                ", periodOfProtectionTo=" + periodOfProtectionTo +
                ", description=" + description +
                '}';
    }
}