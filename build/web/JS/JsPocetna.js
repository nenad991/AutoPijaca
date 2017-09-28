function index()
{
    $('.fadein').hide();
    $('.fadein').fadeIn(2000);
}
$(document).ready(index);

function vreme()
{
    var d = new Date();
    var sat = d.getHours();
    var min = d.getMinutes();
    var sec = d.getSeconds();
    document.getElementById("sat").innerHTML = sat + ":" + min + ":" + sec;
    setInterval(vreme, 1000);
}
$(document).ready(function ()
{
    $("#login").click(function () {
        $("#avatar").show();
    });
});
 