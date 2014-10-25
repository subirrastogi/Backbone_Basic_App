var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;
var _ = require('underscore');

var PersonView = Backbone.View.extend({
	template : _.template($('#person-template').html()),
	
	initialize : function(options){
		this.model = options.model;
		this.render();
	},
	render : function(){
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});

module.exports = PersonView;