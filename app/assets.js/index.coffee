$ ->
  $.get "/notas", notas ->
    $.each notas, (index, nota) ->
      $("#notas").append $("<li>").text nota.text