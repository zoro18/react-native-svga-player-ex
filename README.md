# react-native-svga-player-ex

## Getting started

`$ npm install react-native-svga-player-ex --save`

### Mostly automatic installation

`$ react-native link react-native-svga-player-ex`

## Usage
```javascript
import SvgaPlayerEx from 'react-native-svga-player-ex';

// TODO: What to do with the module?
SvgaPlayerEx;

<SvgaPlayerEx
    style={{width: 400, height: 400}}
    source={`http://jssdynamic.oss-cn-shenzhen.aliyuncs.com/%E8%B7%91%E8%BD%A6.svga`}
/>

```

### V1.0.2
*** 在项目的AndroidManifest.xml添加如下
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools"
  package="com.senon.modularapp">
```

*** 在 application 添加allowBackup
` <application 下增加tools:replace="android:allowBackup"  android:allowBackup="false" > `
