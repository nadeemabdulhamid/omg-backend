import omg.interfaces.RequestCatalogHandler;
import omg.interfaces.RequestItemDataHandler;
import omg.interfaces.RequestTagsHandler;
import omg.server.OMGServer;

public class Main {
        public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-stage-2.json");

        server.installConstructor("print", Book.class, "id", "title", "author-name", "author-yob", "sale-price", "list-price", "discount", "tag");
        Book b1 = (Book)server.fetchItemList().get(0);
        Book b2 = (Book)server.fetchItemList().get(1);
        Book b3 = (Book)server.fetchItemList().get(2);
        Store store = new Store(b1, b2, b3);

        server.installHandler("catalog",   (RequestCatalogHandler) store::catalog);
        server.installHandler("item-data", (RequestItemDataHandler) store::itemInfoAsJSON);
        server.installHandler("tags",      (RequestTagsHandler) store::tagCounts);
        server.start();
    }
}
