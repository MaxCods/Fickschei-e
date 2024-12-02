package Maxi.org.resolver;

import Maxi.org.models.Book;
import Maxi.org.storage.BookInMemoryStorage;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class BookQueryResolver implements GraphQLQueryResolver {

    public Book BookById(int Id){
       return (Book) BookInMemoryStorage.getInstance().readById(Id).get();
    }
}
