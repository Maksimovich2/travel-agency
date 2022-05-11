<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<html lang="ENG">
<!doctype html>
<head>
    <title>Tours</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="styles/tourcss.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div>
    <#if known>
        <!-- Сессия существует (вход осуществлен) - получение профиля пользователя -->
        <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        >
        <nav class="navbar navbar-inverse container" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                    </button>
                    <a class="navbar-brand" href="/">Terrific trip</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="/" class="dropdown-toggle">${name}</a>
                        </li>
                        <li class="dropdown">
                            <a href="/order/orders" class="dropdown-toggle">
                                my orders</a>
                        </li>
                        <li class="dropdown">
                            <a href="/logout" class="dropdown-toggle"><span class="glyphicon glyphicon-log-out"></span>
                                Logout</a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <br/>
        <div class="container">

            <h2>All tours</h2>
            <#if isAdmin == true>
                <a href="/tours/save-tour-form" class="btn btn-primary" role="button">Create new tour</a>
            </#if>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Hotel name</th>
                    <th scope="col">Location</th>
                    <th scope="col">Count stars</th>
                    <th scope="col">Departure date</th>
                    <th scope="col">Arrival date</th>
                    <th scope="col">Count transfers</th>
                    <th scope="col">Email</th>
                    <th scope="col">Price</th>
<#--                    <th scope="col">Notes</th>-->
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <#list tours as tour>
                    <tr>
                        <th scope="row">${tour.hotelName}</th>
                        <td>${tour.location}</td>
                        <td>${tour.countStars}</td>
                        <td>${tour.departureDate}</td>
                        <td>${tour.arrivalDate}</td>
                        <td>${tour.countTransfers}</td>
                        <td>${tour.tourOperatorEmail}</td>
                        <td>${tour.price}</td>
<#--                        <td>${tour.notes}</td>-->

                        <#if isAdmin == true>
                        <#--                            нужно сделать деактивацию тура-->
                            <td><a href="/tours/tour/delete/${tour.id}" class="btn btn-danger" role="button">
                                    Deactivate</a></td>
                        <#else >
                        <#--                            нужно сделать покупку тура-->
                            <td><a href="order/make-order/${tour.id}" class="btn btn-success" role="button">
                                    BUY</a></td>
                        </#if>

                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </#if>
</div>
</body>
</html>