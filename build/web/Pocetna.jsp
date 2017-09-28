<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back2">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dobrodosli</title>
        <link rel="stylesheet" type="text/css" href="Css/PocetnaStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
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
            <div id="log"><h4>Ulogovani kao:<%=session.getAttribute("koris")%>.<div id="sat"></div></h4>  </div>         
            <div class="scrollmenu">
                <a href="Pocetna.jsp">Pocetna</a>
                <a href="KorisnikInformacije.jsp">Korisnicke informacije</a>
                <a href="oglasUlogovan.jsp" >Oglasi</a>
                <a href="DodajOglas.jsp">+dodaj oglas</a>
                <a href="MojiOglasi.jsp">Moji oglasi</a>          
                <a href="logout.jsp" align="right">Odjavite se</a>             
            </div>
            <br/>     
        </div>
    </body>
</html>
