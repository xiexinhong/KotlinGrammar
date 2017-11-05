package org.xxh.kotlin.grammar.basic.package_

/**
 * Created by xiexinhong on 17/7/24.
 */

//todo 定义函数

fun main(args: Array<String>) {
    useLambda();
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

//只有一个表达式的函数
fun sum(a: Float, b: Float) = a + b;

//返回一个没有意义的值
fun sumReturnUnit(a: Int, b: Int): Unit {
    println("sun of$a and $b is ${a + b}");
}

//todo 定义局部变量.

//todo 只读变量
val mA: Int = 1;
val mBInt = 2; //Int类型是自动推断
val mBStr = "Hello" //String类型自动推断

/*  不能直接定义属性,必须初始化.
 *  val c:Int;
 *  c = 2;
*/

fun declareVal() {
    val c: Int;
    c = 2;
}

//todo 可变变量
var mX = 5;

fun changeX() {
    mX++;
}

// todo
// 注释一行

/**
 * 多行注释
 */

// todo 条件表达式.
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

fun maxOfSingleLine(a: Int, b: Int) = if (a > b) a else b;


//todo 使用可空变量以及空值检查, 后面单独研究;
fun parseInt(str: String): Int? {
    return str.toInt()
}

fun parseIntOrNull(str: String): Int? {
    return null; // str.toIntOrNull();
}

fun printlnProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1);
    val y = parseInt(arg2);
    if (x != null && y != null) {
        println(x * y);
    } else {
        println("either $arg1 or $arg2 is not  a number")
    }
}

//todo 使用值检查以及自动转换.
fun getStringLength(obj: Any): Int? {

    if (obj is String) {
        // obj 将会在这个分支中自动转换为 String 类型
        return obj.length;
    }
    return null;

    //类型自动转换
    //    if(obj !is String) return null;
    //    // obj 将会在这个分支中自动转换为 String 类型
    //    return obj.length;

    //类型自动转换
    //    if(obj is String &&  obj.length > 0) {
    //        return obj.length;
    //    }
    //    return null;
}


//todo 使用for循环
fun useForRecycler() {
    val items = listOf<String>("apple", "banana", "kiwi")
    for (item in items) {
        println(item);
    }

    for (index in items.indices) {
        println("item as $index is ${items[index]}");
    }
}


//todo 使用while循环
fun useWhile() {
    val items = listOf<String>("apple", "banana", "kiwi");
    var index = 0;
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++;
    }
}


//todo 使用ranges
fun useRanges() {
    val x = 10;
    val y = 9;
    if (x in 1..y + 1) {
        println("fits in range")
    } else {
        println("fits not in range")
    }
}

//检查数值在范围内.
fun useRangesOne() {
    val list = listOf<String>("a", "b", "c");
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

// 使用范围内部迭代
fun useRangeTwo() {
    for (x in 1..5) {
        print("$x ")
    }
    println()

    for (x in 1..10 step 2) {
        print("$x ")
    }
    println()

    for (x in 9 downTo 0 step 3) {
        print("$x ");
    }
}


//todo 使用集合
fun useConnection() {
    val items = listOf<String>("apple", "orange", "banana")
    for (item in items) {
        print("$item ")
    }
    println()
    when {
        "apple" in items -> println("apple in items")
        "abc" in items -> println("apple in items")
    }
}

//lambda 表达式
fun useLambda() {
    val fruits = listOf<String>("apple", "orange", "banana", "appleOne")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}


