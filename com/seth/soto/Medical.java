package com.seth.soto;

public class Medical extends Major {

    public Medical() {
        super();
    }

    public void createMajor(int m) {
        setCreditsRequired(m);
        setTrack("Medical AA");
    }

    public String flex() {
        return "I save lives";
    }
}
