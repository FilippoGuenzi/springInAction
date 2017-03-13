var model = {};

var templateContent = $('#template').html();
var compiledTemplateFunction = Handlebars.compile(templateContent);
$("#spittleList").html(compiledTemplateFunction(model));
