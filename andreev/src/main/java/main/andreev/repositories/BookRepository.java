package main.andreev.repositories;

import main.andreev.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {

    List<BookModel> findBookModelByBookName(String Name);

    int countBookModelByBookEndDate(String endDate);

    int countAllByBookIdIsGreaterThan(Long bookId);

}
