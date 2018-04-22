<%--
  Created by IntelliJ IDEA.
  User: bakhodir
  Date: 4/22/18
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>Login</title>
    <link rel="stylesheet" href="Res/loginPage/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
            type="application/javascript"></script>
    <script src="Res/loginPage/indexPage.js" type="application/javascript"></script>
</head>
<body>
<nav class="main-nav">
    <ul>
        <li><a class="signin">Sign in</a></li>
        <li><a class="signup">Sign up</a></li>
    </ul>
</nav>

<div class="user-modal">
    <div class="user-modal-container">
        <ul class="switcher">
            <li><a href="#0">Sign in</a></li>
            <li><a href="#0">New account</a></li>
        </ul>

        <div id="login">
            <form class="form" action="/login" method="post">
                <p class="fieldset">
                    <label class="image-replace email" for="signin-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="signin-email" type="email"
                           placeholder="E-mail" name="username">
                    <!--  <span class="error-message">An account with this email address does not exist!</span> -->
                </p>

                <p class="fieldset">
                    <label class="image-replace password" for="signin-password">Password</label>
                    <input class="full-width has-padding has-border" name="password" id="signin-password"
                           type="password"
                           placeholder="Password">
                    <a href="#0" class="hide-password">Show</a>
                    <span class="error-message">Wrong password! Try again.</span>
                </p>

                <p class="fieldset">
                    <input type="checkbox" id="remember-me" checked>
                    <label for="remember-me">Remember me</label>
                </p>

                <p class="fieldset">
                    <input class="full-width" type="submit" value="Login">
                </p>
            </form>

            <p class="form-bottom-message"><a href="#0">Forgot your password?</a></p>
            <!-- <a href="#0" class="close-form">Close</a> -->
        </div>

        <div id="signup">
            <form class="form" action="/register" method="post">
                <p class="fieldset">
                    <label class="image-replace username" for="signup-username">First Name</label>
                    <input class="full-width has-padding has-border" id="signup-username" type="text"
                           placeholder="First Name" name="firstName">
                    <span class="error-message">Your first Name can only contain numeric and alphabetic symbols!</span>
                </p>
                <p class="fieldset">
                    <label class="image-replace username" for="signup-username">Last Name</label>
                    <input class="full-width has-padding has-border" type="text"
                           placeholder="Last Name" name="lastName">
                    <span class="error-message">Your last name can only contain numeric and alphabetic symbols!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace username" for="signup-username">Date of birth</label>
                    <input class="full-width has-padding has-border" type="date"
                           placeholder="Date of birth" name="dob">
                </p>

                <p class="fieldset">
                    <label class="image-replace email">E-mail</label>
                    <input class="full-width has-padding has-border" type="text"
                           placeholder="E-mail" name="userName">
                </p>

                <p class="fieldset">
                    <label class="image-replace password" for="signup-password">Password</label>
                    <input class="full-width has-padding has-border" id="signup-password" type="password"
                           placeholder="Password" name="password">
                    <a href="#0" class="hide-password">Show</a>
                    <span class="error-message">Your password has to be at least 6 characters long!</span>
                </p>

                <p class="fieldset">
                    <button class="full-width has-padding" type="submit">Create account</button>
                </p>
            </form>

            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div>

        <div id="reset-password">
            <p class="form-message">Lost your password? Please enter your email address.</br> You will receive a link to
                create a new password.</p>

            <form class="form">
                <p class="fieldset">
                    <label class="image-replace email" for="reset-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                    <!-- <span class="error-message">An account with this email does not exist!</span> -->
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Reset password">
                </p>
            </form>

            <p class="form-bottom-message"><a href="#0">Back to log-in</a></p>
        </div>
        <a href="#0" class="close-form">Close</a>
    </div>
</div>
</body>
</html>