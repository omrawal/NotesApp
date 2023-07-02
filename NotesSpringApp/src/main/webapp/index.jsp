<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notes App</title>
</head>

<body>
    <h1>Welcome to notes app</h1>
    <h2>View user list <a href="/getAllUsers">here</a></h2>
    <hr>
    <h2>Add new user here</h2>
    <form action="addUser">
        <label>Username:</label>
        <input type="text" name="username">
        <br>
        <label>Password:</label>
        <input type="password" name="password">
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
    <h2>View note list <a href="/getAllNotes">here</a></h2>
    <hr>
    <h2>Add new note here</h2>
    <form action="addNote">
        <label>Note Owner:</label>
        <input type="text" name="note_owner">
        <br>
        <label>Title:</label>
        <input type="text" name="note_title">
        <br>
        <label>Description:</label>
        <input type="text" name="note_description">
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
    <h2>Add new user here(using rest api)</h2>
    <form method="post" action="create_user">
        <label>Username:</label>
        <input type="text" name="username">
        <br>
        <label>Password:</label>
        <input type="password" name="password">
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
    <h2>Add new note here(using rest api)</h2>
    <form method="post" action="create_note">
        <label>Note Owner:</label>
        <input type="text" name="note_owner">
        <br>
        <label>Title:</label>
        <input type="text" name="note_title">
        <br>
        <label>Description:</label>
        <input type="text" name="note_description">
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
    <h2>Edit note here(using rest api)</h2>
    <form method="post" action="/editnote">
        <label>Note ID:</label>
        <input type="text" name="noteId">
        <br>
        <button type="submit">SUBMIT</button>
        <button type="reset">RESET</button>
    </form>
    <hr>
</body>

</html>