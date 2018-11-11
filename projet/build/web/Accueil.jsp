<%-- 
    Document   : test
    Created on : 21 mai 2018, 21:15:35
    Author     : MYC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Menu vertical parametrable</title>
<script type="text/javascript">

window.onload = affiche;

// ----- Fonction d'affichage des menus -----

function affiche (id) {

var d = document.getElementById(id);

var nbelmenu = 4		// nombre d'éléments dans le menu

for ( var i = 1 ; i <= nbelmenu ; i++ ) {
	if ( document.getElementById('sousmenu'+i) ) {
		document.getElementById('sousmenu'+i).style.display='none';
	}
}
if (d) {
	d.style.display='block';
}
}

</script>

</head>
<body>
<script type="text/javascript">

var fontfamil   = "arial, sans-serif" ;	// choix de la police de caractères du menu
var tailleftmen = "90%" ;				// taille de la police du menu
var fontcolo    = "#FFFFDD" ;			// couleur de la police de caractères du menu
var cellbckgrnd = "#999966" ;			// couleur des cellules du menu
var positionver = 1 ;					// position verticale du menu dans la page
var positionhor = 1 ;					// position horizontale du menu dans la page
var largeurcell = 8 ;					// largeur des cellules du menu
var hauteurcell = 18 ;					// hauteur des cellules du menu
var espacemcell = 6 ;					// espace entre les cellules du menu
var subfontfamil   = "arial, sans-serif" ;	// choix de la police de caractères des sous-menus
var subtailleftmen = "80%" ;				// taille de la police des sous-menus
var subfontcolo    = "blue" ;			// couleur de la police de caractères des sous-menus
var subftsucolo    = "#FFCC00" ;			// couleur de la police de sous-menus survolés
var subcellbckgrnd = "black" ;			// couleur des cellules des sous-menus
var submovcellmenu = "absolute" ;			// "absolute"=sans déplacement des cellules menu ("relative" = avec déplacement)
var subcellposhor  = 3 ;					// position horizontale des cellules des sous-menus
var sublargeurcell = 6 ;					// largeur des cellules des sous-menus
var subhauteurcell = 15 ;					// hauteur des cellules des sous-menus

// creation des styles CSS du menu --->
document.write( "<style type='text/css'>" );

document.write( "#menuvert {position: relative;top: " + positionver + "em;" );
	document.write( "left: " + positionhor + "em;" );
	document.write( "width: " + largeurcell + "em;}" ) ;

document.write( "#menuvert dt {font-family: " + fontfamil + ";" ) ;
	document.write( "font-size: " + tailleftmen + ";color: " + fontcolo + ";" );
	document.write( "text-align: center;background: " + cellbckgrnd + ";" );
	document.write( "cursor: hand;height: " + hauteurcell )
	document.write( "px;margin: " + espacemcell + "px;list-style-type: none;}" );

document.write( "#menuvert dd {background: " + subcellbckgrnd + ";" );
	document.write( "position: absolute;left: " + subcellposhor + "em;" );
	document.write( "margin-top: -1em;width: " + sublargeurcell + "em;}" );

document.write( "#menuvert li {font-family: " + fontfamil + ";" );
	document.write( "font-size: " + subtailleftmen + ";list-style-type: none;" );
	document.write( "height: " + subhauteurcell + "px;}" );

document.write( "#menuvert li a, #menuvert dt a {color: " + subfontcolo + ";" );
	document.write( "text-decoration: none;}" );

document.write( "#menuvert li a:hover {color: " + subftsucolo + ";" );
	document.write( "text-decoration: none;}" );

document.write( "}</style>" );
// FIN des styles CSS

</script>

</head>
<body>
<dl id="menuvert">
	
	<dt onmouseover="javascript:affiche('sousmenu2');" onmouseout="javascript:affiche();">Menu</dt>
		<dd id="sousmenu2" onmouseover="javascript:affiche('sousmenu2');" onmouseout="javascript:affiche();">
			<ul>
				<li><a href="Nouvel_patient.jsp">Nouvel_Patient</a></li>
				<li><a href="Recherche.jsp">Recherche</a></li>
			</ul>
		</dd>

</dl>
</body>
</html>
