<#import "../main.ftl" as main>

<@main.page>
    <h2>Регистрация аренды книги</h2>

    <h4>Выберете книгу</h4>

    <p>Поиск по фильтру</p>
    <form action="/rent/choose/book" method="get">
        <input type="text" name="title" placeholder="Название книги">
        <input type="text" name="author" placeholder="Автор">
        <input type="number" name="isbn" placeholder="ISBN">
        <button>Поиск</button>
    </form>

    <#if books.books?size != 0>
        <h4>Выбор страницы</h4>
        <div>
            <#list 1..books.getPagination().getLastPage() as page>
                <a href="/rent/choose/book?title=${search.title!}&author=${search.author!}&isbn=${search.isbn!}&page=${page}" style="padding: 0 10px;">${page}</a>
            </#list>
        </div>
        <hr>
        <table>
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
                        <td>
                            <form action="/rent/add" method="post">
                                <input type="text" name="clientId" value="${clientId}" hidden>
                                <input type="text" name="bookId" value="${book.id}" hidden>
                                <button>Выбрать</button>
                            </form>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p>Список книг пуст</p>
    </#if>
</@main.page>