package utils;

import data.SpaceMarine;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CollectionHandler {
    HashSet<SpaceMarine> marinesCollection =  new HashSet<>();
    private LocalDateTime initDateTime;
    private LocalDateTime saveDateTime;
    private FileManager fileManager;


    public CollectionHandler() {
        initDateTime = LocalDateTime.now();
    }

    public CollectionHandler(FileManager fileManager) {
        this.initDateTime = null;
        this.saveDateTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    public Boolean addSpaceMarine(SpaceMarine spaceMarine) {
        marinesCollection.add(spaceMarine);
        return true;
    }

    public String collectionType() {
        return marinesCollection.getClass().getName();
    }
    public int collectionSize() {
        return marinesCollection.size();
    }

    public Boolean removeSpaceMarine(SpaceMarine spaceMarine) {

        marinesCollection.remove(spaceMarine);
        return true;
    }

    public LocalDateTime getInitDateTime(){return initDateTime;}
    public LocalDateTime getLastSaveTime() {
        return saveDateTime;
    }
    public HashSet<SpaceMarine> getCollection(){return marinesCollection;}

    public void clear(){
        marinesCollection.clear();
    }

    public int generateNextId(){
        int nextId = 1;
        for(SpaceMarine spaceMarine : marinesCollection){
            if (spaceMarine.getId() >= nextId){
                nextId = spaceMarine.getId();
            }
        }
        return nextId+1;
    }
    public void saveCollection() {
        fileManager.writeFile(marinesCollection);
        saveDateTime = LocalDateTime.now();
    }

    public void loadCollection(){
        String name = new String("Имя_Файла");

        FileManager fileManager = new FileManager(name);
        marinesCollection = fileManager.readFromFile();
        initDateTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        if (marinesCollection.isEmpty()) return "Коллекция пуста!";

        String info = "";
        Iterator iterator = marinesCollection.iterator();
        while (iterator.hasNext()){
            info += iterator.next();
        }

        return info;
    }
}
