$(function () {
    window.setInterval(function () {
            $.get("/banana", function (data) {
                banana = JSON.parse(data);
                $("#monkey").removeClass().addClass(banana.color);
              })
        },
        1000);

})