package com.example.SpringJPA3;

import com.example.SpringJPA3.Repositories.AuthorRepository;
import com.example.SpringJPA3.Repositories.BookRepository;
import com.example.SpringJPA3.entities.Address;
import com.example.SpringJPA3.entities.Author;
import com.example.SpringJPA3.entities.Book;
import com.example.SpringJPA3.entities.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RestfulWebServices2ApplicationTests {


	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAdd() {


		Author author = new Author();
		author.setName("John Luek");
		Address address = new Address();
		address.setStreet("Banaras");
		address.setStreetNumber(89);
		address.setLocation("JK Street");
		author.setAddress(address);
		List<Book> list = new ArrayList<Book>();
		author.setBooks(Arrays.asList(new Book("Physics"), new Book("English"), new Book("Maths")));
		authorRepository.save(author);


	}

	@Test
	public void testOnetoOneBook_Author() {
		Book book = new Book();
		book.setBookName("Physics scope");
		Author author = new Author();
		author.setName("Jahangir Bhabha");
		Address address = new Address();
		address.setStreetNumber(78);
		address.setLocation("London Colony");
		address.setStreet("London street");
		author.setAddress(address);
		book.setAuthor(author);
		bookRepository.save(book);
	}

	@Test
	public void testOneToManyUniDirectional() {

		Author author1 = new Author();
		author1.setName("Hira Mani");
		Address address = new Address();
		address.setStreetNumber(67);
		address.setLocation("Eiffel Tower");
		address.setStreet("Paris Street");
		author1.setAddress(address);
		List<Subject> list = Arrays.asList(new Subject("Physics"),
				new Subject("English"), new Subject("Chemistry"));
		author1.setSubjects(list);


		authorRepository.save(author1);

	}
}
