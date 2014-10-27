var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;
var _ = require('underscore');
var PersonFormView = require('./PersonFormView.js');

var PersonView = Backbone.View.extend({
	template : _.template($('#person-template').html()),
	events : {
		'dblclick tr' : 'onClickRow'
	},
	
	initialize : function(options){
		this.model = options.model;
		this.render();
	},
	render : function(){
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	onClickRow : function(){
		console.log("1");
		var view = new PersonFormView({model : this.model});
		view.render();
	}
});

module.exports = PersonView;