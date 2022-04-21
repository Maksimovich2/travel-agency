<!doctype html>
<head>
    <title>Hotel save</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
</head>
<body>
<div class="container">
    <h2>
        <#if !isUpdate>Create</#if>
        <#if isUpdate>Update</#if>
        Hotel
    </h2>
    <div>
        <form action="<#if isUpdate>/update/${hotel.id}</#if><#if !isUpdate>/hotels/save</#if>"
              method="post" name="user">
            <table class="table">
                <tbody>
                <thead>
                <tr>
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <#if isUpdate>
                    <tr>
                        <th>ID</th>
                        <td>
                            <div name="id">${hotel.id}</div>
                        </td>
                    </tr>
                </#if>
                <tr>
                    <th>Name</th>
                    <td><input name="name" type="text"
                               value="<#if hotel.name??>${hotel.name}</#if>"/></td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td><input name="location" type="text"
                               value="<#if hotel.location??>${hotel.location}</#if>"/></td>
                </tr>
                <tr>
                    <th>Count stars</th>
                    <td><input name="countStars" type="number"
                               value="<#if hotel.countStars??>${hotel.countStars}</#if>"/></td>
                </tr>
                </tbody>
            </table>
            <button class="btn btn-primary" type="submit">Save</button>
        </form>
    </div>
</div>
</body>
</html>