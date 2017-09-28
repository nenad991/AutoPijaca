$(document).ready(function ()
{
    var Alfa = [
        {display: "145", value: "1"},
        {display: "146", value: "2"},
        {display: "147", value: "3"},
        {display: "156", value: "4"},
        {display: "159", value: "5"},
        {display: "164", value: "6"},
        {display: "166", value: "7"},
        {display: "Brera", value: "8"},
        {display: "Giulietta", value: "9"},
        {display: "GT", value: "10"}
    ];
    var Audi = [
        {display: "80", value: "11"},
        {display: "90", value: "12"},
        {display: "100", value: "13"},
        {display: "A 3", value: "14"},
        {display: "A 4", value: "15"},
        {display: "A 5", value: "16"},
        {display: "A 6", value: "17"},
        {display: "A 8", value: "18"},
        {display: "Q 5", value: "19"},
        {display: "Q 7", value: "20"}
    ];
    var Bentley = [
        {display: "Continental", value: "21"},
        {display: "Bentayga", value: "22"},
        {display: "Mulsanne", value: "23"}
    ];
    var Bmw = [
        {display: "Serija 1", value: "24"},
        {display: "Serija 2", value: "25"},
        {display: "Serija 3", value: "26"},
        {display: "Serija 4", value: "27"},
        {display: "Serija 5", value: "28"},
        {display: "Serija 6", value: "29"},
        {display: "Serija 7", value: "30"},
        {display: "X-3", value: "31"},
        {display: "X-5", value: "32"},
        {display: "X-6", value: "33"}
    ];
    var Chervrolet = [
        {display: "Aveo", value: "34"},
        {display: "Camaro", value: "35"},
        {display: "Cruze", value: "36"},
        {display: "Impala", value: "37"},
        {display: "Kalos", value: "38"},
        {display: "Matiz", value: "39"},
        {display: "Nubira", value: "40"}
    ];
    var Citroen = [
        {display: "C 1", value: "41"},
        {display: "C 2", value: "42"},
        {display: "C 3", value: "43"},
        {display: "C 4", value: "44"},
        {display: "C 5", value: "45"},
        {display: "C 6", value: "46"},
        {display: "Saxo", value: "47"},
        {display: "Xantia", value: "48"},
        {display: "Xsara", value: "49"}
    ];
    var Dacia = [
        {display: "Duster", value: "50"},
        {display: "Logan", value: "51"},
        {display: "Sandero", value: "52"},
        {display: "Solenza", value: "53"},
        {display: "Stepway", value: "54"}
    ];
    var Fiat = [
        {display: "500", value: "55"},
        {display: "500L", value: "56"},
        {display: "Bravo", value: "57"},
        {display: "Doblo", value: "58"},
        {display: "Marea", value: "59"},
        {display: "Punto", value: "60"},
        {display: "Stilo", value: "61"},
        {display: "Tipo", value: "62"}
    ];
     var Ford = [
        {display: "Escort", value: "63"},
        {display: "Fiesta", value: "64"},
        {display: "Focus", value: "65"},
        {display: "Ka", value: "66"},
        {display: "Mondeo", value: "67"},
        {display: "Mustang", value: "68"},
        {display: "Maverick", value: "69"}
    ];
     var Honda = [
        {display: "Accord", value: "70"},
        {display: "Civic", value: "71"},
        {display: "HR-V", value: "72"},
        {display: "Jazz", value: "73"},
        {display: "Prelude", value: "74"}    
    ];
      var Hyundai = [
        {display: "Atos", value: "75"},
        {display: "Elantra", value: "76"},
        {display: "i-30", value: "77"},
        {display: "i-40", value: "78"},
        {display: "Santa Fe", value: "79"}    
    ];
      var Jaguar = [
        {display: "S-Type", value: "80"},
        {display: "X-Type", value: "81"},
        {display: "XJ", value: "82"},
        {display: "XK", value: "83"}       
    ];
     var Jeep = [
        {display: "Cherokee", value: "84"},
        {display: "Compass", value: "85"},
        {display: "Renegade", value: "86"},
        {display: "Wrangler", value: "87"}  
    ];
    var Kia = [
        {display: "Rio", value: "88"},
        {display: "Spectra", value: "89"},
        {display: "Sportage", value: "90"}      
    ];
    var Lada = [
        {display: "1600", value: "91"},
        {display: "2105", value: "92"},
        {display: "2107", value: "93"},
        {display: "Niva", value: "94"},
        {display: "Riva", value: "95"}
    ];
    var Lexus = [
        {display: "GS 300", value: "96"},
        {display: "IS 200", value: "97"},
        {display: "IS 220", value: "98"},
        {display: "LS 400", value: "99"},
        {display: "LS 400", value: "100"}
    ];
    var Mazda = [
        {display: "323", value: "101"},
        {display: "929", value: "102"},
        {display: "CX-3", value: "103"},
        {display: "CX-5", value: "104"},
        {display: "MX-3", value: "105"},
        {display: "MX-5", value: "106"},
        {display: "RX-8", value: "107"}
    ];
    var Mercedes = [
        {display: "A klasa", value: "108"},
        {display: "B klasa", value: "109"},
        {display: "C klasa", value: "110"},
        {display: "CE klasa", value: "111"},
        {display: "CLA klasa", value: "112"},
        {display: "E klasa", value: "113"},
        {display: "G klasa", value: "114"},       
        {display: "ML klasa", value: "115"}
    ];
    var Mitshubishi = [
        {display: "Carisma", value: "116"},
        {display: "Colt", value: "117"},
        {display: "Galant", value: "118"},
        {display: "Lanser", value: "119"},
        {display: "Pajero", value: "120"}
    ];
   var Nissan = [
        {display: "350Z", value: "121"},
        {display: "Juke", value: "122"},
        {display: "Navara", value: "123"},
        {display: "Patriot", value: "124"},
        {display: "Skyline", value: "125"}
    ];
    var Opel = [
        {display: "Ascona", value: "126"},
        {display: "Astra", value: "127"},
        {display: "Calibra", value: "128"},
        {display: "Corsa", value: "129"},
        {display: "Frontera", value: "130"},
        {display: "Kadett", value: "131"},
        {display: "Omega", value: "132"},
        {display: "Rekord", value: "133"}
    ];
    var Peugeot = [
        {display: "306", value: "134"},
        {display: "307", value: "135"},
        {display: "406", value: "136"},
        {display: "407", value: "137"},
        {display: "504", value: "138"},
        {display: "Panter", value: "139"}
    ];
     var Porshe = [
        {display: "911", value: "140"},
        {display: "924", value: "141"},
        {display: "Boxter", value: "142"},
        {display: "Cayenne", value: "143"},
        {display: "Panamera", value: "144"}
    ];
     var Renault = [
        {display: "Clio", value: "145"},
        {display: "Kangoo", value: "146"},
        {display: "Laguna", value: "147"},
        {display: "Megane", value: "148"},
        {display: "R-4", value: "149"},
        {display: "R-5", value: "150"}
    ];
     var Rover = [
        {display: "25", value: "151"},
        {display: "45", value: "152"},
        {display: "75", value: "153"},
        {display: "825", value: "154"}
    ];
     var Saab = [
        {display: "900", value: "155"},
        {display: "9-3", value: "156"},
        {display: "9-5", value: "157"}
    ];
    var Smart = [
        {display: "ForFour", value: "158"},
        {display: "ForTwo", value: "159"},
        {display: "Roadster", value: "160"}
    ];
    var Suzuki = [
        {display: "Splash", value: "161"},
        {display: "Swift", value: "162"},
        {display: "Vitara", value: "163"}
    ];
     var Skoda = [
        {display: "Fabia", value: "164"},
        {display: "Favorit", value: "165"},
        {display: "Octavia", value: "166"},
        {display: "Superb", value: "167"},
        {display: "Yeti", value: "168"}
    ];
       var Toyota = [
        {display: "Auris", value: "169"},
        {display: "Celica", value: "170"},
        {display: "Rav-4", value: "171"},
        {display: "Supra", value: "172"},
        {display: "Yaris", value: "173"}
    ];
       var Volkswagen = [
        {display: "Bora", value: "174"},
        {display: "Buba", value: "175"},
        {display: "Golf", value: "176"},
        {display: "Jetta", value: "177"},
        {display: "Passat", value: "178"},
        {display: "Polo", value: "179"},
        {display: "Touareg", value: "180"}
    ];
       var Volvo = [
        {display: "C 70", value: "181"},
        {display: "S 60", value: "182"},
        {display: "S 70", value: "183"},
        {display: "V 40", value: "184"},
        {display: "V 60", value: "185"},
        {display: "XC 90", value: "186"}
    ];
      var Zastava = [
        {display: "Florida", value: "187"},
        {display: "Skala", value: "188"},
        {display: "Yugo", value: "189"}
    ];
    $("#marka").change(function ()
    {
        var select = $("#marka option:selected").val();
        switch (select)
        {
            case "1":
                model(Alfa);
                break;
            case "2":
                model(Audi);
                break;
            case "3":
                model(Bentley);
                break;
            case "4":
                model(Bmw);
                break;
            case "5":
                model(Chervrolet);
                break;
            case "6":
                model(Citroen);
                break;
            case "7":
                model(Dacia);
                break;
            case "8":
                model(Fiat);
                break;
            case "9":
                model(Ford);
                break;
            case "10":
                model(Honda);
                break;
            case "11":
                model(Hyundai);
                break;
            case "12":
                model(Jaguar);
                break;
            case "13":
                model(Jeep);
                break;
            case "14":
                model(Kia);
                break;                
            case "15":
                model(Lada);
                break;
            case "16":
                model(Lexus);
                break;
            case "17":
                model(Mazda);
                break;
            case "18":
                model(Mercedes);
                break;
            case "19":
                model(Mitshubishi);
                break;
            case "20":
                model(Nissan);
                break;
            case "21":
                model(Opel);
                break;
            case "22":
                model(Peugeot);
                break;
            case "23":
                model(Porshe);
                break;
            case "24":
                model(Renault);
                break;
            case "25":
                model(Rover);
                break;
            case "26":
                model(Saab);
                break;
            case "27":
                model(Smart);
                break;
            case "28":
                model(Suzuki);
                break;               
            case "29":
                model(Skoda);
                break;
            case "30":
                model(Toyota);
                break;
            case "31":
                model(Volkswagen);
                break;
            case "32":
                model(Volvo);
                break;
            case "33":
                model(Zastava);
                break;
            default:
                $("#model").empty();
                $("#model").append("<option>--izaberi--</option>");
                break;
        }
    }
    );
    function model(arr) {
        $("#model").empty();
        $("#model").append("<option>--izaberi model--</option>");
        $(arr).each(function (i) {
            $("#model").append("<option value=\"" + arr[i].value + "\">" + arr[i].display + "</option>");
        });
    }
});