package Maxi.org.resolver;

import Maxi.org.models.Book;
import Maxi.org.models.BookInput;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class BookManipulationResolver implements GraphQLMutationResolver {

    public Book create(final BookInput bookI){return null;}

    public Book update(final BookInput bookI){return null;}
    public Boolean delete(final String ISBN){return null;}
}
