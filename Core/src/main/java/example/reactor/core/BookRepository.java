package example.reactor.core;

import static example.reactor.core.Utils.await;

public class BookRepository {

    public Book findOne(){
        await( 2000 );
        return new Book(1L, "Reactory In Action");
    }
}
