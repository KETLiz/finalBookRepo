package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final  BookRepository bookRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void createBookDatabase() {
        bookRepository.save(new Book("Война и мир"));
        bookRepository.save(new Book("Мастер и Маргарита"));
        bookRepository.save(new Book("Приключения Буратино"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public void removeBookById(long id) {
        bookRepository.deleteById(id);
    }

    public String getBookNameById(long bookId) {
        return bookRepository.findById(bookId).orElseThrow().getName();
    }
}
