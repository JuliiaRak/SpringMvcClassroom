<#import "parts/common.ftlh" as c>
<@c.page>

    <div class="form-row">
        <div class ="form-group col-md-6">
            <form method="get" action="/query" class="form-inline">
                <input type="text" name="filter" class="form-controll" value="${filter?if_exists}" placeholder="Відсортувати за викладачем"/>
                <button type="submit" class="btn btn-primary ml-2">Відсортувати</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Записатись в чергу
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="comment" placeholder="Коментар" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="admin" placeholder="Викладач" />
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Записатись</button>
                </div>
            </form>
        </div>
    </div>

    <p></p>
    <p></p>
    <br/>
    <h3>Список людей в черзі</h3>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">Студент</th>
            <th scope="col">Викладач</th>
            <th scope="col">Коментар</th>
        </tr>
        </thead>
        <tbody>
        <#list members as member>
            <tr>
                <td>${member_index + 1}</td>
                <td>${member.authorName}</td>
                <td>${member.admin}</td>
                <td>${member.comment}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>