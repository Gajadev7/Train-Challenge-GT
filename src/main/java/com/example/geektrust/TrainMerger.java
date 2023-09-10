package com.example.geektrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.BogieEnum.BogieName;
import com.example.geektrust.TrainEnum.TrainName;
import com.example.geektrust.BogieComparator;

public class TrainMerger implements ITrainMerger {

    private Train trainA;
    private Train trainB;

    private HashMap<BogieName, Integer> trainABogieDistanceMap;
    private HashMap<BogieName, Integer> trainBBogieDistanceMap;

    public TrainMerger(Train trainA, Train trainB){
        this.trainA = trainA;
        this.trainB = trainB;
        this.trainABogieDistanceMap = Constants.TRAINA_BOGIE_DISTANCE_MAP;
        this.trainBBogieDistanceMap = Constants.TRAINB_BOGIE_DISTANCE_MAP;
    }

    public void trainBogiesAtStation(BogieName bogieName){


        int currentStationDistanceA = trainABogieDistanceMap.get(bogieName);
        int currentStationDistanceB = trainBBogieDistanceMap.get(bogieName);

        trainA.setBogiesList(trainA.getBogiesList().stream().filter(bogie -> bogie.getDistanceFromSource() >= currentStationDistanceA ).collect(Collectors.toList()));
        trainB.setBogiesList(trainB.getBogiesList().stream().filter(bogie -> bogie.getDistanceFromSource() >= currentStationDistanceB ).collect(Collectors.toList()));

    }

    public Train mergeTrainsAtStation(BogieName bogieName){


        List<Bogie> mergedBogies = new ArrayList<>(trainA.getBogiesList());
        mergedBogies.addAll(trainB.getBogiesList());

        mergedBogies.removeIf(bogie -> bogie.getName().equals(bogieName));

        minDistanceCalculator(mergedBogies);

        Collections.sort(mergedBogies, new BogieComparator());
        return new Train(TrainName.TRAIN_AB, mergedBogies);

    }

    private void minDistanceCalculator(List<Bogie> mergedBogies){
        mergedBogies.forEach(bogie -> {
            if (trainABogieDistanceMap.containsKey(bogie.getName()) && trainBBogieDistanceMap.containsKey(bogie.getName())) {
                int minDistance = Math.min(trainABogieDistanceMap.get(bogie.getName()), trainBBogieDistanceMap.get(bogie.getName()));
                bogie.setDistanceFromSource(minDistance);
            }
        });
    }




}


