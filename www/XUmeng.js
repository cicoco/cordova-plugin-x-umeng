var exec = require("cordova/exec");
var XUmeng = {
  init: function (params, success, error) {
    exec(success, error, "XUmengPlugin", "init", params);
  },
  registerCrashCallback: function (params, success, error) {
    exec(success, error, "XUmengPlugin", "registerCrashCallback", params);
  }
};

module.exports = XUmeng;