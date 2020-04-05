package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MyFaker {
    private ArrayList<String> carsModelList;
    private ArrayList<String> carsBrandList;
    private ArrayList<String> gangList;
    private ArrayList<String> raceList;

    public MyFaker() {
        File carsBrand = new File("C:\\Users\\dunco\\IdeaProjects\\fakeDataGen\\datasets\\auta_znacka.txt");
        this.carsBrandList = readUntilEnd(carsBrand);
        File carsModel = new File("C:\\Users\\dunco\\IdeaProjects\\fakeDataGen\\datasets\\auta_model.txt");
        this.carsModelList = readUntilEnd(carsModel);
        File gang = new File("C:\\Users\\dunco\\IdeaProjects\\fakeDataGen\\datasets\\gangs.txt");
        this.gangList = readUntilEnd(gang);
        File race = new File("C:\\Users\\dunco\\IdeaProjects\\fakeDataGen\\datasets\\race.txt");
        this.raceList = readUntilEnd(race);
    }

    public String carBrand(){
        Random rand = new Random();
        return carsBrandList.get(rand.nextInt(carsBrandList.size()));
    }

    public String carModel(){
        Random rand = new Random();
        return carsModelList.get(rand.nextInt(carsModelList.size()));
    }

    public String race(){
        Random rand = new Random();
        return raceList.get(rand.nextInt(raceList.size()));
    }

    public String gang(){
        Random rand = new Random();
        return gangList.get(rand.nextInt(gangList.size()));
    }




    private ArrayList<String> readUntilEnd(File file) {
        String st;
        ArrayList<String> result = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null)
                result.add(st);
            return result;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return result;
    }
}
