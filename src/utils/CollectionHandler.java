package utils;

import data.SpaceMarine;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CollectionHandler {
    HashSet<SpaceMarine> collection;
    private LocalDateTime initDateTime;
    private FileManager fileManager;

    public CollectionHandler() {
        collection = new HashSet<>();
        initDateTime = LocalDateTime.now();
    }

    public CollectionHandler(FileManager fileManager) {
        this.fileManager = fileManager;

        loadCollection();
    }

    public Boolean addSpaceMarine(SpaceMarine spaceMarine) {
        collection.add(spaceMarine);
        return true;
    }

    public Boolean removeSpaceMarine(SpaceMarine spaceMarine) {

        collection.remove(spaceMarine);
        return true;
    }

    public LocalDateTime getInitDateTime(){return initDateTime;}
    public HashSet<SpaceMarine> getCollection(){return collection;}

    public void clear(){
        collection.clear();
    }

    public int generateNextId(){
        int nextId = 1;
        for(SpaceMarine spaceMarine : collection){
            if (spaceMarine.getId() >= nextId){
                nextId = spaceMarine.getId();
            }
        }
        return nextId+1;
    }

    public void loadCollection(){
        String name = new String("Имя_Файла");

        FileManager fileManager = new FileManager(name);
        collection = fileManager.readFromFile();
     /* SpaceMarine[] spaceMarines;
        try {
            marinesCollection = fileManager.readFromFile();
            for (SpaceMarine spaceMarine : spaceMarines){
                addSpaceMarine(spaceMarine);
            }
        } catch (IOException e) {
            IOHandler.println("Ошибка при чтении файла"+e.getMessage());
        }*/
    }
}
