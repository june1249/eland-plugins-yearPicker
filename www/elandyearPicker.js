
var exec = require('cordova/exec');

var PLUGIN_NAME = 'YearPicker';

var YearPickerPlugin = {
  launch_app: function(sucess, failure) {
    exec(sucess, failure, PLUGIN_NAME, 'year', []);
  }
};

module.exports = YearPickerPlugin;
