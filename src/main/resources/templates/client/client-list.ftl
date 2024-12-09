<#import "../main.ftl" as main>

<@main.page>
    <h2>Добавить нового клиента</h2>
    <form action="/client/add" method="post">
        <input type="text" name="lastName" placeholder="Фамилия">
        <input type="text" name="name" placeholder="Имя">
        <input type="text" name="middleName" placeholder="Отчество">
        <input type="date" name="birthdate" placeholder="Дата рождения">
        <button>Добавить клиента</button>
    </form>

    <h2>Список клиентов</h2>
    <#if clients.clients?size != 0>
        <h4>Выбор страницы</h4>
        <div>
            <#list 1..clients.getPagination().getLastPage() as page>
                <a href="/client?page=${page}" style="padding: 0 10px;">${page}</a>
            </#list>
        </div>
        <hr>
        <table>
            <thead>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>День рождения</th>
                <th>Редактирование</th>
            </tr>
            </thead>
            <tbody>
            <#list clients.clients as client>
                <tr>
                    <td>${client.lastName}</td>
                    <td>${client.name}</td>
                    <td>${client.middleName}</td>
                    <td>${client.birthdate}</td>
                    <td><a href="/client/${client.id}">Редактировать</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <p>Список клиентов пуст</p>
    </#if>
</@main.page>