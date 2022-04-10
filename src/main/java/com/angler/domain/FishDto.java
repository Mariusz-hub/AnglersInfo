package com.angler.domain;

import java.time.LocalDate;
import java.util.Objects;

public class FishDto {

    private String name;
    private int protectionSize;
    private LocalDate periodOfProtectionFrom;
    private LocalDate periodOfProtectionTo;

    public FishDto() {
    }

    public FishDto(String name, int protectionSize, LocalDate periodOfProtectionFrom, LocalDate periodOfProtectionTo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishDto)) return false;
        FishDto fishDto = (FishDto) o;
        return protectionSize == fishDto.protectionSize &&
                Objects.equals(name, fishDto.name) &&
                Objects.equals(periodOfProtectionFrom, fishDto.periodOfProtectionFrom) &&
                Objects.equals(periodOfProtectionTo, fishDto.periodOfProtectionTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, protectionSize, periodOfProtectionFrom, periodOfProtectionTo);
    }

    @Override
    public String toString() {
        return "FishDto{" +
                "name='" + name + '\'' +
                ", protectionSize=" + protectionSize +
                ", periodOfProtectionFrom=" + periodOfProtectionFrom +
                ", periodOfProtectionTo=" + periodOfProtectionTo +
                '}';
    }
}
