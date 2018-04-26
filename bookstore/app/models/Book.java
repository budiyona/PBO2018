package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.*;

@Entity
public class Book extends Model {
	@Id
	public Integer id;
	public Integer price;
	public String title;
	public String author;
	

	public static Finder<Integer, Book> find = new Finder<Integer, Book>(Integer.class,Book.class);

}
  