var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;

var PersonCollection = require('./collections/PersonCollection.js');
var PersonCollectionView = require('./views/PersonCollectionView');

var jQhr = $.get('api/persons',function(data){
	var personList = new PersonCollection();
	personList.fetch({"reset": true});
	var personListView = new PersonCollectionView({el: '#contentarea', collection:personList}); 

});
//console.log(personListView.el);