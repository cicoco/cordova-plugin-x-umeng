## 安装
```
cordova plugin add cordova-plugin-x-umeng --variable UMENG_ANDROID_KEY=友盟官网AndroidKey --variable UMENG_IOS_KEY=友盟官网iOSKey --variable UMENG_CHANNEL_VALUE=自定义渠道信息，不能用unknown
```

## 使用
1. init方法
```
// 在获取隐私协议授权后调用, 初始化框架
cordova.plugins.XUmeng.init(
  [],
  (successData: string) => {
    console.error('success', successData, params)
  },
  (errorData: string) => {
    console.error('failed', errorData, params)
  }
)
```
2. 崩溃后自定义日志
```
// 按需调用，用于crash后追加的自定义日志，error级别，内容为: CRASH: ${params}, params定义如下
const params = [{
    // crash时打印的信息，建议放用户信息，比如 {userId: 1, userName: ""}
}]

cordova.plugins.XUmeng.registerCrashCallback(
  params,
  (successData: string) => {
    console.error('success', successData, params)
  },
  (errorData: string) => {
    console.error('failed', errorData, params)
  }
)
```

