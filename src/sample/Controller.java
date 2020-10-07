package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    @FXML
    private Label quote;
    @FXML
    private Label author;

    private ObservableList<Quotes> quotes;

    public void initialize() {
        quotes = FXCollections.observableArrayList();

        Path paths = FileSystems.getDefault().getPath("resources/quote.txt");
        try {
            File file = new File(paths.toAbsolutePath().toUri());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";;");
                System.out.println(Arrays.toString(data));
                String quote = data[0];
                String author = data[1];
                quotes.add(new Quotes(quote, author));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    @FXML
    public void generateQuote() {
        Random random = new Random();
        Quotes newQuote = quotes.get(random.nextInt(quotes.size()));
        quote.setText(newQuote.getQuote());
        author.setText(newQuote.getAuthor());
    }

    @FXML
    public void shareOnTwitter() {

    }

}
