<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Library</title>

</head>
<body>
<h1>Информация о товрае</h1><hr>
<b>Название книги: </b>${book.bookName}
<b>Издатель книги: </b>${book.bookPublisher}
<b>ФИО студента: </b>${book.studentFIO}
<b>Дата выдачи книги: </b>${book.bookStartDate}
<b>Дата получения книги: </b>${book.bookEndDate}
<form action="/book/delete/${book.bookId}" method="post">
    <input type="submit" value="Удалить эту книгу">
</form>
</body>
</html>