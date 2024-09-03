#import "CDVXUmeng.h"
#import <UMCommon/UMCommon.h>
#import <UMAPM/UMCrashConfigure.h>
#import <UMAPM/UMAPMCustomLog.h>

@implementation CDVXUmeng

- (void) init:(CDVInvokedUrlCommand*) command
{
    NSDictionary* infoDict = [[NSBundle mainBundle] infoDictionary];
    NSString* appKey = [infoDict objectForKey:@"UmengAppKey"];
    NSString* channel = [infoDict objectForKey:@"UmengChannel"];
    [UMConfigure initWithAppkey:appKey channel:channel];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void) registerCrashCallback:(CDVInvokedUrlCommand*) command
{
    [UMCrashConfigure setCrashCallBackBlock:^NSString * _Nullable(UMCrashType type) {
        [UMAPMCustomLog eTag:@"CDVXUmeng" msg:[NSString stringWithFormat:@"CRASH:%@", [command.arguments description]]];
        return @"Crash";
    }];
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
