package com.angler.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="fishDescription")
public class FishDescription extends AbstractEntity{

    @Column(name = "description",length = 1000)
    private String description;

    @OneToOne()
    @JoinColumn(name = "fish_id")
    private Fish fish;

    public FishDescription() {
    }

    public FishDescription(String description, Fish fish) {
        this.description = description;
        this.fish = fish;
    }

    public FishDescription(String fishDesctription) {
        this.description = fishDesctription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishDescription)) return false;
        if (!super.equals(o)) return false;
        FishDescription that = (FishDescription) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(fish, that.fish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, fish);
    }

    @Override
    public String toString() {
        return "FishDescription{" +
                "fishDesctription='" + description + '\'' +
                ", fish=" + fish.getName() +
                '}';
    }
}
