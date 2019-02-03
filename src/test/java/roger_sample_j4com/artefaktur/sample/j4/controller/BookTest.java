package roger_sample_j4com.artefaktur.sample.j4.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.artefaktur.sample.j4.controller.BookController;
import com.artefaktur.sample.j4.entities.Book;


public class BookTest extends BaseTest
{
  @Test
  public void testBook()
  {
    BookController bc = new BookController();
    List<Book> listb = bc.books();
    Assert.assertTrue(listb.isEmpty() == false);
  }
}
