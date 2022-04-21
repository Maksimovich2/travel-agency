<!doctype html>
<head>
    <title>Tours</title>
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
    <h2>All tours</h2>
    <a href="/save" class="btn btn-primary" role="button">Save new tour</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Hotel</th>
            <th scope="col">Departure date</th>
            <th scope="col">Arrival date</th>
            <th scope="col">Count transfers</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list tours as tour>
            <tr>
                <th scope="row">${tour.id}</th>
                <td>${tour.hotel}</td>
                <td>${tour.departureDate}</td>
                <td>${tour.arrivalDate}</td>
                <td>${tour.countTransfers}</td>
                <td><a href="/update/${tour.id}" class="btn btn-warning" role="button">
                        Update</a></td>
                <td><a href="/delete/${tour.id}" class="btn btn-danger" role="button">
                        Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>