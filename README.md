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

## 蓝桥

### 第11届(2020)JavaB省赛

|                             题目                             |                    代码                    |          类型           | 难度 |                             备注                             |
| :----------------------------------------------------------: | :----------------------------------------: | :---------------------: | :--: | :----------------------------------------------------------: |
|  [A门牌制作](https://www.lanqiao.cn/problems/592/learning/)  |  [门牌制作](src/lanqiao/Java2020B/A.java)  |          水题           |  0   |                                                              |
| [B寻找2020](https://www.lanqiao.cn/problems/1065/learning/)  |  [寻找2020](src/lanqiao/Java2020B/B.java)  |          暴力           |  0   |                       数据小，暴力枚举                       |
|  [C蛇形填数](https://www.lanqiao.cn/problems/594/learning/)  |  [蛇形填数](src/lanqiao/Java2020B/C.java)  |         找规律          |  0   |            找规律，不行自己手画下应该也没什么问题            |
|   [D七段码](https://www.lanqiao.cn/problems/595/learning/)   |   [七段码](src/lanqiao/Java2020B/D.java)   | `并查集` <br/>`暴搜dfs` |  2   | 太恶心啦，不如直接模拟画图排除算了。<br/>用并查集+暴搜可以，但感觉应该有更好的想法？ |
|   [E排序 ](https://www.lanqiao.cn/problems/598/learning/)    |    [排序](src/lanqiao/Java2020B/E.java)    |          思维           | 0.5  |                                                              |
|  [F成绩分析](https://www.lanqiao.cn/problems/497/learning/)  |  [成绩分析](src/lanqiao/Java2020B/F.java)  |          水题           |  0   |                                                              |
|  [G单词分析](https://www.lanqiao.cn/problems/504/learning/)  |  [单词分析](src/lanqiao/Java2020B/G.java)  |           水            |  0   |                                                              |
| [H数字三角形 ](https://www.lanqiao.cn/problems/505/learning/) | [数字三角形](src/lanqiao/Java2020B/H.java) |                         |      |                                                              |
| [I子串分值和 ](https://www.lanqiao.cn/problems/1037/learning/) | [子串分值和](src/lanqiao/Java2020B/I.java) |                         |      |                                                              |
|   [J装饰珠](https://www.lanqiao.cn/problems/507/learning/)   |   [装饰珠](src/lanqiao/Java2020B/J.java)   |                         |      |                                                              |



## Acwing

### 第88场周赛

|                             题目                             |                     代码                      |        类型        | 难度 |                      备注                      |
| :----------------------------------------------------------: | :-------------------------------------------: | :----------------: | :--: | :--------------------------------------------: |
| [4800.下一个](https://www.acwing.com/activity/content/problem/content/7991/) |   [下一个](src/acwing/周赛/No88/T4800.java)   |        枚举        |  0   |               对于重复字符的处理               |
| [4801.强连通图](https://www.acwing.com/problem/content/4804/) |  [强连通图](src/acwing/周赛/No88/T4801.java)  |        思维        |  2   | 别一看到连通两个字就上图论算法，可以先模拟模拟 |
| [4802.金明的假期](https://www.acwing.com/problem/content/4805/) | [金明的假期](src/acwing/周赛/No88/T4802.java) | `DP` <br/>`状态机` |  2   |                   注意初始化                   |

## 每日一题

|                             题目                             |                         代码                         |      类型       | 难度 |                             备注                             |
| :----------------------------------------------------------: | :--------------------------------------------------: | :-------------: | :--: | :----------------------------------------------------------: |
| [3956.截断数组](https://www.acwing.com/problem/content/3959/) |  [截断数组](src/acwing/每日一题2023春季/T3956.java)  | `前缀和` `枚举` |  1   | 第一刀和第二刀唯一相关联的地方就是**第一刀一定在第二刀前面**<br/>除此之外，由于总和固定，所以**分区和也固定**，所以切的地方只要和分区和相等就说明可以在这里切 |
| [3502.不同路径数](https://www.acwing.com/problem/content/3505/) | [不同路径数](src/acwing/每日一题2023春季/T3502.java) |      `DFS`      |  1   |     DFS简化版，因为题目说了可以重复走，所以记录表都省了      |
|                                                              |                                                      |                 |      |                                                              |



## 模板题

> 基本都是些模板题，就不写难度了

|                             题目                             |                      代码                       |  类型  | 备注 |
| :----------------------------------------------------------: | :---------------------------------------------: | :----: | :--: |
| [835.Trie字符串统计](https://www.acwing.com/problem/content/837/) | [Trie字符串统计](src/acwing/算法基础/T835.java) | `Trie` |      |
|                                                              |                                                 |        |      |
|                                                              |                                                 |        |      |

