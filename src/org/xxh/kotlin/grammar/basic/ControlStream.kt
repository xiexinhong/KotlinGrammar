package org.xxh.kotlin.grammar.basic

import com.sun.tools.javac.jvm.Items
import org.xxh.kotlin.grammar.basic.package_.parseInt

/**
 * Created by xiexinhong on 17/7/26.
 * todo  控制流
 */

fun main(args: Array<String>) {
    testFor()
}


//todo
//在 Kotlin 中，if 是表达式，它可以返回一个值。因此Kotlin没有三元运算符(condition ? then : else),因为if语句已经满足了效果。

fun testIfOne(a: Int, b: Int) {
    var max = a;
    if (a < b)
        max = b;

    //带 else
    var maxOne: Int
    if (a > b)
        maxOne = a
    else
        maxOne = b
    //作为表达式
    val maxTwo = if (a > b) a else b;

    //分支块
    val maxThree = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }


    if (a > b) {
        println("a > b")
    } else if (a < b) {
        println("a < b")
    } else {
        println("a = b")
    }
}

//todo When 表达式
// when 取代了 C 风格语言的 switch 。最简单的用法像下面这样
fun testWhen(x: Int) {
    //用作控制
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 1")
        else -> {
            print("x is neither i nor 2")
        }
    }

    //用作表达式 此时else是强制的.
    var result = when (x) {
        1 -> 1 * 10
        else -> {
            x;
        }
    }

    //多分支连接在一起.
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }


    //可以用任意表达式作为分支条件
    when (x) {
        parseInt("0") -> println("s encode x")
        getIntFun("xx", 12.12) -> println("getIntFun");
        else -> println("s does not encode x")
    }

    //甚至可以用in 或者!in检查值是否在一个范围或者一个集合中.
    var validNumbers = arrayOf(-1, -2)
    when (x) {
        in 1..10 -> println("x is in the 1..10 range")
        in validNumbers -> println("x is valid")
        in 10..20 -> println("x is in the 10..20 range")
        else -> println("none of the above")
    }

    //也可以用is 或者!is来办端某个值的类型.
    val tmpS = "1";
    val hasPrefix = when (tmpS) {
        is String -> tmpS.startsWith("prefix")
        else -> false
    }

    //when 也可以用来代替 if-else if 。如果没有任何参数提供，那么分支的条件就是简单的布尔表达式，当条件为真时执行相应的分支：
    when {
        (x > 0) -> println("x > 0")
        (x < 0) -> println("x < 0")
        else -> print("x is == 0")
    }

}

fun getIntFun(arg1: String, arg2: Double): Int? {
    return 1;
}

//todo for循环
private fun testFor() {
    val items = arrayListOf<String>("a", "b", "c")

    for (item in items)
        print("$item ")
    println()
    //语句块儿
    for (item in items) {
        print("$item ")
    }

    //for支持对任何提供迭代器进行迭代.


    //对List 或 array 尽心索引迭代.
    val arrayZero = Array<String>(3, { it -> "$it" })
    for (i in arrayZero.indices) {
        print("arrayZeror[$i] = ${arrayZero[i]}")
    }
    println();

    //在没有其它对象创建的时候 "iteration through a range " 会被自动编译成最优的实现。todo 有点不明白意思
    //或者，您可以使用withIndex库函数
    for ((index, value) in arrayZero.withIndex()) {
        println("the element at $index is $value")
    }

}

//todo while
private fun testWhile() {
    var x = 1;
    while (x > 0) {
        x--;
    }

    do {
        val y = retrieveData();
    } while (y != null) //y在这里是可见的.
}

private fun retrieveData(): Int? {
    return null
}


//todo 在循环中是用break 和continue

