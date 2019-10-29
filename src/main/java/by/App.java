package by;

import by.sulitsenko.autop.entity.CarInfo;
import by.sulitsenko.autop.parser.AvParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String url = "https://cars.av.by/mercedes-benz/c-klass/16226389";
        Document document;
        try {
            document = Jsoup.connect(url).get();
            AvParser parser = new AvParser();
            CarInfo carInfo = parser.parse(document);
            System.out.println(carInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
