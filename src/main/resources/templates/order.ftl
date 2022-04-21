<!doctype html>
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
    <a href="/save" class="btn btn-primary" role="button">Make new order</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Client</th>
            <th scope="col">Order time</th>
            <th scope="col">Total price</th>
            <th scope="col">Tour</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.client}</td>
                <td>${order.orderTime}</td>
                <td>${order.totalPrice}</td>
                <td>${order.tour}</td>
                <td><a href="/update/${order.id}" class="btn btn-warning" role="button">
                        Update</a></td>
                <td><a href="/delete/${order.id}" class="btn btn-danger" role="button">
                        Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>