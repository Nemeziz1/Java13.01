package ru.netology.repository;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  ProductRepository repository = new ProductRepository();
  Book book = new Book(1, "detective", 600, "Agatha Christie", 250, 2018);

  @Test
  public void shouldRemoveById() {
    repository.save(book);
    repository.removeById(1);
    Product[] expected = new Product[]{};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotFound() {
    repository.save(book);
    repository.removeById(2);
    assertThrows(NotFoundException.class, () -> repository.throwNotFound());
  }
}
