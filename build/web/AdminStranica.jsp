<%-- 
    Document   : AdminStranica
    Created on : Jun 16, 2017, 5:22:06 PM
    Author     : NenadIvana
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back2">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin stranica</title>
        <link rel="stylesheet" type="text/css" href="Css/PocetnaStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/InformacijeStilizacija.css">
        <script src='https://code.jquery.com/jquery-3.1.0.min.js'></script>
        <script src="JS/JsPocetna.js" ></script>
          <script>
            window.history.forward();
            function noBack()
            {
                window.history.forward();
            }
        </script>
    </head>
    <body onload="vreme()" onload="noBack();"
          onpageshow="if (event.persisted) noBack();" onunload="">
        <div class='fadein'>
            <div id="log"> <h4>Ulogovani kao:<%=session.getAttribute("koris")%>.<div id="sat"></div></h4> </div>          
            <div class="scrollmenu">
                <a href="AdminStranica.jsp">Pocetna</a>
                <a href="Oglasi.jsp" target="_blank">Oglasi</a>
                <a href="logout.jsp" align="right">Odjavite se</a> 
            </div>
            <br/>
            <div id='info' align='center'>
                <h4>Dodaj boju:</h4>
                <form method="post" action="AdminServlet">
                    <input type="text" name="boja" placeholder="Primer 'Bela'" required>
                    <br/>
                    <input type="submit" value="Dodaj boju" required>
                </form>
                <br/>
                <h4>Dodaj godiste:</h4>
                <form method="post" action="AdminServlet">
                    <input type="text" name="god" placeholder="Primer '2008 god'" required>
                    <br/>
                    <input type="submit" value="Dodaj godiste">
                </form>
                <h4>Dodaj registrovan do:</h4>
                <form method="post" action="AdminServlet">
                    <input type="text" name="reg" placeholder="Primer 'do 10.2017'" required>
                    <br/>
                    <input type="submit" value="Dodaj registrovan do">
                </form>  
            </div>
        </div>
    </body>
</html>
