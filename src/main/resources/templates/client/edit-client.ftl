<#import "../main.ftl" as main>

<@main.page>
    <h2>Редактировать клиента</h2>
    <form action="/client/update/" method="post">
        <input type="text" name="id" hidden value="${client.id}">
        <input type="text" name="name" placeholder="Имя" value="${client.name}">
        <input type="text" name="middleName" placeholder="Фамилия" value="${client.middleName}">
        <input type="text" name="lastName" placeholder="Отчество" value="${client.lastName}">
        <input type="date" name="birthdate" placeholder="Дата рождения" value="${client.birthdate}">
        <button>Обновить книгу</button>
    </form>
</@main.page>