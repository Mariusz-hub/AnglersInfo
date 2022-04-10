package com.angler.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "fish_picture")
public class Picture extends AbstractEntity {

    @Column(name = "url")
    private String url;

    @Lob
    @Column(name = "picture", columnDefinition = "BYTEA")
    private byte[] picture;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "fish_id")
    private Fish fish;

    @OneToOne(mappedBy = "logo",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private FishingDistrict fishingDistrict;

    public Picture() {
    }

    public Picture(byte[] picture, Fish fish) {
        this.picture = picture;
        this.fish = fish;
    }

    public Picture(String url, byte[] picture, Fish fish, FishingDistrict fishingDistrict) {
        this.url = url;
        this.picture = picture;
        this.fish = fish;
        this.fishingDistrict = fishingDistrict;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FishingDistrict getFishingDistrict() {
        return fishingDistrict;
    }

    public void setFishingDistrict(FishingDistrict fishingDistrict) {
        this.fishingDistrict = fishingDistrict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;
        if (!super.equals(o)) return false;
        Picture picture1 = (Picture) o;
        return Objects.equals(url, picture1.url) &&
                Arrays.equals(picture, picture1.picture) &&
                Objects.equals(fish, picture1.fish) &&
                Objects.equals(fishingDistrict, picture1.fishingDistrict);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), url, fish, fishingDistrict);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "url='" + url + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", fish=" + fish +
                ", fishingDistrict=" + fishingDistrict +
                '}';
    }
}
