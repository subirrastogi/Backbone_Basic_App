var Backbone = require('backbone');
var Person = require('../models/Person.js');
var PersonCollection = Backbone.Collection.extend({
	url : 'api/persons',
	model : Person
});

module.exports = PersonCollection;