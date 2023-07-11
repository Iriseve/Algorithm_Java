# Algorithm_Java

> 闲着没事刷刷题~
>
> 应该会作为长期刷题库使用，主要放一些各个平台的测试代码，方便之后~~复习~~（估计不太可能hhha
>
> 类型和难度瞎写的，仅供菜菜自己参考..
>
> 0-简单
>
> 2-中等(一两眼无思路的)
>
> 4-困难（可能得是无思路+题解都看不太懂的程度hhh）

## 蓝桥杯

### 第11届(2020)JavaB省赛

|                             题目                             |                             代码                             |          类型           | 难度 |                             备注                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :---------------------: | :--: | :----------------------------------------------------------: |
|  [A门牌制作](https://www.lanqiao.cn/problems/592/learning/)  | [门牌制作](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/A.java) |          水题           |  0   |                                                              |
| [B寻找2020](https://www.lanqiao.cn/problems/1065/learning/)  | [寻找2020](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/B.java) |          暴力           |  0   |                       数据小，暴力枚举                       |
|  [C蛇形填数](https://www.lanqiao.cn/problems/594/learning/)  |           [蛇形填数](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/C.java)           |         找规律          |  0   |            找规律，不行自己手画下应该也没什么问题            |
|   [D七段码](https://www.lanqiao.cn/problems/595/learning/)   |            [七段码](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/D.java)            | `并查集` <br/>`暴搜dfs` |  2   | 太恶心啦，不如直接模拟画图排除算了。<br/>用并查集+暴搜可以，但感觉应该有更好的想法？ |
|   [E排序 ](https://www.lanqiao.cn/problems/598/learning/)    |             [排序](shttps://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/E.java)             |          思维           | 0.5  |                                                              |
|  [F成绩分析](https://www.lanqiao.cn/problems/497/learning/)  |           [成绩分析](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/F.java)           |          水题           |  0   |                                                              |
|  [G单词分析](https://www.lanqiao.cn/problems/504/learning/)  |           [单词分析](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/G.java)           |           水            |  0   |                                                              |
| [H数字三角形 ](https://www.lanqiao.cn/problems/505/learning/) |          [数字三角形](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/H.java)          |                         |      |                                                              |
| [I子串分值和 ](https://www.lanqiao.cn/problems/1037/learning/) |          [子串分值和](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/I.java)          |                         |      |                                                              |
|   [J装饰珠](https://www.lanqiao.cn/problems/507/learning/)   |            [装饰珠](https://github.com/Iriseve/Algorithm_Java/blob/master/src/lanqiao/Java2020B/J.java)            |                         |      |                                                              |



## Acwing

### 第88场周赛

|                             题目                             |                     代码                      |        类型        | 难度 |                      备注                      |
| :----------------------------------------------------------: | :-------------------------------------------: | :----------------: | :--: | :--------------------------------------------: |
| [4800.下一个](https://www.acwing.com/activity/content/problem/content/7991/) |   [下一个](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E5%91%A8%E8%B5%9B/No88/T4800.java)   |        枚举        |  0   |               对于重复字符的处理               |
| [4801.强连通图](https://www.acwing.com/problem/content/4804/) |  [强连通图](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E5%91%A8%E8%B5%9B/No88/T4801.java)  |        思维        |  2   | 别一看到连通两个字就上图论算法，可以先模拟模拟 |
| [4802.金明的假期](https://www.acwing.com/problem/content/4805/) | [金明的假期](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E5%91%A8%E8%B5%9B/No88/T4802.java) | `DP` <br/>`状态机` |  2   |                   注意初始化                   |

### 每日一题

|                             题目                             |                         代码                         |          类型           | 难度 |                             备注                             |
| :----------------------------------------------------------: | :--------------------------------------------------: | :---------------------: | :--: | :----------------------------------------------------------: |
| [3956.截断数组](https://www.acwing.com/problem/content/3959/) |  [截断数组](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E6%AF%8F%E6%97%A5%E4%B8%80%E9%A2%982023%E6%98%A5%E5%AD%A3/T3956.java)  |     `前缀和` `枚举`     |  1   | 第一刀和第二刀唯一相关联的地方就是**第一刀一定在第二刀前面**<br/>除此之外，由于总和固定，所以**分区和也固定**，所以切的地方只要和分区和相等就说明可以在这里切 |
| [3502.不同路径数](https://www.acwing.com/problem/content/3505/) | [不同路径数](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E6%AF%8F%E6%97%A5%E4%B8%80%E9%A2%982023%E6%98%A5%E5%AD%A3/T3502.java) |          `DFS`          |  1   |     DFS简化版，因为题目说了可以重复走，所以记录表都省了      |
| [1497. 树的遍历](https://www.acwing.com/problem/content/1499/) |  [树的遍历](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E6%AF%8F%E6%97%A5%E4%B8%80%E9%A2%982023%E6%98%A5%E5%AD%A3/T1497.java)  | `递归` `BFS` `树的遍历` |  2   |                                                              |
|  [3777. 砖块](https://www.acwing.com/problem/content/3780/)  |    [砖块](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E6%AF%8F%E6%97%A5%E4%B8%80%E9%A2%982023%E6%98%A5%E5%AD%A3/T3777.java)    |         `递推`          |  1   |                                                              |

## 模板题

> 基本都是些模板题，就不写难度了

|                             题目                             |                      代码                       |  类型  | 备注 |
| :----------------------------------------------------------: | :---------------------------------------------: | :----: | :--: |
| [835.Trie字符串统计](https://www.acwing.com/problem/content/837/) | [Trie字符串统计](https://github.com/Iriseve/Algorithm_Java/blob/master/src/acwing/%E7%AE%97%E6%B3%95%E5%9F%BA%E7%A1%80/T835.java) | `Trie` |      |

## 洛谷

|                             题目                             |                代码                |           类型           | 难度 |                             备注                             |
| :----------------------------------------------------------: | :--------------------------------: | :----------------------: | :--: | :----------------------------------------------------------: |
| [P8809 [蓝桥杯 2022 国 C] 近似 GCD](https://www.luogu.com.cn/problem/P8809) | [近似GCD](https://github.com/Iriseve/Algorithm_Java/blob/master/src/JavaClub/exercise01/P8808.java) | `前缀和` `双指针` `二分` | 1.5  | 学会将问题抽象简化。<br/>求连续子数组的个数，该子数组内的元素最多只能一个不是g的倍数。 |



## leetcode

|                             题目                             |                            代码                             |      类型       | 难度 |
| :----------------------------------------------------------: | :---------------------------------------------------------: | :-------------: | :--: |
| [2404. 出现最频繁的偶数元素 - 力扣（LeetCode）]((https://leetcode.cn/problems/most-frequent-even-element/)) | [出现最频繁的偶数元素 - 力扣](https://github.com/Iriseve/Algorithm_Java/blob/master/src/leetcode/easy/T2404.java) | `哈希表` `计数` | easy |

### 面试高频题分类刷题

> 参考题单 [Leetcode面试高频题分类刷题总结 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/349940945) 

|                             题目                             |                   代码                    |     类型      | 难度 |
| :----------------------------------------------------------: | :---------------------------------------: | :-----------: | :--: |
| [148. 排序链表 - 力扣（LeetCode）](https://leetcode.cn/problems/sort-list/) | [测试代码](https://github.com/Iriseve/Algorithm_Java/blob/master/src/leetcode/medium/T148.java) | `排序` `链表` | 中等 |

