package org.xxh.kotlin.grammar.classandobject

/**
 * Created by xiexinhong on 17/7/28.
 * todo 接口
 */
/**
 * Kotlin 的接口很像 java 8。
 * 1.它们都可以包含抽象方法，以及方法的实现。
 * 2.和抽象类不同的是，接口不能保存状态。
 * 3.可以有属性但必须是抽象的，或者提供访问器的实现。
 * interface MyInterface {
 *      fun bar()
 *      fun foo() {
 *          //函数体是可选的
 *      }
 * }
 */

interface MyInterface {
    val property: Int //abstract

    val propertyWithImplementation: String get() = "foo"

    fun foo() {
        print(property)
    }
}

private class Child : MyInterface {
    var name: String = "abc"
        get() {
            return field.toUpperCase();
        }
        set(name) {
            field = "Name: $name"
        }

    override val property: Int
        get() = 12


}

fun main(args: Array<String>) {
    var child = Child()
    println("child.property = ${child.property}")

    println("child.age = ${child.name}")
    child.name = "xiexinhong"
    println("child.age = ${child.name}")
}

//todo 解決重写冲突
/**
 * super<[interface name]>
 */
interface AInterface {
    fun foo() {
        println("A")
    }

    fun bar()
}

interface BInterface {
    fun foo() {
        println("B")
    }

    fun bar() {
        println("bar")
    }
}

private class CClass : AInterface {
    override fun bar() {
        println("bar")
    }
}

private class CClassOne : AInterface, BInterface {

    override fun bar() {
        super<BInterface>.bar()
        println("bar")
    }

    override fun foo() {
        super<AInterface>.foo();
        super<BInterface>.foo()
        println("foo")
    }


}



