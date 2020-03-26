var api = apiclient;
var Module = (function () {

    function table(result) {
        $("#stats > tbody").empty();
        result.map(function (country) {
            $("#stats > tbody").append(
                "<tr> <td>" +
                country.country +
                "</td>" +
                "<td>" +
                country.deaths +
                "</td> " +
                "<td>" +
                country.confirmed +
                "</td> " +
                "<td>" +
                country.recovered +
                "</td>" +
                "<td>" +
                "<form><button class='btn btn-dark' type='button' onclick='Module.getCountries(\"" +
            country.country+ "\""+ ")' > Ver </button></form>"+
                "</td> " +
                "</tr>"
            );
        });
        $("button").click(function() {
        $('html,body').animate({
            scrollTop: $(".secundaria").offset().top},
            'slow');
    });
    };
    
    function tableCountry(result) {
        $("#statsRegion > tbody").empty();
        result.map(function (region) {
            $("#statsRegion > tbody").append(
                "<tr> <td>" +
                region.keyId +
                "</td>" +
                "<td>" +
                region.deaths +
                "</td> " +
                "<td>" +
                region.confirmed +
                "</td> " +
                "<td>" +
                region.recovered +
                "</td>" +
                "</tr>"
            );
        });
    };

    return {
        init: function () {
            api.getStatistics().then(function (data){
            table(data);});
        },
        getCountries: function (name) {
            api.getCountries(name).then(function (data){
            tableCountry(data);});
        }

    };
}());