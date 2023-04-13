package utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import data.SpaceMarine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/*public class FileManager {
    private String filePath;
    public FileManager(){this.filePath = System.in.toString();}
}*/
public class FileManager {
    private Gson gson = new Gson();
    private String nameFile;

    public FileManager(String nameFile) {
        this.nameFile = nameFile;
    }

    public void writeFile(Collection<?> collection) {
        if (System.getenv().get(nameFile) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(nameFile)))) {
                collectionFileWriter.write(gson.toJson(collection));
                System.out.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                System.out.println("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else System.out.println("Системная переменная с загрузочным файлом не найдена!");
    }

    public HashSet<SpaceMarine> readFromFile() {
        if (System.getenv().get(nameFile) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(nameFile)))) {
                HashSet<SpaceMarine> collection;
                Type collectionType = new TypeToken<HashSet<SpaceMarine>>() {
                }.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                return collection;
            } catch (FileNotFoundException exception) {
                System.out.println("Не найден загрузочный экран!");
            } catch (NoSuchElementException exception) {
                System.out.println("Файл пуст!");
            } catch (JsonParseException | NullPointerException exception) {
                System.out.println("Не обнаружена необходимая коллекция!");
            } catch (IllegalStateException exception) {
                System.out.println("Непредусмотренная ошибка!");
                System.exit(0);
            }
        } else System.out.println("Системная переменная с загрузочным файлом не найдена!");
        return new HashSet<SpaceMarine>();
    }
}