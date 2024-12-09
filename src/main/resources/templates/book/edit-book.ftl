<#import "../main.ftl" as main>

<@main.page>
    <h2>Редактировать книгу</h2>
    <form action="/book/update/" method="post">
        <input type="text" name="id" hidden value="${book.id}">
        <input type="text" name="title" value="${book.title}" placeholder="Название книги">
        <input type="text" name="author" value="${book.author}" placeholder="Автор">
        <input type="number" name="isbn" value="${book.isbn?c}" placeholder="ISBN">
        <button>Обновить книгу</button>
    </form>
</@main.page>