function checkAuth() {
    var logged = (function() {
        var isLogged = null;
        $.ajax({
            'async': false,
            'global': false,
            'url': '/user/isLogged/',
            'success': function(resp) {
                isLogged = (resp === "1");
            }
        });
        return isLogged;
    })();
    return logged;
}