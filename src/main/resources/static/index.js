$(document).ready(function () {
  $.get("http://localhost:8080/api/", function () {
    $('#mainBody').append('<tr><th scope="row">2</th><td>Mark</td><td>Otto</td><td>@mdo</td></tr>');
  });


  $('#value').keypress(function (event) {
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if (keycode == '13') {
      event.preventDefault();
      var str = $("#value").val();
      $.get("http://localhost:8080/api" + str, function (data) {
        $("#cityBody").append('<tr><th scope="row">2</th><td>Mark</td><td>Otto</td><td>@mdo</td></tr>');
      }
      );
    }
  });
});