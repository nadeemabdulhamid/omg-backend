package main;
/**
* Nadeem Abdul Hamid, 2025.
*/

import omg.interfaces.*;
import omg.server.OMGServer;

import java.util.List;
import funcobjs.*;
import media.*;

public class Main {
    public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-full.json");

        server.installConstructor("audio", Audio.class, "id", "title", "description", "year", "artist", "duration", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
        server.installConstructor("print", Book.class, "id", "title", "description", "year", "author-name", "author-yob", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
        server.installConstructor("video", Movie.class, "id", "title", "description", "year", "starring", "directed-by", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
       
        List<IMedia> items = server.fetchItemList();
        Store store = new Store(items);

        server.installPredicate("types", (StringPredicateConstructor<IMedia>) TypesPredicate::new);
        server.installPredicate("search", (StringPredicateConstructor<IMedia>) TextSearchPredicate::new);
        server.installPredicate("min-year", (IntPredicateConstructor<IMedia>) MinYearPredicate::new);
        server.installPredicate("max-year", (IntPredicateConstructor<IMedia>) MaxYearPredicate::new);
        server.installPredicate("min-price", (IntPredicateConstructor<IMedia>) MinPricePredicate::new);
        server.installPredicate("max-price", (IntPredicateConstructor<IMedia>) MaxPricePredicate::new);

        server.installHandler("catalog",   (RequestCatalogWithFilterHandler) store::catalog);
        server.installHandler("item-data", (RequestItemDataHandler) store::itemInfoAsJSON);
        server.installHandler("tags",      (RequestTagsWithFilterHandler) store::tagCounts);
        server.installHandler("count", (RequestCountWithFilterHandler) store::countMatching);

        server.installHandler("year-range", (RequestRangeWithFilterHandler) store::yearRangeAsJSON);
        server.installHandler("price-range", (RequestRangeWithFilterHandler) store::priceRangeAsJSON);

        server.installHandler("cart-count", (RequestCatalogHandler) store::cartSize);
        server.installHandler("cart-list",  (RequestCatalogHandler) store::cartList);
        server.installHandler("cart-add",   (RequestItemDataHandler) store::addToCart);
        server.installHandler("cart-remove", (RequestItemDataHandler) store::removeFromCart);

        server.start();
    }
}
