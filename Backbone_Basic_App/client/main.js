var Backbone = require('backbone');
var $ = require('jquery-untouched');
Backbone.$ = $;

var PersonCollection = require('./collections/PersonCollection.js');
var PersonCollectionView = require('./views/PersonCollectionView');

var personList = new PersonCollection();
personList.fetch({"reset": true});

var personListView = new PersonCollectionView({el: '#person_list', collection:personList}); 
console.log(personListView.el);