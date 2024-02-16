package example.reactor.core;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

import static example.reactor.core.Utils.await;

public class MonoTest {

    BookRepository bookRepository = new BookRepository();

    @Test
    void monoPublisherSubscriberTest() {

        // Publisher
        Mono<Book> publisher = Mono.fromSupplier( bookRepository::findOne );


        // Subscriber
        Consumer<Book> subscriber = System.out::println;
        publisher.subscribe( subscriber );

    }


}
