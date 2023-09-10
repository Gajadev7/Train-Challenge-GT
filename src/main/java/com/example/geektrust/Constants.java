package com.example.geektrust;

import java.util.HashMap;
import java.util.Set;

import com.example.geektrust.BogieEnum.BogieName;

public class Constants {

    public final static HashMap<BogieName, Integer> TRAINA_BOGIE_DISTANCE_MAP = initTrainABogieDistanceMap();
    public final static HashMap<BogieName, Integer> TRAINB_BOGIE_DISTANCE_MAP = initTrainBBogieDistanceMap();


    private static HashMap<BogieName, Integer> initTrainABogieDistanceMap(){

        HashMap<BogieName, Integer> map = new HashMap<>();
        map.put(BogieName.ENGINE, Integer.MAX_VALUE);
        map.put(BogieName.CHN, 0);
        map.put(BogieName.SLM, 350);
        map.put(BogieName.BLR, 550);
        map.put(BogieName.PTA, 3800);
        map.put(BogieName.KRN, 900);
        map.put(BogieName.AGA, 2500);
        map.put(BogieName.HYB, 1200);
        map.put(BogieName.NGP, 1600);
        map.put(BogieName.NJP, 4200);
        map.put(BogieName.ITJ, 1900);
        map.put(BogieName.BPL, 2000);
        map.put(BogieName.NDL, 2700);
        map.put(BogieName.GHY, 4700);
        return map;
    }

    private static HashMap<BogieName, Integer> initTrainBBogieDistanceMap(){

        HashMap<BogieName, Integer> map = new HashMap<>();
        map.put(BogieName.ENGINE, Integer.MAX_VALUE);
        map.put(BogieName.TVC, 0);
        map.put(BogieName.SRR, 300);
        map.put(BogieName.MAQ, 600);
        map.put(BogieName.MAO, 1000);
        map.put(BogieName.PNE, 1400);
        map.put(BogieName.HYB, 2000);
        map.put(BogieName.NGP, 2400);
        map.put(BogieName.ITJ, 2700);
        map.put(BogieName.BPL, 2800);
        map.put(BogieName.AGA, 2500);
        map.put(BogieName.NDL, 2700);
        map.put(BogieName.PTA, 3800);
        map.put(BogieName.NJP, 4200);
        map.put(BogieName.GHY, 4700);

        return map;
    }


}
