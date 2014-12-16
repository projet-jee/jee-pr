<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery.min.js" ></script>

<style type="text/css">
	html { height: 100% }
  body { height: 100%; margin: 0px; padding: 0px }
  #container { width: 100%; height: 100% }
  #nav { z-index: 100; position: absolute; margin: 10px 0px 0px 200px; background-color: #fff; border: 1px #000 Solid; padding: 5px; }
  #map { width: 100%; height: 100% }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>geoChat</title>
</head>
<body onload="initialize();">
<script src="http://maps.google.com/maps/api/js?sensor=false&libraries=places" type="text/javascript"></script>
    <div id="container">
        <div id="nav">
         <%-- Si l'utilisateur existe en session, alors on affiche son username. --%>
        <span class="succes">Welcome  ${sessionScope.con.username} ,</span>
        <a href="#" onclick="getLocation()">My position</a>
        <a href="#">Who s there</a>
        <a href="#">Chat</a>
        <a href="decon?username=${sessionScope.con.username}">Logout</a>
        </div>
        <div id="map"></div>
    </div>
 <script type="text/javascript">
	var map;
	var un='${sessionScope.con.username}';
    function initialize() {
    var mapOptions = {
            center: new google.maps.LatLng(34.7407975, 10.2782034),
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            zoom: 6,
            panControl:false,
            zoomControl:false,
            mapTypeControl:true,
            scaleControl:false,
            streetViewControl:false,
            overviewMapControl:true,
          };	 
    map = new google.maps.Map(document.getElementById("map"), mapOptions);
	}

	
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
		
    } else { 
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    var latitude =position.coords.latitude ;
    var longitude= position.coords.longitude;

    var myLatlng = new google.maps.LatLng(latitude,longitude);
    addMarker2(myLatlng);
    
    envoi(latitude,longitude,un);


  
}
   function addMarker(location) {
        marker = new google.maps.Marker({
            position: location,
            map: map
        });
    }
   
   function addMarker2(location) {
       marker = new google.maps.Marker({
           position: location,
           map: map,
           animation:google.maps.Animation.BOUNCE
       });
   } 
   
   
   function envoi(lat,lon,un)
   {    
	   $.get( 'http://localhost:8080/jee-p/Location?lon='+lon+'&lat='+lat+'&un='+un, function( data ) {
		var others=data;
	     alert(others);

	     
	     var obj=JSON.parse(others);
	 	for(var i=0;i<obj.tab.length;i++)
	 	{myLatlng = new google.maps.LatLng(obj.tab[i].lat,obj.tab[i].lon);
	     addMarker(myLatlng);
	 		
	 	}
	   
	   });
      
   
   
   } 
</script>



</body>
</html>