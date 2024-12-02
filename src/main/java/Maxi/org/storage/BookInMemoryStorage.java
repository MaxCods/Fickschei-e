package Maxi.org.storage;

import Maxi.org.models.Author;
import Maxi.org.models.Book;
import com.github.javafaker.Faker;

public class BookInMemoryStorage extends AbstractInMemoryStorage {

    private static BookInMemoryStorage INSTANCE;

    public static final BookInMemoryStorage getInstance(){
        if(INSTANCE==null){
            INSTANCE= new BookInMemoryStorage();
            return INSTANCE;
        }
        else return INSTANCE;
    }
    public void populateDatabase(){
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            Book book = new Book();
            book.setTitel(faker.book().title());
            Author a= new Author();
            a.setFirstName(faker.name().firstName());
            a.setLastName(faker.name().lastName());
            book.setAuthor(a);
            book.setISBN(faker.code().isbn10());
            book.setPublishedYear(faker.number().numberBetween(1900,2021));
            getInstance().create(book);
        }
    }
}
