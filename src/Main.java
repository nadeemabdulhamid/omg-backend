import omg.interfaces.RequestCatalogHandler;
import omg.interfaces.RequestItemDataHandler;
import omg.interfaces.RequestTagsHandler;
import omg.server.OMGServer;

public class Main {
        public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-stage-2.json");

        server.installConstructor("print", Book.class, "id", "title", "description", "author-name", "author-yob", "sale-price", "list-price", "discount", "tag", "rating-average", "rating-count");
        IMedia m1 = (IMedia)server.fetchItemList().get(0);
        IMedia m2 = (IMedia)server.fetchItemList().get(1);
        IMedia m3 = (IMedia)server.fetchItemList().get(2);
        Store store = new Store(m1, m2, m3);

        server.installHandler("catalog",   (RequestCatalogHandler) store::catalog);
        server.installHandler("item-data", (RequestItemDataHandler) store::itemInfoAsJSON);
        server.installHandler("tags",      (RequestTagsHandler) store::tagCounts);
        server.start();
    }
}
