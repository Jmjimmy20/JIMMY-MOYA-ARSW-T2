$(document).ready(function () {
  $.get("countries/getAll", function (data) {
    $('#mainBody').html('');
    $('#confirmed').html('');
    $('#recovered').html('');
    $('#deaths').html('');
    let index = 0;
    $.map(data, (val) => {
      let tdc = '<td>' + val.confirmed + '</td>'
      let tdr = '<td>' + val.recovered +  '</td>'
      let tdd = '<td>' + val.deaths + '</td>'
      let th = '<th scope="row">' + val.country + '</th>'
      let tr = '<tr id="' + 'id' + index + '">' + th + tdd + tdc + tdr + '</tr>'
      $('#mainBody').append(tr);
      $('#id' + index).click(function (val) {
        console.log(val.currentTarget.cells[0].innerText)
        $('#country').html(val.currentTarget.cells[0].innerText);
        $('#confirmed').html(val.currentTarget.cells[1].innerText);
        $('#recovered').html(val.currentTarget.cells[2].innerText);
        $('#deaths').html(val.currentTarget.cells[3].innerText);
        $.get("countries/" + val.currentTarget.cells[0].innerText, function (data) {
          console.log(data)
        });
      });
      index += 1;
    })
  });
  
});