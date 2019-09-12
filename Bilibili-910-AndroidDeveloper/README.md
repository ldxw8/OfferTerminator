# Bilibili 2020 届秋季校园招聘

##  Android 方向笔试卷二
### 题目一
- 题目描述：给定字符串 A，找出其中包含的最长连续字符
- 输入描述：输入字符串 A，例如：AAABBBCDDAAAAAACD
- 输出描述：输出最靠前且最长的一个字串，例子里的输入应该输出 AAAAAA

	```
	Input: 
	AAABBBCDDAAAAAACD
	Output: AAAAAA
	```
	> 变形题目：[牛客网. 字符串中找出连续最长的数字串](https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d)

### 题目二
- 题目描述：检索两字符是否有包含或者相等关系
- 输入描述：输入两字符串 s1 s2，例如：ABCCD CD
- 输出描述：若两字符有包含或者相等关系则返回 true；其他情况返回 false

	```
	Input:
	ABCCD
	CD
	Output: true
	```
	
### 题目三
- 题目描述：有 N 件物品和一个容量为 V 的背包。第 i 件物品的价值是 C[i]，重量是 W[i]。求解将哪些物品装入背包可使价值总和最大。
- 输入描述：
	- 输入第一行数目 N V ( 1<= N <= 500 && 1 <= V <= 10000 )
	- 输入 N 行，输入两个数字 C W 代表价值和重量 ( 1<= V <= 50000 && 1 <= V <= 10000 )
- 输出描述：输出最大价值

	```
	Input:
	5 10
	8 6
	10 4
	4 2
	5 4
	5 3
	Output: 19
	```