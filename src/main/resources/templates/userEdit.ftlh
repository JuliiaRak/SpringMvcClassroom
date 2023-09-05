<#import "parts/common.ftlh" as c>

<@c.page>
    <h3>Редагувати користувача</h3>

    <form action="/user" method="post">
        <input type="text" class="form-control mb-3" name="username" value="${user.username}" />
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary">Зберегти</button>
    </form>
</@c.page>