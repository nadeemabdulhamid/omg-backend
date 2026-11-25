/**
* Nadeem Abdul Hamid, 2025.
*/

package test;

import media.Audio;
import media.Book;
import media.IMedia;
import media.Movie;
import omg.server.OMGServer;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        OMGServer server = new OMGServer("data/data-full.json");
        server.installConstructor("audio", Audio.class);
        server.installConstructor("print", Book.class);
        server.installConstructor("video", Movie.class);      
        List<IMedia> items = server.fetchItemList();

        /* progression of function objects to lambda expressions */
        class AudioMediaPrecicate implements Predicate<IMedia> {
            @Override
            public boolean test(IMedia item) {
                return item.getType().equals("audio");
            }
        }
        Predicate<IMedia> isAudio1 = new AudioMediaPrecicate();

        Predicate<IMedia> isAudio2 = new Predicate<IMedia>() {
            @Override
            public boolean test(IMedia item) {
                return item.getType().equals("audio");
            }
        };

        Predicate<IMedia> isAudio = item -> item.getType().equals("audio");

        line(40);
        System.out.println("Number of audio items: ");
        System.out.println(items.stream().filter(item -> item.getType().equals("audio")).count());

        line(40);
        System.out.println("Find item with id 4:");
        System.out.println(items.stream()
                .filter(item -> item.getId() == 4)
                .findFirst()
                .orElse(null));

        line(40);
        Optional<IMedia> hasTag = items.stream()
            .filter(item -> item.getTags().contains("classic"))
            .findAny();
        System.out.println("Is there any item with tag 'classic'? " + hasTag.isPresent());

        line(40);
        System.out.println("Discounted items:\n" +
         items.stream()
                .filter(IMedia::isOnSale)
                .map(IMedia::getTitle)
                .sorted()
                .collect(Collectors.joining("\n")));

        line(40);
        System.out.println("Top 5 most expensive items:");
        items.stream()
                .sorted(Comparator.comparingInt(IMedia::salePrice).reversed())
                .limit(5)
                .forEach(item -> System.out.println(item.getTitle() + ": $" + (item.salePrice()/100.0)));   

        line(40);
        double avgPrintRating = items.stream()
            .filter(item -> item.getType().equals("print"))
            .mapToDouble(IMedia::getRating)
            .average()
            .orElse(0.0);
        System.out.println("Average rating of print items: " + avgPrintRating);

        line(40);
        System.out.println("Unique tags across all items:");
        System.out.println(items.stream()
                .flatMap(item -> item.getTags().stream())
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));      
                
        line(40);
        System.out.println("Group items by type:");
        Map<String, List<IMedia>> itemsByType = items.stream()
            .collect(Collectors.groupingBy(IMedia::getType));
        itemsByType.forEach((type, itemList) -> {
            System.out.println(type + ": " + itemList.size() + " items");
        });
        
        line(40);
        System.out.println("Tags longer/shorter than 7 characters:");
        Map<Boolean, List<IMedia>> partitioned = items.stream()
                .collect(Collectors.partitioningBy(item -> item.getTags().stream().anyMatch(tag -> tag.length() > 7)));
        System.out.println("Items with all tags 7 characters or shorter: " + partitioned.get(false).size());
        System.out.println("Items with tags longer than 7 characters: " + partitioned.get(true).size());
    }

    private static void line(int chars) {
        System.out.println(Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return "=";
            }
        }).limit(chars).collect(Collectors.joining()));

    }
}