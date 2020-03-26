apiclient = (function() {
    return {
        getStatistics: function() {
            var getPromise=$.ajax({
                dataType: "json",
                url: "/stats",
            });
            return getPromise;
        },
        getCountries: function(name) {
            var getPromise=$.ajax({
                dataType: "json",
                url: "/stats/"+name,
            });
            return getPromise;
        }
    };
})();