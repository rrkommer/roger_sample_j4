package com.artefaktur.sample.j4.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.artefaktur.sample.j4.em.Emfac;
import com.artefaktur.sample.j4.entities.Book;
import com.artefaktur.sample.j4.entities.Genre;

@Path("/books")
public class BookController
{
  static Emfac emfac = Emfac.getEmfac();

  @GET
  public Response index()
  {
    return Response.ok().build();
  }

  @GET
  @Path("/books")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Book> books()
  {
    return emfac.tx().go(em -> {
      List<Book> books = em.createQuery("select e from Book e", Book.class).getResultList();
      if (books.isEmpty() == true) {
        Genre g = new Genre("Krimi");
        em.persist(g);
        em.flush();
        Book b = new Book("1234123123", "Ein Book", null);
        b.setGenre(g);
        em.persist(b);
        em.flush();
      }
      books = em.createQuery("select e from Book e", Book.class).getResultList();
      return books;
    });
  }

}