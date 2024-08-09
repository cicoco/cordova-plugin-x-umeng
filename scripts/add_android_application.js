#!/usr/bin/env node
const fs = require("fs");
let commonFuncs = require("./common");

module.exports = function(context) {
    console.log("start to add plugin application");
    var APPLICATION_CLASS = "unic.cicoco.cordova.umeng.MyApplication";
  
    var filePath = commonFuncs.getFilePath(
      "./platforms/android/app/src/main/",
      "AndroidManifest.xml"
    );

    var manifestFile = filePath + "AndroidManifest.xml";
  
    if (fs.existsSync(manifestFile)) {
      console.log("AndroidManifest.xml path: " + manifestFile);
      fs.readFile(manifestFile, 'utf8', function (err, data) {
        if (err) {
          throw new Error('Unable to find AndroidManifest.xml: ' + err);
        }
  
        if (data.indexOf(APPLICATION_CLASS) == -1) {
          var result = data.replace(/<application/g, '<application android:name="' + APPLICATION_CLASS + '"');
          fs.writeFile(manifestFile, result, 'utf8', function (err) {
            if (err) throw new Error('Unable to write into AndroidManifest.xml: ' + err);
          })
        }
      });
    }
  };