package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Quotes {

    private StringProperty quote;
    private StringProperty author;

    public Quotes(String quote, String author) {
        this.quote = new SimpleStringProperty(quote);
        this.author = new SimpleStringProperty(author);
    }

    public String getQuote() {
        return quote.get();
    }

    public StringProperty quoteProperty() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote.set(quote);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }
}
