var exec = require("cordova/exec");
var XUmeng = {
  init: function (params, success, error) {
    exec(success, error, "XUmengPlugin", "init", params);
  }
};

module.exports = XUmeng;