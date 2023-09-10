package com.example.geektrust;

import com.example.geektrust.BogieEnum.BogieName;


public class Bogie implements Comparable<Bogie> {

    BogieName name;
    int distanceFromSource;

    public Bogie(BogieName name, int distanceFromSource){
        this.name = name;
        this.distanceFromSource = distanceFromSource;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public void setName(BogieName name) {
        this.name = name;
    }

    public BogieName getName() {
        return name;
    }

    @Override
    public int compareTo(Bogie o) {
        return this.getDistanceFromSource() - o.getDistanceFromSource();
    }

}
