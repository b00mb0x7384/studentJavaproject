package com.seth.soto;

public class Welding extends Major {

    public Welding() {
        super();
    }

    public void createMajor(int m) {
        setCreditsRequired(m);
        setTrack("Welding AS");
    }

    public String flex() {
        return "Fab it up!";
    }
}
