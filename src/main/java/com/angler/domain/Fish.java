package com.angler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "fish")
public class Fish extends AbstractEntity {

    @Column(nullable = false)
    private String fishName;
    @Column(nullable = false)
    private int protectionSize;
    @Column(nullable = false)
    private LocalDate periodOfProtection;

    public Fish() {
    }

    public Fish(String fishName, int protectionSize, LocalDate periodOfProtection) {
        this.fishName = fishName;
        this.protectionSize = protectionSize;
        this.periodOfProtection = periodOfProtection;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
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
                Objects.equals(fishName, fish.fishName) &&
                Objects.equals(periodOfProtection, fish.periodOfProtection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fishName, protectionSize, periodOfProtection);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishName='" + fishName + '\'' +
                ", protectionSize=" + protectionSize +
                ", periodOfProtection=" + periodOfProtection +
                '}';
    }
}