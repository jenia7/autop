package by.sulitsenko.autop.parser;

import by.sulitsenko.autop.entity.CarInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AvParser implements Parser<CarInfo> {
    private static final int PHONE_MIN_LENGTH = 4;

    @Override
    public CarInfo parse(Document document) {
        CarInfo carInfo = new CarInfo();
        Element carDetails = getFirstElement(document.getElementsByClass("card-details js-card-side"));
        if (carDetails != null) {
            carInfo.setMoneyBel(getFirstElemTextOrNull(carDetails.getElementsByClass("card-price-main-primary")));
            carInfo.setMoneyUsd(getFirstElemTextOrNull(carDetails.getElementsByClass("card-price-main-secondary")));
            Elements propElements = Optional.ofNullable(getFirstElement(carDetails.getElementsByClass("card-info"))).map(x -> x.getElementsByTag("dl")).orElse(null);
            if (propElements != null) {
                Map<String, String> propsMap = propElements.stream().collect(Collectors.toMap(x -> x.getElementsByTag("dt").first().text(), x -> x.getElementsByTag("dd").first().text()));
                carInfo.setCarDetails(propsMap);
            }
        }
        carInfo.setOwnerName(getFirstElemTextOrNull(document.getElementsByClass("card-contacts-name")));
        carInfo.setOwnerCity(getFirstElemTextOrNull(document.getElementsByClass("card-contacts-city")));

        Optional.ofNullable(document.getElementById("mobile-phone-button"))
                .map(x -> x.attr("href"))
                .filter(x -> x.length() > PHONE_MIN_LENGTH)
                .map(x -> x.substring(PHONE_MIN_LENGTH))
                .ifPresent(carInfo::setPhone);

        return carInfo;
    }
}
