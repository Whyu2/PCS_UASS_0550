package com.example.UAS_PCS_0550;

public class Favorite {

    public String getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(String idMatch) {
        this.idMatch = idMatch;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    private String idMatch;
    private String match;

    public String getHomescore() {
        return homescore;
    }

    public void setHomescore(String homescore) {
        this.homescore = homescore;
    }

    public String getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(String awayscore) {
        this.awayscore = awayscore;
    }

    private String homescore;

    public Favorite(String idMatch, String match, String homescore, String awayscore) {
        this.idMatch = idMatch;
        this.match = match;
        this.homescore = homescore;
        this.awayscore = awayscore;
    }

    private String awayscore;



}
