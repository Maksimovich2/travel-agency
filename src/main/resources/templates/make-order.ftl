<!doctype html>
<head>
    <title>Order</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script src="jquery.serializeJSON.min.js"></script>
</head>

<body>
<div class="container">
    <h2>
        Оформление заказа
    </h2>

    <h3>
        Заполните ваши данные
    </h3>
    <br/>
    <div>
        <form action="/order/make-order/${tour.id}" method="post" name="create-tour" id="create-tour">
            <table class="table">
                <tbody>
                <thead>
                <tr>
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>First name</th>
                    <td><input name="firstName" type="text"
                               value="<#if client.firstName??>${client.firstName}</#if>"/></td>
                </tr>
                <tr>
                    <th>Last name:</th>
                    <td><input name="lastName" type="text"
                               value="<#if client.lastName??>${client.lastName}</#if>"/></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><input name="email" type="email"
                               value="<#if client.email??>${client.email}</#if>"/></td>
                </tr>

                <tr>
                    <th>Age:</th>
                    <td><input name="age" type="number"
                               value="<#if client.age??>${client.age}</#if>"/></td>
                </tr>
                <tr>
                    <th>Sex:</th>
                    <td><input name="sex" type="text"
                               value="<#if client.sex??>${client.sex}</#if>"/></td>
                </tr>
                </tbody>
            </table>
            <button class="btn btn-primary" type="submit">Save</button>
            <a href="/">Back to Hotel List</a>
        </form>
    </div>
</div>
</body>
</html>