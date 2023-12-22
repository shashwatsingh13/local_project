package com.api.book.bootapibook.Services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootapibook.Entities.Book;
import com.api.book.bootapibook.dao.BookRepository;
@Component
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

	// public static List<Book> list = new ArrayList<>();
	
	// static {
	// list.add(new Book(12345,"pyhton","Arjun"));
	// list.add(new Book(12346, "Java", "Shashank"));
	// list.add(new Book(12347,"C++", "Shivam"));
	// }
	 // get all books handler
    public List<Book> getAllBook()
    {
        // Type casting is done itrable to list
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }
    // get a single book handler
    
    public Optional<Book> getSingleBook(int id)
    {
        Optional<Book> book =null;
        try {
        //book = list.stream().filter(e->e.getId()==id).findFirst().get();
         book = this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return book;
    }
    // Save a book handler
    public Book addBook(Book book)
    {
    	//list.add(book);
        Book result = bookRepository.save(book);
    	System.out.println(result);
    	return result;
    }
    // delete a book handler
    public void deleteBook(int bid)
    {
        //list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
        
    }

    // Update a book Handler
    public void updateBook(Book book, int bid)
    {
    	// list = list.stream().map(b->{
    	// 	if(b.getId()==bid)
    	// 	{
    	// 		b.setAuthur(book.getAuthur());
    	// 		b.setTitle(book.getTitle());
    	// 	}
    	// 	return b;
    	// }).collect(Collectors.toList());

        book.setId(bid);
        bookRepository.save(book);
    }
}







