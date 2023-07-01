<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Note Page</title>
</head>

<body>
    <h1>Notes are:</h1>
    <!-- ${notes}
    ${notes} -->
    Current note is
    <p th:text="${notes}">Some test</p>

    <table>
        <thead>
            <tr>
                <th> Title </th>
                <th> Author </th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="note : ${notes}">
                <td th:text="${note.note_id}">Ome</td>
                <td th:text="${note.note_owner}">Ome</td>
            </tr>
        </tbody>
    </table>

</body>

</html>