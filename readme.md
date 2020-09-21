# 基于po模式开发

包目录说明
- basepage包：负责存放公用的操作方法
- execption包：统一异常处理
- listener包:报告生成监听器
- page包：元素定位和元素的数据配置
    - element：各个元素定位方法封装
    - data ：XPath数据来源和数据配置
- testcase包:负责用例维护执行操作方法（操作方法数据源来自元素层的方法）
- utils包:工具类

![](https://upload-images.jianshu.io/upload_images/16753854-9cf6efdcea2f16cd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)