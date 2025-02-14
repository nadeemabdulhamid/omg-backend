import omg.interfaces.RequestCatalogHandler;
import omg.interfaces.RequestItemDataHandler;
import omg.server.OMGServer;

public class Main {
        public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-stage-1.json");

        server.installConstructor("print", Book.class, "id", "title", "author", "price", "tag");    // Book class and constructor need to be `public`
        Book book = server.fetchOneItemData();

        server.installHandler("catalog", (RequestCatalogHandler)() -> "[ 1 ]");
        server.installHandler("item-data", (RequestItemDataHandler)(i) -> book.toJSONString());
        server.start();
    }
}
