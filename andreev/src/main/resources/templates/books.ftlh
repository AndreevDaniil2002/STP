<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Library</title>

</head>
<body>
<h1>Welcome to my Library | <a href="/login">Войти</a></h1><hr>
<#list books as book>
<table border="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Publisher</th>
        <th>Student</th>
        <th>DateStart</th>
        <th>DateEnd</th>
    </tr>
    <tr>
        <td width="100px">${book.bookId}</td>
        <td width="100px">${book.bookName}</td>
        <td width="100px">${book.bookPublisher}</td>
        <td width="100px">${book.studentFIO}</td>
        <td width="100px">${book.bookStartDate}</td>
        <td width="100px">${book.bookEndDate}</td>
    </tr>
</table>
    <#else>
    <h3>Книг нет</h3>
</#list>

<hr><hr><hr><hr><hr><hr><hr><hr><hr>
<form action="/book/create" method="post">
    Название книги: <input type="text" name="bookName"/><br><br>
    Издатель книги: <input type="text" name="bookPublisher"/><br><br>
    ФИО студента: <input type="text" name="studentFIO"/><br><br>
    Дата выдачи книги: <input type="text" name="bookStartDate"/><br><br>
    Дата получения книги: <input type="text" name="bookEndDate"/><br><br>
    <input type="submit" value="Добавить книгу">
</form>

<form action="/" method="get">
    Поиск книги по названию: <input type="text" name="Name"><br>
    <input type="submit" value="Search">
</form>
</body>
</html>