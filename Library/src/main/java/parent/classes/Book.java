package parent.classes;

import enums.com.Kategories;

public class Book {
    int Id;
    String Name;
    String Author;
    int Izdanie;
    String Publisher;
    int Year;
    Kategories Kategory;

    public Book(int id, String name, String author, int izdanie, String publisher, int year, Kategories kategory){
        this.setId(id);
        this.setAuthor(author);
        this.setIzdanie(izdanie);
        this.setPublisher(publisher);
        this.setName(name);
        this.setYear(year);
        this.setKategory(kategory);
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String surname) {
        this.Author = surname;
    }

    public int getYear(){
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public int getIzdanie(){
        return Izdanie;
    }

    public void setIzdanie(int izdanie){
        this.Izdanie = izdanie;
    }

    public String getPublisher(){
        return Publisher;
    }

    public void setPublisher(String publisher){
        this.Publisher = publisher;
    }

    public Kategories getKategory(){
        return Kategory;
    }

    public void setKategory(Kategories kategory){
        this.Kategory = kategory;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        this.Id = id;
    }


}
