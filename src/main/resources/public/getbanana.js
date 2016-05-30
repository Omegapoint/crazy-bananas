$(function () {

    var buffer = [];
    var bufferPosition = 0;
    var bufferSize = 10;

    function temper() {
        return "disappointed";
    }

    function updateMonkey() {
        $("#monkey").removeClass().addClass(temper());
    }

    function updateBanana(bananaColor) {
        $("#banana").removeClass().addClass(bananaColor);
    }

    window.setInterval(function () {
            $.get("/banana", function (data) {
                    banana = JSON.parse(data);
                    buffer[bufferPosition] = banana.color;
                    bufferPosition = (bufferPosition + 1) % bufferSize;
                    updateBanana(banana.color);
                    updateMonkey();
              }
            ).fail(function() {
                    updateBanana("torskblock")
                });
        },
        1000);

})