package org.xxh.kotlin.grammar.basic

import sun.jvm.hotspot.utilities.IntArray

/**
 * Created by xiexinhong on 17/7/25.
 */

fun main(args: Array<String>) {
    testString("abc")
}

/**
 * Double   64
 * Float	32
 * Long 	64
 * Int	    32
 * Short	16
 * Byte	    8
 */


//todo 支持进制与默认表示
val mByte = 'A'
val mShort: Short = 1 // 这个默认表示还不知道.

val mDecimalInt = 123
val mDecimalLong = 123L
val mHexadecimal = 0xAB
val mBinary = 0b101010
//kotlin 不支持8进制
val mDouble = 123.5
val mFloat = 123.5F //float类型需要在末尾添加F or f

//数值常亮中可以添加下划线分割(1.1版本中新添加的)
//val oneMillion = 1_000_000
//val creditCardNumber = 123_5678_9012_3456L

//todo 表示
fun show() {
    val a: Int = 10000
    println(a === a)
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA)

    val tranA: Int? = 1
    //val tranB: Long? = tranA;
    //低精度类型不是高精度类型的子类 如果是就麻烦了不仅特征会丢失,有时候连值相等都会悄悄消失.
    val b: Byte = 1
    //val i: Int = b //Error
    val i: Int = b.toInt();
    //每个数值类型都支持所有数值类型的转换.

    //隐式转换一般情况下是不容易被发觉的，因为我们使用了上下文推断出类型，并且算术运算会为合适的转换进行重载，
    val l = 1.toLong() + 1 // Long + Int => Long
}

//todo 运算符
fun operationSymbol() {
    //1.支持标准的运算符
    //2.移位运算.
    val x = (1 shl 2) and 0x000FF00
    //shl(bits) – 有符号左移 (相当于 Java’s <<)
    // shr(bits) – 有符号右移 (相当于 Java’s >>)
    // ushr(bits) – 无符号右移 (相当于 Java’s >>>)
    // and(bits) – 按位与
    // or(bits) – 按位或
    // xor(bits) – 按位异或
    // inv(bits) – 按位翻转
}

// todo 字符
//字符类型用 Char 表示。不能直接当做数值来使用
fun testChar() {
    var c = 'a';
    //    if(c == 1) { ERROR
    //
    //    }
    //显示的将字符转化为Int;
    var cInt: Int = c.toInt();
}

//todo 布尔值
// 只有true 和 false
fun testBool(): Boolean? {

    //如果需要一个可空引用，将会对布尔值装箱
    return true;
}
//布尔值的内建操作包括
//|| – 短路或
//&& – 短路与
//! - 取反

// todo 数组
fun testArray() {
    // 创建一个 Array<String>  内容为 ["0", "1", "4", "9", "16"]
    val asc = Array<String>(5, { i -> (i * i).toString() })
    println(asc.get(1))
    println(asc.set(1, "abc"))
    println(asc.size)

    //    Kotlin 有专门的类来表示原始类型从而避免过度装箱： ByteArray, ShortArray, IntArray 等等。这些类与 Array 没有继承关系，但它们有一样的方法与属性。每个都有对应的库函数：
    val x: kotlin.IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2];
}

//todo 字符串

fun testString(s: String) {
    for (c in s) {
        println(c)
    }

    if (s.length > 1) {
        println(s[1]);
    }

    //字符串字面值
    //带转义
    val s = "Hello world! \n" // 和java很像
    //""" 包含,是可以包含新行以及任意文本的。不可以包含转移符但可以包含其它字符
    val txt = """
    for(c in "foo") {
        print(c)
     }
    """
    println("c = $txt")

    //函数移除空格
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    //字符串摸版
    //符串可以包含模板表达式，即可求值的代码片段，并将其结果连接到字符串中。模板表达式由 $ 开始并包含另一个简单的名称：
    val i= 10;
    val str = "i = $i"
    //或者一个带大括号的表达式
    val strOne = "abc"
    val strTwo = "$s.length is ${s.length}"
    //摸版也可以在""" """中使用
    val price = """ ${'$'}9.99 """
}






