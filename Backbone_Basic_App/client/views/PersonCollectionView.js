var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;
var PersonView = require('./PersonView.js');

var PersonCollectionView = Backbone.View.extend({
	
	initialize : function(options){
		this.collection=options.collection;
		this.listenTo(this.collection, 'reset', this.render);
	},
	render : function(){
		var that = this;
		var views_el = this.collection.map(function(item){
			return that.renderPerson(item);
		});
		
		this.$el.html(views_el);
		return this;
	},
	renderPerson : function(person){
		var personView = new PersonView({model: person});
		return personView.el;
	}
}); 

module.exports = PersonCollectionView;
