var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

function getWeatherData() {
	$('#conversationDiv').html("");
	$.ajax({
	       url: contextPath + '/weather?city=' + $('#city').val(),
	       type: 'get',
	       dataType: 'json',
	       'contentType': 'application/json',	       
	       success: function (data) {
	           constructTable(data);
	       }
	   });
}


function constructTable(data){
    var table = $('<table class="data" border=1></table>');
    if(data.valid){
        table.append(getRow('Today Date', data.today));
        table.append(getRow('city name', data.cityname));
        table.append(getRow('description', data.description));
        table.append(getRow('sunrise', data.sunrise));
        table.append(getRow('sunset', data.sunset));
        table.append(getRow('temperatureIn F', data.temperatureInF));
        table.append(getRow('temperatureIn C', data.temperatureInC));
   }else{
        table.append(getRow('Error', data.error));
   }
    $('#conversationDiv').append(table);
}


function getRow(column1, column2){
    var row = $('<tr></tr>');
    row.append($('<td></td>').text(column1));
    row.append($('<td></td>').text(column2));
    return row;
}