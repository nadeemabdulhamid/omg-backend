import omg.interfaces.*;
import omg.server.OMGServer;

public class Main {
        public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-stage-4.json");

        server.installConstructor("audio", Audio.class, "id", "title", "description", "artist", "duration", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
        server.installConstructor("print", Book.class, "id", "title", "description", "author-name", "author-yob", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
        server.installConstructor("video", Movie.class, "id", "title", "description", "starring", "directed-by", "sale-price", "list-price", "discount", "tags", "rating-average", "rating-count");
        ILoM items = server.fetchItemList(MTLoM::new, ConsLoM::new);
        Store store = new Store(items);

        server.installHandler("catalog",   (RequestCatalogHandler) store::catalog);
        server.installHandler("item-data", (RequestItemDataHandler) store::itemInfoAsJSON);
        server.installHandler("tags",      (RequestTagsWithLimitHandler) store::tagsList);
        server.start();
    }
}
