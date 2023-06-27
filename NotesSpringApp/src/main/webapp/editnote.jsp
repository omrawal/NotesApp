<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Note</title>
</head>

<body>
    ${noteObject}
    <h1>This is Edit note page</h1>
    <h2>Edit note here</h2>
    <form action="addNote">
        <label>Note id:</label>
        <input type="text" name="note_id" value=${noteObject.getNote_id()} disabled>
        <br>
        <label>Note Owner:</label>
        <input type="text" name="note_owner" value=${noteObject.getNote_owner()} disabled>
        <br>
        <label>Title:</label>
        <input type="text" name="note_title" value=${noteObject.getNote_title()}>
        <br>
        <label>Description:</label>
        <input type="text" name="note_description" value=${noteObject.getNote_description()}>
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
</body>

</html>