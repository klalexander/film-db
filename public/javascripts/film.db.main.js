//deprecated page, only for example and test
function testResults(form){
	theMovieDb.search.getMovie({"query":encodeURIComponent(document.forms["myform"]["inputbox"].value)}, success, error);
}

function error(res) {
	console.log(res);
}

function success(res) {
	$("#personDataTable").html("");
	var data = JSON.parse(res);
	for (var i = 0; i < data["results"].length; i++) {
		drawRow(data["results"][i]);
	}
}

//this is stub for checking api of this lib
function drawRow(rowData) {
	var row = $("<tr/>")
	$("#personDataTable").append(row);
	row.append($("<td><input type='checkbox' value='"+rowData.id+"'></td>"));
	row.append($("<td>" + rowData.id + "</td>"));
	row.append($("<td>" + rowData.original_title + "</td>"));
	row.append($("<td>" + rowData.overview + "</td>"));
	row.append($("<td>" + rowData.popularity + "</td>"));
	if (rowData.poster_path != "null") {
		row.append($("<td><img src='http://image.tmdb.org/t/p/w500" + rowData.poster_path + "' style='width:304px;height:228px;'></td>"));
	}
	row.append($("<td>" + rowData.title + "</td>"));
}

function init(){
	$('#personDataTable' ).on( 'click', 'input[type="checkbox"]', function() {
		console.log($(this).val());
		if ($(this).is(":checked")) {
			filmRequest($(this).val(), "POST");
		} else {
			filmRequest($(this).val(), "DELETE");
		}
	});
}

function filmRequest(filmId, requestType) {
	$.ajax({
		type: requestType,
		url: "/film/"+filmId,
		success: function(msg){
			alert( "Result: " + msg );
		}
	});
}

function addFilmsList(filmsListName) {
	$.ajax({
		type: "POST",
		url: "/films/list/"+filmsListName,
		success: function(msg){
			alert( "Data Saved: " + msg );
		}
	});
}