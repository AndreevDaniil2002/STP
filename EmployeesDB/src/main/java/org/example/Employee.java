package org.example;

public class Employee {
    private int Id = 0;
    private static int counter = 0;
    private String Name = "";
    private String Surname = "";
    private int BirthYear = 0;
    private String BirthPlace = "";
    private int Fee = 0;
    private String Status = "";

    public Employee(String Name, String Surname)
    {

        counter++;
        if (counter > 100)
        {
            return;
        }
        this.setName(Name);
        this.setSurname(Surname);
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public int getBirthYear(){
        return BirthYear;
    }

    public void setBirthYear(int year) {
        this.BirthYear = year;
    }

    public String getBirthPlace(){
        return BirthPlace;
    }

    public void setBirthPlace(String place){
        this.BirthPlace = place;
    }

    public int getFee(){
        return Fee;
    }

    public void setFee(int fee){
        this.Fee = fee;
    }

    public String getStatus(){
        return Status;
    }

    public void setStatus(String status){
        this.Status = status;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        this.Id = id;
    }

    void Print(){
        System.out.println(Id + " " + Name + " " + Surname + " " + BirthYear + " " + BirthPlace + " " + Fee + " " + Status);
    }

    public String[] getArr(){
        return new String[]{String.valueOf(Id), Name, Surname, String.valueOf(BirthYear), BirthPlace, String.valueOf(Fee), Status};
    }

}
