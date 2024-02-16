package example.reactor.core;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

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

    @Test
    void monoJustExample(){

        // Publisher
        Mono<Integer> publisher = Mono.just( 20);

        // Subscriber
        publisher.subscribe( this::printSquare );

    }

    public void printSquare(int i){ System.out.println( i*i ); }


}
