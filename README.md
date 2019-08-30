# OfferTerminator Solutions

> OfferTerminator 项目对应的解题代码。

## 项目说明
- 本项目是使用集成开发环境 `IntelliJ Idea` 构建工程项目的，并且每一题以单独 `Module` 立项。下载或者通过 IDE 导入 `Gradle` 工程即可使用。
- 每一题目以 `类` 进行封装，同一题目的解题思路以 `函数` 为实现载体。
- 项目命名规范：来源-序号-题目名称 / 来源-题目名称。

	> 例如：JzOffer-05-ReplaceSpaces、JzOffer-07-RebuildBinaryTree、Leetcode-TwoSum 等。

- 函数命名规范：`驼峰式命名法`

	> 例如：pulbic String rebuildBinaryTree(StringBuffer src){...}

- 项目根目录下 `src/main/java/cn/kofes/util`，用于存放可复用的工具类，它们多数由各 Module 中抽离整理而得。
	- cn.kofes.util.RegexUtils：正则表达式工具集。
- 项目根目录下 `src/main/java/cn/kofes/struct`，用于存放数据结构。

## 测试用例
- 题目的解题算法位于对应 Module 的目录下 `main/java/cn/kofes/code`。
- 本项目中每一题都是使用单元测试框架 Junit 编写测试用例的，测试用例位于对应 Module 的目录下 `test/java/cn/kofes/code`。