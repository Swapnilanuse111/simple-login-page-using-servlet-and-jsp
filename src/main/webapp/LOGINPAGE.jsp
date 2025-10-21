<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #74b9ff, #a29bfe);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
    }

    .login-container {
        background-color: white;
        padding: 40px 50px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        width: 350px;
        text-align: center;
    }

    .login-container h2 {
        margin-bottom: 25px;
        color: #2d3436;
        font-size: 28px;
        letter-spacing: 1px;
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px 5px;
        font-size: 16px;
        color: #2d3436;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #b2bec3;
        border-radius: 8px;
        outline: none;
        transition: 0.3s;
    }

    input[type="text"]:focus, input[type="password"]:focus {
        border-color: #0984e3;
        box-shadow: 0 0 5px rgba(9, 132, 227, 0.4);
    }

    .btn {
        width: 48%;
        padding: 10px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-weight: bold;
        transition: 0.3s;
        font-size: 15px;
    }

    .btn-login {
        background-color: #0984e3;
        color: white;
    }

    .btn-login:hover {
        background-color: #74b9ff;
    }

    .btn-reset {
        background-color: #d63031;
        color: white;
    }

    .btn-reset:hover {
        background-color: #ff7675;
    }

    .footer {
        margin-top: 15px;
        font-size: 13px;
        color: #636e72;
    }
</style>
</head>

<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="textName" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="textpwd" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Login" class="btn btn-login">
                        <input type="reset" value="Reset" class="btn btn-reset">
                    </td>
                </tr>
            </table>
        </form>
        <div class="footer"><b>© 2025 SOPAN LIVE<b></div>
    </div>
</body>
</html>
