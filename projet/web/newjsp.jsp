<%-- 
    Document   : newjsp
    Created on : 23 mai 2018, 10:46:58
    Author     : HITMAN
--%>

<%@page import="classes.Patients"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="sse50">
  <div id="sses50">
    <ul>
      <li><a href="?menu=50&skin=1&p=Javascript-Menus">Javascript Menus</a></li>
      <li><a href="?menu=50&skin=1&p=Horizontal-Menus">Horizontal Menus</a></li>
      <li><a href="?menu=50&skin=1&p=Web-Menus">Web Menus</a></li>
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
</style>
<script>
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

        <%
        Patients p =  new Patients(); 
        %>
        <h1><%=p.ListPatient1("yassir").get(0).getId()%></h1>
    </body>
</html>
