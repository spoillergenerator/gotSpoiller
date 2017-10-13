$(document).ready(function() {
    $('select').material_select();
    
//    console.log("${usuarioLogado}");
    
//    fetch("http://localhost:8080/GotSpoiller/getHistory", {
//    	method: 'post',
//    	body : JSON.stringify({"user": "${usuarioLogado}"})
//    }).then(function(response){
//    	console.log("cheguei")
//    	response.json().then(function(data) {
//    		console.log(data)
//    	})
//    })
    $.ajax({
        type: "POST",
        url: "getHistory",
        data: JSON.stringify({"user": "${usuarioLogado}"}),
        success: function (result) {
        	$result = JSON.parse(result)
        	for(i = 0; i<=Object.values($result.history).length; i++){
        		$( "#history" ).append( "<ul class='collection'> " +
						"<li class='blue-grey darken-1 collection-item avatar'>" +
						"<span class='title'>" + "Para: " + $result.history[i].nome + "</span>" +
						"<p> " +	
						"Tel: " + $result.history[i].numero_recebido + "<br>" + "Temp: " + $result.history[i].temp + "<br>" +
						"</p></li>" +
						"</ul>"
						
        		);
        	}
        },
        error: function (result) {
        	console.log("Nao foi");
            // do something.
        }
    });
    
    $('#temp').change( function() {
    	$.ajax({
    		type: "POST",
    		url: "getSpoilers",
    		data: JSON.stringify({"temp": $('#temp').val()}),
    		success: function (result) {
            	$result = JSON.parse(result)
            	console.log($result)
            	
            	$('#spoilers').empty()

            	for(i = 0; i<Object.values($result.spoilers).length; i++){
                	$("#spoilers").append('<option value='+ '"' + $result.spoilers[i].texto + '"' +'>' + $result.spoilers[i].texto + '</option>')        
                	$('select').material_select();
                	console.log($result.spoilers[i].texto)
            	}
            	
            },
            error: function (result) {
            	console.log("Nao foi");
                // do something.
            }
    		
    		
    	})
    })  
 });