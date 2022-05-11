<!doctype html>
<head>
    <title>Hotel</title>
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
    <h2>All hotels</h2>
    <#if isAdmin == true>
        <a href="/hotels/save" class="btn btn-primary" role="button">Add new hotel</a>
    </#if>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Count stars</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list hotels as hotel>
            <tr>
                <th scope="row">${hotel.id}</th>
                <td>${hotel.name}</td>
                <td>${hotel.location}</td>
                <td>${hotel.countStars}</td>
                <#if isAdmin == true>
                    <td><a href="${'/hotels/update/' + hotel.id}" class="btn btn-warning" role="button">
                            Update</a></td>
                    <td><a href="${'/hotels/delete/' + hotel.id}" class="btn btn-danger" role="button">
                            Delete</a></td>
                </#if>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>