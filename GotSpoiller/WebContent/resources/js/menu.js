$(document).ready(function() {
    $('select').material_select();
    $('#loader').hide();
    
//    console.log("${usuarioLogado}");
//    var fd = new FormData()
//    fd.append('user',"${usuarioLogado}")
//    
//    fetch("http://localhost:8080/GotSpoiller/getHistory", {
//    	method: 'POST',
//    	body : fd
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
						"Tel: " + $result.history[i].numero_recebido + "<br>" + "Temporada: " + $result.history[i].temp + "<br>" +
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
    	console.log("${usuarioLogado}")
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
    $("#sendButton").click((e) => {

    	$name = $("#friendName").val()
    	$phone = $("#friendPhone").val()
    	$temp = $("#temp").val()
    	$spoiler = $("#spoilers").val()
    	$json = {"name": $name, 
    			 "phone": $phone,
    			 "temp": $temp,
    			 "spoiler": $spoiler,
    			 "login": "${usuarioLogado}"}
    	if($phone != ""){
    		if($temp != null){
    			$('#loader').show();
    			$.ajax({
    	    		type: "POST",
    	    		url: "sendMessage",
    	    		data: JSON.stringify($json),
    	    		success: function (result) {
    	            	$result = JSON.parse(result)
    	            	console.log($result)
    	            	alert("Mensagem enviada com sucesso!")	
    	            	$('#loader').hide();
    	            	$( "#history" ).append( "<ul class='collection'> " +
    							"<li class='blue-grey darken-1 collection-item avatar'>" +
    							"<span class='title'>" + "Para: " + $name + "</span>" +
    							"<p> " +	
    							"Tel: " + $phone + "<br>" + "Temporada: " + $temp + "<br>" +
    							"</p></li>" +
    							"</ul>"
    							
    	        		);
    	            	
    	            	
    	            },
    	            error: function (result) {
    	            	console.log("Nao foi");
    	                // do something.
    	            }	
    	    	})
    		}
    		else{
    			alert("Selecione uma temporada!")
    		}
    	}
    	else{
    		alert("O telefone não pode ser vazio!")
    	}
    })
 });