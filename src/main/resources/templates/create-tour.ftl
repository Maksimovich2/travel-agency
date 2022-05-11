<!doctype html>
<head>
    <title>Tour create</title>
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
        Создание нового тура
    </h2>
    <br/>
    <div>
        <form action="/tours" method="post" name="create-tour" id="create-tour">

            <div class="form-group">
                <label for="tourOperatorEmail">Email оператора</label>
                <input type="email" class="form-control" id="tourOperatorEmail" name="tourOperatorEmail"
                       placeholder="name@example.com">
            </div>
            <div class="form-group">
                <label for="departureDate">Выберите дату отъезда:</label>
                <input type="date" class="form-control" id="departureDate" name="departureDate">
            </div>

            <div class="form-group">
                <label for="departureDate">Выберите дату приезда:</label>
                <input type="date" class="form-control" id="arrivalDate" name="arrivalDate">
            </div>

            <div class="form-group">
                <label for="countTransfers">Количество пересадок</label>
                <input type="text" class="form-control" id="countTransfers" name="countTransfers">
            </div>

            <div class="form-group">
                <label for="price">Цена</label>
                <input type="text" class="form-control" id="price" name="price">
            </div>

            <div class="form-group">
                <label for="hotelId">Выберите отель</label>
                <select class="form-control" id="hotelId" name="hotelId">
                    <#list hotels as hotel>
                        <option value="${hotel.id}">${hotel.name} (кол-во звезд: ${hotel.countStars})</option>
                    </#list>
                </select>
            </div>

            <div class="form-group">
                <label for="notes">Дополнительная информация</label>
                <textarea class="form-control" id="notes" rows="3"></textarea>
            </div>
            <button class="btn btn-primary" type="submit">Save</button>
            <a href="/">Back to Tour List</a>
        </form>
    </div>
</div>
</body>
</html>