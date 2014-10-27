var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;
var _ = require('underscore');
Backbone.Obscura = require('backbone.obscura');
var PersonView = require('./PersonView.js');
var PersonFormView = require('./PersonFormView.js');

var PersonCollectionView = Backbone.View.extend({
	
	template : _.template($('#person-collection').html()),
	initialize : function(options){
		this.collection=options.collection;
		this.proxy = new Backbone.Obscura(this.collection);
		this.proxy.setPerPage(5);
		this.render();
		this.listenTo(this.proxy, 'reset', this.update);
	},
	events : {
		'click #prev' : 'onClickPrev',
		'click #next' : 'onClickNext',
		'clck #new_person' : 'newPerson'
	},
	render : function(){
		this.$el.html(this.template);
		
		//this.$el.html(views_el);
		return this;
	},
	
	update : function(){
		var that = this;
		var views_el = this.proxy.map(function(item){
			return that.renderPerson(item);
		});
		this.$el.find('#person_list').html(views_el);
		return this;
	},
	renderPerson : function(person){
		var personView = new PersonView({model: person});
		return personView.el;
	},
	onClickPrev : function(){
		if(this.proxy.hasPrevPage()){
			this.proxy.prevPage();
		}
	},
	onClickNext : function(){
		if(this.proxy.hasNextPage()){
			this.proxy.nextPage();
		}
	},
	newPerson : function(){
		var view = new PersonFormView();
		view.render();
	}
}); 

module.exports = PersonCollectionView;
