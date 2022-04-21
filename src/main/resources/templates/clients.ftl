<!doctype html>
<head>
    <title>Client</title>
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
    <h2>All clients</h2>
    <a href="/save" class="btn btn-primary" role="button">Save new client</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">age</th>
            <th scope="col">sex</th>
            <th scope="col">email</th>
        </tr>
        </thead>
        <tbody>
        <#list clients as client>
            <tr>
                <th scope="row">${client.id}</th>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.age}</td>
                <td>${client.sex}</td>
                <td>${client.email}</td>
                <td><a href="/update/${client.id}" class="btn btn-warning" role="button">
                        Update</a></td>
                <td><a href="/delete/${client.id}" class="btn btn-danger" role="button">
                        Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>