public abstract class AbsItem implements IMedia {
    int id;
    String title;
    String description;
    IPrice price;
    ILoS tags;
    Rating rating;

    public AbsItem(int id, String title, String description, IPrice price, ILoS tags, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
    }

}
