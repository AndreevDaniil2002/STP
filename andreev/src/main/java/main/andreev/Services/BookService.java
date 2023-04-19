package main.andreev.Services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.andreev.models.BookModel;
import main.andreev.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

@RequiredArgsConstructor
//@Slf4j //логирование
public class BookService {
    private final BookRepository bookRepository;

    public List<BookModel> ListBooks(String name){
        List<BookModel> books = bookRepository.findAll();
        if (name != null) return bookRepository.findBookModelByBookName(name);
        return books;
    }

    public int numberofBooks(){
        return bookRepository.countAllByBookIdIsGreaterThan(-1L);
    }
    public void saveBook(BookModel bookModel){
        bookRepository.save(bookModel);
    }

    public void deleteBook(Long Id){
        bookRepository.deleteById(Id);
    }

    public BookModel getbookById(Long Id) {
        return bookRepository.findById(Id).orElse(null);
    }
}
