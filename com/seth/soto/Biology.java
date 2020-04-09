package com.seth.soto;

public class Biology extends Major {

    public Biology() {
        super();
    }

    public void createMajor(int m) {
        setCreditsRequired(m);
        setTrack("Biology AA");
    }

    public String flex() {
        return "Cells are cool too you need them to live";
    }
}
