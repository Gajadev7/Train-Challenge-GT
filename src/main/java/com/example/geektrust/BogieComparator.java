package com.example.geektrust;

import java.util.Comparator;

public class BogieComparator implements Comparator<Bogie> {

    @Override
    public int compare(Bogie o1, Bogie o2) {

        return o2.getDistanceFromSource() - o1.getDistanceFromSource();

    }
}
