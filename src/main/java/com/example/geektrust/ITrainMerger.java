package com.example.geektrust;

import com.example.geektrust.BogieEnum.BogieName;
public interface ITrainMerger {

    void trainBogiesAtStation(BogieName bogieName);
    Train mergeTrainsAtStation(BogieName bogieName);
}
