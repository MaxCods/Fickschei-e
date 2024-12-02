package Maxi.org.resolver;

import Maxi.org.models.Book;
import Maxi.org.storage.BookInMemoryStorage;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class BookQueryResolver implements GraphQLQueryResolver {

//    public Book BookById(int Id){
//        System.out.println("BookById: " + Id);
//       return (Book) BookInMemoryStorage.getInstance().readById(Id).get();
//    }
public Book bookById(Long Id){
    System.out.println("BookById: " + Id);
    System.out.println("test");
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
}
