package com.sane.pkg.beans;

public class SeedTable {
    private String seedMoudle;

    private Long seedValue;

    private String seedLetter;

    public String getSeedMoudle() {
        return seedMoudle;
    }

    public void setSeedMoudle(String seedMoudle) {
        this.seedMoudle = seedMoudle == null ? null : seedMoudle.trim();
    }

    public Long getSeedValue() {
        return seedValue;
    }

    public void setSeedValue(Long seedValue) {
        this.seedValue = seedValue;
    }

    public String getSeedLetter() {
        return seedLetter;
    }

    public void setSeedLetter(String seedLetter) {
        this.seedLetter = seedLetter == null ? null : seedLetter.trim();
    }
}