package org.xxh.kotlin.grammar.basic.package_


/**
 * Created by xiexinhong on 17/7/24.
 *
 */


/**
 * 默认导入
-- kotlin.*
-- kotlin.annotation.*
-- kotlin.collections.*
-- kotlin.comparisons.* (since 1.1)
-- kotlin.io.*
-- kotlin.ranges.*
-- kotlin.sequences.*
-- kotlin.text.*

一些附加包会根据平台来决定是否默认导入：
-- JVM:
---- java.lang.*
---- kotlin.jvm.*
-- JS:
---- kotlin.js.*
 */


/**
 * imports 导入
 * 1.import org.xxh.kotlin.grammar.*; 这个只能放在文件的开头.
 * 2.导入冲突. as 关键字局部命名冲突解决.
 *
 */

import org.xxh.kotlin.grammar.basic.package_.one.Bar as OneBar
import org.xxh.kotlin.grammar.basic.package_.two.Bar as TwoBar
// todo 函数的导入????


/**
 * 代码文件的所有内容(比如类和函数)都被包含在包声明中。因此在上面的例子中， bza() 的全名应该是 foo.bar.bza ，Goo 的全名是 foo.bar.Goo。
 * 如果没有指定包名，那这个文件的内容就从属于没有名字的 "default" 包。
 */

fun bza() {

}

class Goo {

}










