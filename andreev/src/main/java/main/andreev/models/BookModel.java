package main.andreev.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Books")
@Table
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long bookId;

    @Column(name = "Name")
    private String bookName;

    @Column(name = "Publisher")
    private String bookPublisher;

    @Column(name = "DateStart")
    private String bookStartDate;

    @Column(name = "Student")
    private String StudentFIO;

    @Column(name = "DateEnd")
    private String bookEndDate;
}
