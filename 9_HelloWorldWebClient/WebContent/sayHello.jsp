<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Test page for eGTS webservice</title>
        <style>.error { color: red; } .success { color: green; }</style>
    </head>
    <body>
        <form action="sayhello" method="post">
            <h1>HelloWorldWebClient</h1>
            <h2>Say Hello</h2>
            <p>
                <label for="name">Name: </label>
                <input id="name" name="name" value="${param.name}">
                <span class="error">${messages.name}</span>
            </p>
            <p>
                <input type="submit" value="Go">
                <br/>
                <span class="error">${messages.error}</span>
                <br/>
                <span class="name">${messages.helloText}</span>
                <br/>
            </p>
        </form>
    </body>
</html>