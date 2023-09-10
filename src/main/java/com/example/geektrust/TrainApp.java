package com.example.geektrust;

import com.example.geektrust.TrainEnum.TrainName;
import com.example.geektrust.BogieEnum.BogieName;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TrainApp implements ITrainApp{

    private Train trainA;
    private Train trainB;

    private ITrainMerger trainMerger;


    @Override
    public Train parseAndProcessInput(String line) {
        String[] trainsList = line.split("\\n+");

        trainA = processTrainList(trainsList[0]);
        trainB = processTrainList(trainsList[1]);

        validateTrainList(trainA, trainB);
        trainMerger = new TrainMerger(trainA, trainB);

        trainMerger.trainBogiesAtStation(BogieName.HYB);

        System.out.println("ARRIVAL "+ trainA.toString());
        System.out.println("ARRIVAL "+ trainB.toString());

        return trainMerger.mergeTrainsAtStation(BogieName.HYB);

    }

    public Train processTrainList(String trainList){
        String[] bogies = trainList.split("\\s+");

        TrainName trainName = parseTrainName(bogies[0]);
        List<Bogie> bogieList = parseBogieList(bogies, trainName);
        
        return new Train(trainName, bogieList);

    }

    private TrainName parseTrainName(String name){
        TrainName trainName;
        try{
            trainName = TrainName.valueOf(name);
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Please provide the valid train Name " + name);
        }
        
        return trainName;
    }
    public  List<Bogie> parseBogieList(String[] bogies, TrainName trainName){
        
        List<Bogie> bogieList = new ArrayList<>();
        for(int i=1; i<bogies.length; i++){
            
            try{
                BogieName bogieName = BogieName.valueOf(bogies[i]);
                bogieList.add(new Bogie(bogieName, getDistanceForTrainAndStation(trainName, bogieName)));
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Invalid bogie name given at index : "+i+" ");
            }
        }
        return bogieList;
    }

    private int getDistanceForTrainAndStation(TrainName trainName, BogieName bogieName){

        if(trainName.equals(TrainName.TRAIN_A) && Constants.TRAINA_BOGIE_DISTANCE_MAP.containsKey(bogieName)){
            return Constants.TRAINA_BOGIE_DISTANCE_MAP.get(bogieName);
        }
        else if(trainName.equals(TrainName.TRAIN_B) && Constants.TRAINB_BOGIE_DISTANCE_MAP.containsKey(bogieName)){
            return Constants.TRAINB_BOGIE_DISTANCE_MAP.get(bogieName);
        }
        else{
            throw new NoSuchElementException("Invalid bogie name given " + trainName +" " +bogieName);

        }
    }

    public void validateTrainList(Train trainA, Train trainB){

        if(!trainA.getTrainName().equals(TrainName.TRAIN_A)){
            Train temp = trainA;
            trainA = trainB;
            trainB = temp;
        }

    }
}
