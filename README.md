# <center>关于TestNG的学习笔记和测试代码Demo</center>

## 代码结构介绍

- 根目录是父工程，主要用来定义所需要的统一数据
- autotest-with-testng 是测试代码和一些简单的被测试代码
- learning-testng 是关于testng的学习笔记，里面提到的大部分代码示例都在上面的工程中，当然可能会有一部分不一致
- testng-bringback_maven 是testng的maven版的源码，防止以后需要基于源码来做一些适配，当然当前这个工程的测试代码也是基于这个版本代码来运行的。如果不想动源码，则可以把这个目录干掉，然后把父pom文件中的modules去掉它
- 