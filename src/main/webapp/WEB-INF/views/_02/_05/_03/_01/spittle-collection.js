$(
    function(){
        window.app = window.app || { };
        window.app.SpittleList = Backbone.Collection.extend({
            model: window.app.spittleModel
        });
        window.app.spittleList = new window.app.SpittleList();
    }
);
