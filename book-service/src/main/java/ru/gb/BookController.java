package ru.gb;

import com.gb.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("book/{id}")
    @Timer
    public Book getById(@PathVariable long id){
        return bookService.findBookById(id);
    }
}
