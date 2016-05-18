<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Test page for eGTS webservice</title>
        <style>.error { color: red; } .success { color: green; }</style>
    </head>
    <body>
        <form action="startSmallTalk" method="post">
            <h1>HelloWorldWebClient</h1>
            <h2>Start small talk conversation</h2>
            <p>
                <label for="name">Name: </label>
                <input id="name" name="name" value="${param.name}">
                <span class="error">${messages.name}</span>
            </p>
            <p>
                <label for="date">Date: </label>
                <input id="date" name="date" value="${param.date}">
                <span class="error">${messages.date}</span>
            </p>
            <p>
                <input type="submit" value="Start small talk">
                <br/>
                <span class="error">${messages.error}</span>
                <br/>
                <span class="name">${messages.smallTalkComment}</span>
                <br/>
            </p>
        </form>
    </body>
</html>