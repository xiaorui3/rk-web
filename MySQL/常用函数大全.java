package java代码.MySQL;

public class 常用函数大全 {
    /**
     * MySql函数大全
     *
     *
     * MySQL数据库提供了很多函数包括：
     *
     * 数学函数
     * 字符串函数 //mysql中处理字符串时，默认第一个字符下标为1，即参数position必须大于等于1
     * 日期和时间函数
     * 条件判断函数
     * 系统信息函数
     * 加密函数
     * 格式化函数
     * 1. 数学函数
     * 函数	说明
     * abs(x)	返回x的绝对值
     * ceil(x)	返回大于或等于x的最小整数,select ceil(1.5) --返回2
     * floor(x)	返回小于或等于x的最大整数,SELECT FLOOR(1.5) -- 返回1
     * rand()	返回0->1的随机数,select rand() --0.93099315644334
     * sign(x)	返回x的符号，x是负数、0、正数分别返回-1、0和1
     * pi()	返回圆周率(3.141593）
     * truncate(x,y)	返回数值x保留到小数点后y位的值
     * round(x)	返回离x最近的整数 ,SELECT ROUND(1.23456) --1
     * round(x,y)	保留x小数点后y位的值，但截断时要进行四舍五入,SELECT ROUND(1.23456,3) -- 1.235
     * power(x,y)	返回x的y次方,select power(2,3) -- 8
     * sqrt(x)	返回x的平方根,,select sqrt(25) --5
     * exp(x)	返回e的x次方
     * mod(x,y)	返回x除以y以后的余数,select mod(5,3) --2
     * 2. 字符串函数
     * 函数	说明
     * char_length(s)	返回字符串s的字符数,SELECT CHAR_LENGTH('你好123') -- 5
     * length(s)	返回字符串s的长度,SELECT LENGTH('你好123') -- 9
     * concat(s1,s2)	将字符串s1,s2等多个字符串合并为一个字符串
     * concat_ws(x,s1,s2)	同CONCAT(s1,s2,...)函数，但是每个字符串直接要加上x
     * upper(s)	将字符串s的所有字母变成大写字母
     * lower(s)	将字符串s的所有字母变成大写字母
     * left(s,n)	返回字符串s的前n个字符
     * right(s,n)	返回字符串s的后n个字符
     * repeat(s,n)	将字符串s重复n次
     * space(n)	返回n个空格
     * replace(s,s1,s2)	将字符串s2替代字符串s中的字符串s1
     * strcmp(s1,s2)	比较s1,s2,返回的值为-1,0,1
     * substring(s,n,len)	获取从字符串s中的第n个位置开始长度为len的字符串
     * reverse(s)	将s字符串反转
     * load_file(file_name)	读入文件并作为一个字符串返回文件内容
     * 3. 日期和时间函数
     * 函数	说明
     * curdate()	返回当前时间的年月日
     * curtime()	返回当前时间的时分秒
     * now()	返回当前时间的日期和时间
     * month(d)	返回日期d中的月份值
     * monthname(d)	返回日期当中的月份名称，如Janyary
     * dayname(d)	返回日期d是星期几，如Monday,Tuesday
     * dayofweek(d)	日期d今天是星期几，1星期日，2星期一
     * from_unixtime(10位时间戳)	将unix时间戳转换为2017-03-24 11:15:05的格式
     * unix_timestamp()	以UNIX时间戳的形式返回当前时间
     * week(d)	计算日期d是本年的第几个星期，范围是0->53
     * dayofmonth(d)	计算日期d是本月的第几天
     * dayofyear(d)	计算日期d是本年的第几天
     * quarter(d)	返回日期d是第几季节，返回1->4
     * hour(d)	返回d中的小时值
     * minute(d)	返回d中的分钟值
     * second(d)	返回d中的秒钟值
     * datediff(d1,d2)	计算日期d1->d2之间相隔的天数
     * adddate(d,n)	计算日期d加上n天的日期
     * subdate(d,n)	日期d减去n天后的日期
     * 4. 条件判断
     * 函数	说明
     * if(expr,v1,v2)	select if(1 > 0,'正确','错误')
     * ifnull(v1,v2)	如果v1的值不为NULL，则返回v1，否则返回v2。
     * case语法:
     * 第一种,CASE表示函数开始，END表示函数结束。如果e1成立，则返回v1,如果e2成立，则返回v2，当全部不成立则返回vn，而当有一个成立之后，后面的就不执行了
     *
     * CASE
     * 　　WHEN e1
     * 　　THEN v1
     * 　　WHEN e2
     * 　　THEN e2
     * 　　...
     * 　　ELSE vn
     * END
     * 第二种,如果表达式expr的值等于e1，返回v1；如果等于e2,则返回e2。否则返回vn。
     *
     * CASE expr
     * 　　WHEN e1 THEN v1
     * 　　WHEN e1 THEN v1
     * 　　...
     * 　　ELSE vn
     * END
     * 5. 系统信息函数
     * 函数	说明
     * version	返回数据库的版本号
     * connection_id()	返回服务器的连接数
     * user()	返回当前用户
     * last_insert_id()	返回最近生成的AUTO_INCREMENT值
     * 6. 加密函数
     * 函数	说明
     * password(str)	对str字符串进行加密
     * md5(str)	MD5(str)函数可以对字符串str进行散列，可以用于一些普通的不需要解密的数据加密
     * sha(str)	sha加密
     * sha1(str)	sha1加密
     * encode(str,key)和decode(str,key)	使用key作为密钥加密解密字符串str,这两函数是一对的,,加密和解密,非常值得注意的是对应字段用blob类型
     * 7. 其他
     * 函数	说明
     * convert(s using utf8)	将s字符串转换成utf8
     */
}
