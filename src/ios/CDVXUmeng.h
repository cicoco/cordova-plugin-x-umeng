//
//  CDVXUmeng.h
//
//  Created by 顾九 on 2024/8/9
//
#import <Cordova/CDVPlugin.h>
@interface CDVXUmeng : CDVPlugin

- (void)init:(CDVInvokedUrlCommand*)command;

- (void)registerCrashCallback:(CDVInvokedUrlCommand*)command;

@end
