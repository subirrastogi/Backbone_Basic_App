var Backbone = require('backbone');

var Person = Backbone.Model.extend({
	idAttribute : 'pid',
	defaults :{
		name : '',
		dob : '',
		address : '',
		city : '',
		country : ''
	}
});

module.exports = Person;