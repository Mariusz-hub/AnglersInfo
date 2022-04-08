package com.angler.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fish_picture")
public class Picture extends AbstractEntity {

    @Lob
    @Column(name = "picture", columnDefinition = "BYTEA")
    private byte[] picture;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "fish_id")
    private Fish fish;

    public Picture() {
    }

    public Picture(byte[] picture, Fish fish) {
        this.picture = picture;
        this.fish = fish;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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
        if (!(o instanceof Picture)) return false;
        if (!super.equals(o)) return false;
        Picture picture1 = (Picture) o;
        return Objects.equals(picture, picture1.picture) &&
                Objects.equals(fish, picture1.fish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), picture, fish);
    }

    @Override
    public String toString() {
        return "Picture{" +
                "fish=" + fish.getName() +
                '}';
    }
}
