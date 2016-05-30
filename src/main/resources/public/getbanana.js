$(function () {

    var happy_lower_limit = 18;
    var disappointed_lower_limit = 10;
    var buffer = ["yellow","yellow","yellow","yellow","yellow","yellow","yellow","yellow","yellow","yellow"];
    var bufferPosition = 0;
    var bufferSize = 10;
    var score = {"yellow": 2, "brown": 1, "torskblock": 0};

    function evaluate(sum) {
        if (sum >= happy_lower_limit) {
            return "happy";
        }
        if (sum >= disappointed_lower_limit) {
            return "disappointed";
        }
        return "angry";
    }

    function temper() {
        var sum = 0;
        $.each(buffer, function(index, value){
            sum += score[value];
        });
        console.log(sum);
        return evaluate(sum);
    }

    function updateMonkey() {
        $("#monkey").removeClass().addClass(temper());
    }

    function updateBanana(bananaColor) {
        $("#banana").removeClass().addClass(bananaColor);
        buffer[bufferPosition] = bananaColor;
        bufferPosition = (bufferPosition + 1) % bufferSize;
    }

    window.setInterval(function () {
            $.get("/banana", function (data) {
                    banana = JSON.parse(data);
                    updateBanana(banana.color);
              }
            ).fail(function() {
                    updateBanana("torskblock")
                });
            updateMonkey();
        },
        1000);

})