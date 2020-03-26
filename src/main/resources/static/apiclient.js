apiclient = (function() {
    return {
        getStatistics: function() {
            var getPromise=$.ajax({
                dataType: "json",
                url: "/stats",
            });
            return getPromise;
        }
    };
})();