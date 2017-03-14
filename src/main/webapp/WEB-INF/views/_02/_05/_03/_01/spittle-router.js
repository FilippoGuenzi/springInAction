$(
    function () {
        var Router = Backbone.Router.extend({
            routes: {
                '*spittles': 'spittleApp'
            },
            spittleApp: function (params) {
                console.log(params);
            }
        });

        var myRouter = new Router();
        Backbone.history.start();
    }
);
