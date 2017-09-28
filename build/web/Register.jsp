<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back3">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registraciona stranica</title>
        <link rel="stylesheet" type="text/css" href="Css/RegistarStilizacija.css">
    </head>
    <body>     
        <div id="register" align="center">
            <form method="post" action="RegistarServlet">
                <table border="1px solid black " style="margin-top:10px">
                    <label>Popunite vase podatke :</label>
                    <tr><td>Ime:</td><td><input type="text" name="ime" placeholder="Unesite ime" required></td></tr>
                    <tr><td>Prezime:</td><td><input type="text" name="prezime" placeholder="Unesite prezime" required></td></tr>
                    <tr><td>Datum rodjenja:</td><td><input type="date" name="datum" placeholder="Unesite datum" required></td></tr>
                    <tr><td>Pol:</td>
                        <td>
                            <input type="radio" name="pol" value="muski" checked> Muski
                            <input type="radio" name="pol" value="zenski"> Zenski
                        </td>
                    </tr>
                    <tr><td>Zemlja:</td><td><select name="zemlja" required>
                                <option value="">--Izaberi zemlju--</option>
                                <option value="Srbija">Srbija</option>
                                <option value="Bosna">Bosna</option>
                                <option value="Makedonija">Makedonija</option>
                                <option value="Hrvatska">Hrvatska</option>
                                <option value="Bugarska">Bugarska</option>
                                <option value="Rumunija">Rumunija</option>
                                <option value="Madjarska">Madjarska</option>
                            </select></td></tr>
                    <tr><td>Korisnicko ime:</td><td><input type="text" name="korime" placeholder="Unesite korisnicko ime" required></td></tr>
                    <tr><td>Sifra:</td><td><input type="password" name="sifra" placeholder="Unesite sifru" required></td></tr>
                    <tr><td>Email adresa:</td><td><input type="email" name="email" placeholder="Unesite emali adresu" required></td></tr>
                    <tr><td>Telefon:</td><td><input type="text" name="telefon" placeholder="Unesite telefon" required></td></tr>
                </table>
                <p>
                    <input type="submit" value="Potvrdi registraciju"> 
                    <input type="reset" value="Resetuj podatke">
                </p>
            </form>       
            <a href="index.html" >Vrati se na pocetnu stranicu</a>
        </div>
    </body>
</html>
