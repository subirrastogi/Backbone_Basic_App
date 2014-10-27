var Backbone = require('backbone');
var $ = require('jquery-untouched');
window.jQuery = $;
Backbone.$ = $;
var _ = require('underscore');
var bootstrap = require('../node_modules/bootstrap/dist/js/bootstrap.js');
var Person = require('../models/Person.js');

var FormView = Backbone.View.extend({
	template : _.template($("#person-formview-template").html()),
	el : '#form-view',
	initialize : function(options){
		this.model = (options.model || new Person());
	},
	events : {
		'click #save_person' : 'onClickSave'
	},
	render : function(){
		this.$el.html(this.template(this.model.toJSON()));
		//$("#form-view").modal('show');
		this.$el.modal('show');
		return this;
	},
	onClickSave : function(){
		
	}
	
});

module.exports = FormView;