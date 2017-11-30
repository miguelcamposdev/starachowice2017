package com.miguel.a01_footballfragmentlist;

/**
 * Created by miguelcampos on 29/11/17.
 */

public class FootballPlayerItem {
    private String name;
    private String team;
    private int goals;
    private String photo;
    private String logoTeam;


    public FootballPlayerItem(String name, String team, int goals, String photo, String logoTeam) {
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.photo = photo;
        this.logoTeam = logoTeam;
    }

    public String getLogoTeam() {
        return logoTeam;
    }

    public void setLogoTeam(String logoTeam) {
        this.logoTeam = logoTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
