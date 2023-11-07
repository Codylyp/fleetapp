$('document').ready(function(){
    let password = document.getElementById("yourPassword")
    let confirmPassword = document.getElementById("yourConfirmPassword");

    function validatePassword(){
        if(password.value != confirmPassword.value) {
            confirmPassword.setCustomValidity("Passwords Don't Match");
        } else {
            confirmPassword.setCustomValidity('');
        }
    }
    password.onchange = validatePassword;
    confirmPassword.onkeyup = validatePassword;
});