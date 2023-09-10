package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.TrainEnum.TrainName;

public class Train {
    TrainName trainName;
    List<Bogie> bogiesList = new ArrayList<>();

    public Train(TrainName trainName, List<Bogie> bogiesList){
        this.trainName = trainName;
        this.bogiesList = bogiesList;
    }

    public void setBogiesList(List<Bogie> bogiesList) {
        this.bogiesList = bogiesList;
    }

    public void setTrainName(TrainName trainName) {
        this.trainName = trainName;
    }

    public TrainName getTrainName() {
        return trainName;
    }

    public List<Bogie> getBogiesList() {
        return bogiesList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getTrainName());
        result.append(" ");

        for(Bogie bogie : this.getBogiesList()){
            result.append(bogie.getName());
            result.append(" ");

        }
        result.deleteCharAt(result.length()-1);

        return result.toString();

    }
}
