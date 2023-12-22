package com.api.book.bootapibook.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootapibook.Entities.Book;
import com.api.book.bootapibook.Services.BookServices;

@RestController
public class BookController {

	 @Autowired
	    BookServices bookServices;

	   // @RequestMapping(value = "/books", method = RequestMethod.GET)
	   //     Or 
	    @GetMapping("/books")
	    // get all the books    
	    public ResponseEntity<List<Book>> getBooks()
	    {
	        //Book book = new Book();
	        //book.id(12345);
	        // book.setId(1234);
	        // book.setTitle("java");
	        // book.setAuthur("Arjun");
	    	List<Book> list = this.bookServices.getAllBook();
	    	if(list.size()<=0)
	    	{
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    	}
	        return  ResponseEntity.of(Optional.of(list));
	    }   
	    
	    // get a single book by id
	    @GetMapping("/books/{id}")
	    public ResponseEntity<Book> getsingleBook(@PathVariable("id") int id)
	    {
	    	Optional<Book> book = this.bookServices.getSingleBook(id);
	    	if(book == null)
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    	
	    	return ResponseEntity.of(book); 
	    }
	    
	    // Adding a Book
	    @PostMapping("/books")
	    public ResponseEntity<Book> addBook(@RequestBody Book book)
	    {
	    	try {
	    	Book b = this.bookServices.addBook(book);
	    	return ResponseEntity.of(Optional.of(b));
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    	}
	    }
	    
	    // Deleting a book
	    @DeleteMapping("/books/{bookId}")
	    public void DeleteBook(@PathVariable("bookId") int bookId)
	    {
	    	this.bookServices.deleteBook(bookId);
	    }
	    
	    // Update book handler
	    @PutMapping("/books/{bookId}")
	    public Book UpdateBook(@RequestBody Book book, @PathVariable("bookId") int bookId)
	    {
	    	this.bookServices.updateBook(book, bookId);
	    	return book;
	    }
}
