<!doctype html>
<head>
    <title>Rooms</title>
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
    <h2>All rooms</h2>
    <a href="/save" class="btn btn-primary" role="button">Save new room</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Number</th>
            <th scope="col">Capacity</th>
            <th scope="col">Price</th>
            <th scope="col">Status</th>
            <th scope="col">Hotel name</th>
        </tr>
        </thead>
        <tbody>
        <#list rooms as room>
            <tr>
                <th scope="row">${room.id}</th>
                <td>${room.number}</td>
                <td>${room.capacity}</td>
                <td>${room.price}</td>
                <td>${room.status}</td>
                <td>${room.hotel}</td>
                <td><a href="/update/${room.id}" class="btn btn-warning" role="button">
                        Update</a></td>
                <td><a href="/delete/${room.id}" class="btn btn-danger" role="button">
                        Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>