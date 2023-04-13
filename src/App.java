import utils.CollectionHandler;
import utils.FileManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String nameFile = "laboratoryWork";
            FileManager fileManager = new FileManager(nameFile);
            CollectionHandler collectionHandler = new CollectionHandler(fileManager);
        }
    }
}