<!DOCTYPE html>
<html>
<head>
    <title>Библиотека</title>
</head>
<body>
<h1>Библиотека</h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Логин: <input type="Text" name="login"><br><br>
    Пароль: <input type="password" name="Password"><br><br>
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}">-->
    <input type="submit" value="Вход"/>
</form>
<a href="/registration">Зарегистрироваться</a>
</body>
</html>