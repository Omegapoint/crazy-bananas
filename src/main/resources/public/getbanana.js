$(function () {

    function updateMonkey(bananaColor) {
        $("#monkey").removeClass().addClass(bananaColor);
    }

    window.setInterval(function () {
            $.get("/banana", function (data) {
                banana = JSON.parse(data);
                updateMonkey(banana.color);
              }
            ).fail(function() {
                    updateMonkey("torskblock")
                });
        },
        1000);

})