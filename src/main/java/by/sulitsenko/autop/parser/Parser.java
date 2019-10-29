package by.sulitsenko.autop.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public interface Parser<T> {
    T parse(Document document);

    default String getTextOrNull(Element element) {
        if (element != null) {
            return element.text().trim();
        }
        return null;
    }

    default Element getFirstElement(Elements elements) {
        if (elements != null && !elements.isEmpty()) {
            return elements.first();
        }
        return null;
    }

    default String getFirstElemTextOrNull(Elements elements) {
        return getTextOrNull(getFirstElement(elements));
    }
}
