package main.andreev.controller;

import lombok.RequiredArgsConstructor;
import main.andreev.Services.BookService;
import main.andreev.models.BookModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final BookService bookservice;

    @GetMapping("/")
    public String books(@RequestParam(name = "Name", required = false) String Name, Model model){
        model.addAttribute("books", bookservice.ListBooks(Name));
        return "books";
    }

//    @RequestMapping
//            (value = "/"
//            ,method = RequestMethod.GET)
//    public String numberOfBooks(){
//        return String.valueOf(bookservice.numberofBooks());
//    }

    @GetMapping("/book/{id}")
    public String bookInfo(@PathVariable Long id, Model model){
        model.addAttribute("book", bookservice.getbookById(id));
        return "book-info";
    }
    @PostMapping("/book/create")
    public String createBook(BookModel bookModel){
        bookservice.saveBook(bookModel);
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookservice.deleteBook(id);
        return "redirect:/";
    }
}
