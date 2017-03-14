$(
    function () {

        var model = {
            spittleList: [
                {id: 1, message: '1st message', time: 'time 1', latitude: 'lat 1', longitude: 'long 1'}
                , {id: 2, message: '2nd message', time: 'time 2', latitude: 'lat 2', longitude: 'long 2'}
            ]
        };

        var templateContent = $('#template').html();
        var compiledTemplateFunction = Handlebars.compile(templateContent);
        $("#spittleList").html(compiledTemplateFunction(model));
    }
);
