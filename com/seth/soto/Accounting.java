package com.seth.soto;

public class Accounting extends Major {

    public Accounting() {
        super();
    }

    public void createMajor(int m) {
        setCreditsRequired(m);
        setTrack("Accounting AA");
    }

    public String crunchNumbers() {
        return "I can code in Excel and crunch numbers!";
    }
}
