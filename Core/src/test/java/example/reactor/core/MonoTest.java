package example.reactor.core;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class MonoTest {

    BookRepository bookRepository = new BookRepository();

    @Test
    void monoPublisherSubscriberExample() {

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

    @Test
    void monoSubscriberExample() {

        Consumer<Integer>   onNext     = i -> System.out.println("Inside onNext " + i);
        Consumer<Throwable> onError    = exp -> System.out.println( "Inside onError: " + exp.getMessage() );
        Runnable            onComplete = () -> System.out.println("Inside onComplete");

        // Publisher
        Mono<Integer> publisher = Mono.just( 13 );

        // Subscriber
        publisher.subscribe( onNext, onError, onComplete);

    }

}
