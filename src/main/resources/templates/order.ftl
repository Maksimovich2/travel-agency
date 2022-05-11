<!doctype html>
<html lang="ENG">
<head>
    <title>Orders</title>
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
    <h2>All orders</h2>
    <#if isAdmin == true>
        <a href="order/save" class="btn btn-primary" role="button">Make new order</a>
    </#if>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Last name</th>
            <th scope="col">First name</th>
            <th scope="col">Order time</th>
            <th scope="col">Total price</th>
            <th scope="col">Hotel name</th>
            <th scope="col">Location</th>
            <th scope="col">Count transfers</th>
            <th scope="col">Arrival date</th>
            <th scope="col">Departure date</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.clientLastName}</td>
                <td>${order.clientFirstName}</td>
                <td>${order.orderTime}</td>
                <td>${order.totalPrice}</td>
                <td>${order.hotelName}</td>
                <td>${order.location}</td>
                <td>${order.countTransfers}</td>
                <td>${order.arrivalDate}</td>
                <td>${order.departureDate}</td>
                <#if isAdmin == true>
                    <td><a href="orders/delete/${order.id}" class="btn btn-danger" role="button">
                            Cancel order</a></td>
                </#if>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/">Back to Tour List</a>
</div>
</body>
</html>