<%-- 
    Document   : refresh
    Created on : 24 mai 2018, 17:56:18
    Author     : sarah-lrhezzioui
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="classes.Patient"%>
<%@page import="classes.Patients"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
               form {
    border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
    opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
    width: 40%;
    border-radius: 50%;
}

/* Add padding to containers */
.container {
    padding: 16px;
}

/* The "Forgot password" text */
span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
 
    </style>
     <div id="sse50">
  <div id="sses50">
    <ul>
      <li><a href="Accueil.jsp">Accueil</a></li>
      <li><a href="Nouvel_patient.jsp">Nouvel Patient</a></li>
      <li><a href="Recherche.jsp">Recheche</a></li>
                <li><a class="end">&nbsp;</a></li>
    </ul>
  </div>
</div>
        <style>
        #sse50 
{
    border: solid 1px #39F;
    background:#336699 url(mb50_1_bg.gif) repeat-x;
    padding:0px;/*changing its value will give menu margins to its container*/
    text-align:center;
    border-radius: 4px;
    -moz-border-radius: 4px;
    -webkit-border-radius: 4px;
}
#sses50
{
    margin:0 auto;/*If you don't want the menu center aligned, remove this line and above text-align:center*/
    font-size:0;
} 
        
#sses50 ul, #sses50 li
{
    display: inline;
    list-style-type: none;padding: 0;margin: 0;border:0;background-image:none;
}
        
#sses50 a
{
    text-align: center;
    display: inline-block;
    font: normal 12px Arial;
    background: url('mb50_1.gif') no-repeat left top;
    padding: 10px 20px;/*This defines the size of each menu item*/
    color: white;
    text-decoration: none;
}
        
#sses50 a:hover, #sses50 a.current
{
    background-position: 0% -60px;
    color: white;
}
#sses50 a.end
{
    width:2px;
    padding-left:0;padding-right:0;
}
body{
    background-image:url("C:\Users\sarah-lrhezzioui\Desktop\201709220308-full.jpg");
}
table{
    border: medium solid #000000;
    width: 50%;}
td,th{
    text-align: center;
    border: thin solid #6495ed;
    width: 50%;
}
th{
    background-color: #ffffff;
}
</style>
<script type="text/javascript">
    var sse50 = function () {
    return {
        initMenu: function () {
            var m = document.getElementById('sses50');
            if (!m) return;
            m.style.width = m.getElementsByTagName("ul")[0].offsetWidth + 1 + "px";
            var url = document.location.href.toLowerCase();
            var a = m.getElementsByTagName("a");
            var k = -1;
            var l = -1;
            var hasEnd = 0; 
            for (var i = 0; i < a.length; i++) {
                if (a[i].href && url.indexOf(a[i].href.toLowerCase()) != -1 && a[i].href.length > l) {
                    k = i;
                    l = a[i].href.length;
                }
                if (a[i].className == "end")
                    hasEnd = 1;
            }
            if (k == -1 && /:\/\/(?:www\.)?[^.\/]+?\.[^.\/]+\/?$/.test) {
                for (var i = 0; i < a.length; i++) {
                    if (a[i].getAttribute("maptopuredomain") == "true") {
                        k = i;
                        break;
                    }
                }
                if (k == -1 && a[0].getAttribute("maptopuredomain") != "false")
                    k = 0;
            }
            if (k > -1) {
                a[k].className = 'current';
            }
            l = a.length;
            if (hasEnd) l--;
            for (i = 0; i < l; i++) {
                a[i].onmouseover = function () {
                    for (j = 0; j < l; j++) {
                        a[j].className = '';
                    }
                    this.className = 'current';
                };
                a[i].onmouseout = function () {
                    for (j = 0; j < l; j++) {
                        a[j].className = '';
                        if (k > -1) {
                            a[k].className = 'current';
                        }
                    }
                };
            }
        }
    };
} ();

if (window.addEventListener) {
    window.addEventListener("load", sse50.initMenu, false);
}
else if (window.attachEvent) {
    window.attachEvent("onload", sse50.initMenu);
}
else {
    window["onload"] = sse50.initMenu;
}
</script>
</head>
<body>
    </head>
    <body>
         <div class="container">
             <center><table border="1">
            <tr><th>Id</th><th>Nom</th></tr>
        <%
            Patients p=new Patients();
            ArrayList<Patient> listp=new ArrayList<Patient>( p.ListPatient());
            %>
             
            <%
           for(int i=0;i<listp.size();i++){
            if(listp.get(i).getId()==Integer.parseInt(session.getAttribute("sos").toString())){
                %>
                <tr style="background-color:green;color :white"><td><%=listp.get(i).getId()%></td><td><%=listp.get(i).getNom()%></td></tr>
                <%
            }else{
            %>
          
                <tr><td><%=listp.get(i).getId()%></td><td><%=listp.get(i).getNom()%></td></tr>
             
      <%      }}%>
                 </table></center>
         </div>
    </body>
</html>
