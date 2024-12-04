package Maxi.org;

import Maxi.org.models.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestClient {
    public static void main(String[] args) {
        TestClient client= new TestClient();
        try {
            List<Book> books= client.fetchBooks("titel  author {lastName firstName} iSBN publishedYear");
            for(Book book: books){
                System.out.println(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> fetchBooks(String personAttributes) throws URISyntaxException, IOException,InterruptedException {
        HttpClient client= HttpClient.newHttpClient();

        HttpRequest request= HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8084/lib"))
                .header("Content-Typer","application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{ \"query\": \"{ books { " + personAttributes + " } }\" }"))
                .build();

        HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);
        ObjectMapper oM= new ObjectMapper();
//        var result= oM.readValue(responseBody, new TypeReference<List<Book>>() {
//        });
//        return result;

        var result= oM.readValue(responseBody,new TypeReference<Map>(){});
        Map<String, Object> dataMap= (Map<String, Object>) result.get("data");
        List<LinkedHashMap> booksList= (List<LinkedHashMap>) dataMap.get("books");
        List<Book> BookList= new ArrayList<>();
        for(LinkedHashMap bookData: booksList){
            Book book= oM.convertValue(bookData, Book.class);
            BookList.add(book);
        }
        return BookList;
    }
}
