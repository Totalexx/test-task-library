<#import "../main.ftl" as main>

<@main.page>
    <h2>Добавить новую книгу</h2>
    <form action="/book/add" method="post">
        <input type="text" name="title" placeholder="Название книги">
        <input type="text" name="author" placeholder="Автор">
        <input type="number" name="isbn" placeholder="ISBN">
        <button>Добавить книгу</button>
    </form>

    <h2>Список книг</h2>
    <#if books.books?size != 0>
        <h4>Выбор страницы</h4>
        <div>
            <#list 1..books.getPagination().getLastPage() as page>
                <a href="/book?page=${page}" style="padding: 0 10px;">${page}</a>
            </#list>
        </div>
        <hr>
        <table >
            <thead>
                <tr>
                    <th>Название</th>
                    <th>Автор</th>
                    <th>ISBN</th>
                    <th>Редактирование</th>
                </tr>
            </thead>
            <tbody>
                <#list books.books as book>
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.isbn?c}</td>
                        <td><a href="/book/${book.id}">Редактировать</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p>Список книг пуст</p>
    </#if>
</@main.page>