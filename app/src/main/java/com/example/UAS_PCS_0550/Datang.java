package com.example.UAS_PCS_0550;

public class Datang {

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

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


    public Datang(String match, String date, String homescore, String awayscore, String liga, String season, String jam, String tuan , String stadion, String gambar, String idmatch,String fullname) {
        this.match = match;
        this.date = date;
        this.homescore = homescore;
        this.awayscore = awayscore;
        this.liga = liga;
        this.season = season;
        this.jam = jam;
        this.tuan = tuan;
        this.stadion = stadion;
        this.gambar = gambar;
        this.idmatch = idmatch;
        this.fullname = fullname;

    }
    private String match;
    private String date;
    private String homescore;
    private String awayscore;
    private String liga;
    private String season;
    private String jam;
    private String tuan;
    private String stadion;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    private String fullname;

    public String getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(String idmatch) {
        this.idmatch = idmatch;
    }

    private String idmatch;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    private String gambar;

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public String getTuan() {
        return tuan;
    }

    public void setTuan(String tuan) {
        this.tuan = tuan;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
