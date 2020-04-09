package com.seth.soto;

public abstract class Major implements Comparable<Major> {
    // instance variables - replace the example below with your own
    private int creditsRequired;
    private String track;

    public Major() {
        creditsRequired = 0;
        track = "none";
    }

    public abstract void createMajor(int p);

    public void setCreditsRequired(int c) {
        creditsRequired = c;
    }

    public int getCreditsRequired() {
        return creditsRequired;
    }

    public void setTrack(String t) {
        track = t;
    }

    public String getTrack() {
        return track;
    }

    public String toString() {
        return getTrack() + " Students Must Complete " + getCreditsRequired() + " credit hours.";
    }

    public int compareTo(Major obj) {
        if (creditsRequired < obj.creditsRequired)
            return -1;
        else if (creditsRequired == obj.creditsRequired)
            return 0;
        else
            return 1;
    }

}
