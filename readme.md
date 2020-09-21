# 基于po模型开发

包目录说明
- basepage包：负责存放公用的操作方法
- execption包：统一异常处理
- listener包:报告生成监听器
- page包：元素定位和元素的数据配置
    - element：各个元素定位方法封装
    - data ：XPath数据来源和数据配置
- testcase包:负责用例维护执行操作方法（操作方法数据源来自元素层的方法）
- utils包:工具类

![图片](https://coding-net-production-file-ci.codehub.cn/4010e3c0-fbe6-11ea-92c1-a78e190bc322.png?sign=BsAjcLLsi1Z+Y7inwW3ild4/5DhhPTEyNTcyNDI1OTkmaz1BS0lEYXk4M2xGbWFTNlk0TFRkek1WTzFTZFpPeUpTTk9ZcHImZT0xNjAwODkzODIwJnQ9MTYwMDY3NzgyMCZyPTMyMzM3Nzg5JmY9LzQwMTBlM2MwLWZiZTYtMTFlYS05MmMxLWE3OGUxOTBiYzMyMi5wbmcmYj1jb2RpbmctbmV0LXByb2R1Y3Rpb24tZmlsZQ==)