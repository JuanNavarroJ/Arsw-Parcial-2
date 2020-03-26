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
                "</tr>"
            );
        });
    };

    return {
        init: function () {
            api.getStatistics().then(function (data){
            table(data);});
        }

    };
}());