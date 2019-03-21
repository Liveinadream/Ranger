# gradle


```
allprojects {
   repositories {
        maven { url 'https://jitpack.io' }
   }
}
```
```
dependencies {
        implementation 'com.github.Liveinadream:Ranger:1.0.8'
}
```

## 使用

> 需要在 application 中，对 AppManager.context 赋值

## 一些简单的功能

> 界面跳转
```
    viewClick(MainActivity::class.java)
```

> 吐司(已确保在小米设备不提示app名称)

```
    ToastHelper.showToast("创建了一个activity")
```

> 单位转化

```
    1f.dip2px
```

>简单日志打印

```
    log("测试")
```

>view 显示隐藏
```
    view.gone()
```

在 MainActivity 加入了一些示例

如果你有好的意见或建议，可以联系 qq 或者在 issues 中提出。
