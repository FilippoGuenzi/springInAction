$(
    function () {
        window.app = window.app || { };
        window.app.Router = Backbone.Router.extend({
            routes: {
                '*spittles': 'spittleApp'
            },
            spittleApp: function () {
                console.log(arguments);
            }
        });

        window.app.router = new window.app.Router();
        Backbone.history.start();
    }
);
