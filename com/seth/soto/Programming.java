package com.seth.soto;

public class Programming extends Major {

    public Programming() {
        super();
    }

    public void createMajor(int m) {
        setCreditsRequired(m);
        setTrack("Programming BAS");

    }

    public String plusICanCode() {
        return "But If you take these courses you can code like this!";
    }
}
