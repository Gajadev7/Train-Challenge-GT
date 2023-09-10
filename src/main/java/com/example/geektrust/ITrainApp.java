package com.example.geektrust;

import java.util.List;

public interface ITrainApp {
    Train parseAndProcessInput(String line);
    Train processTrainList(String trainList);
    List<Bogie> parseBogieList(String[] bogies, TrainEnum.TrainName trainName);
    void validateTrainList(Train trainA, Train trainB);
}
