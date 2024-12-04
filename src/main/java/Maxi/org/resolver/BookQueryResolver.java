package Maxi.org.resolver;

import Maxi.org.models.Book;
import Maxi.org.storage.BookInMemoryStorage;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class BookQueryResolver implements GraphQLQueryResolver {


public Book bookById(Long Id){

    try{
    return (Book) BookInMemoryStorage.getInstance()
            .readById(Id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + Id));}catch (Exception e){} catch (
            Throwable e) {
        throw new RuntimeException(e);
    }
    System.out.println("null");
    return null;
}
public List<Book> books(){
    return BookInMemoryStorage.getInstance().readByPredicate(p -> true);
}
}
