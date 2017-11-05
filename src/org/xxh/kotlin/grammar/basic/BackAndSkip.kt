package org.xxh.kotlin.grammar.basic

/**
 * Created by xiexinhong on 17/7/26.
 * todo 返回与跳转
 */
fun main(args: Array<String>) {
    test()
}

/**
 * Kotlin 有三种结构跳转表达式：
 * -- return
 * -- break 结束最近的闭合循环
 * -- continue 跳到最近的闭合循环的下一次循环
 *
 *
 *
 */


//todo Nothing type
private fun test() {
    var person: Person = Person()
    var s = person.name ?: return
    println("s = $s")
    /**
     * In a language that supports the Elvis operator, something like this:
     * x = f() ?: g()
     * will set x equal to the result of f() if that result is a true value, and to the result of g() otherwise.
     * It is equivalent to this example, using the Ternary Operator:
     * x = f() ? f() : g()
     * except that it does not evaluate the f() twice if it is true.
     */
    //    var sOne = person.name ?: throw IllegalArgumentException("Name required")
}

private class Person {
    var name: String? = null;
}


// todo break 和 continue 标签
//在 Kotlin 中表达式可以添加标签。标签通过 @ 结尾来表示，比如：abc@，fooBar@ 都是有效的(参看语法)。使用标签语法只需像这样：
private fun testLabel() {
    loop@ for (i in 1..5) {

        for (j in 1..5) {
            if (i == 2 && j == 1) {
                //continue@loop
                break@loop
            }

        }
    }
}

//todo 返回到标签 这里理解不是很透彻.
//return 表达式返回到最近的闭合函数
private fun testReturnLabel() {
    var ints = listOf<Int>(1, 2, 3);
    ints.forEach {
        if (it == 2)
            return
        print(it)
    }

    ints.forEach lit@{
        if (it == 2)
            return@lit
        print(it)
    }

    ints.forEach {
        if (it == 2)
            return@forEach
        print(it)
    }

    //当返回一个值时，解析器给了一个参考
    var dog: Dog = Dog();
    var x = 1;
    dog.run { return@run 1 }


}

private class Dog {

    fun run(arg: () -> Int) {
    }
}






