package controllers;


import java.util.*;
import java.util.Set;

import models.Book;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;


public class BooksController extends Controller {
	
	//for All Books
	public static Result index() {
		List<Book> books=Book.find.all();
		return ok(views.html.buku.index.render(books));
	
	}
	
	//create books
	public static Result create() {
		Form<Book> bookForm = Form.form(Book.class);
		return ok(views.html.buku.form.render(bookForm));
		//return TODO;
	}
	
	
	//save book
	public static Result save() {
		Form<Book> bookForm = Form.form(Book.class).bindFromRequest();
		Book book= bookForm.get();
		book.save();
		return redirect(routes.BooksController.index());
		//return TODO;
	}
	
	public static Result edit(Integer id) {
		Book book=Book.find.byId(id);
		if(book==null) {
			return notFound("Book Not Found");
		}
		Form<Book> bookForm = Form.form(Book.class).fill(book);
		return ok(views.html.buku.edit.render(bookForm));
		
		
		//return TODO;
	}
	
	public static Result update() {
		Form<Book> bookForm = Form.form(Book.class).bindFromRequest();
		Book book=bookForm.get();
		Book oldBook = Book.find.byId(book.id);
		if(oldBook==null) {
			return notFound("Book Not Found");
		}
		oldBook.title=book.title;
		oldBook.author=book.author;
		oldBook.price=book.price;
		oldBook.update();
		
		return redirect(routes.BooksController.index());
		//return TODO;
	}
	
	public static Result destroy(Integer id) {
		Book book = Book.find.byId(id);
		if(book==null) {
			return notFound("Book Not Found");
		}
		book.delete();

		
		return redirect(routes.BooksController.index());
		//return TODO;
	}
	
	public static Result show(Integer id) {
		Book book = Book.find.byId(id);
		if(book==null) {
			return notFound("Book Not Found");
		}
		
		return ok(views.html.buku.show.render(book));
		
		//return TODO;
	}
	

}
