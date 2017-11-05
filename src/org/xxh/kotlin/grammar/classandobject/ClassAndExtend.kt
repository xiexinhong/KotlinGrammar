package org.xxh.kotlin.grammar.classandobject

import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

/**
 * Created by xiexinhong on 17/7/26.
 */
fun main(args: Array<String>) {

}

//todo 类
/**
 * 包名\访问权限\类头\主体
 */
class Invoice {

}

//主体直接省略
class Empty


//todo 构造函数
private class Person private constructor(firstName: String) {


}

//如果constructor  没有注释or可见性说明可以直接省略
private class PersonOne(firstName: String) {
    var firstName: String = firstName;
}

//主够着函数不能包含任意的代码.初始化可以放在init做浅醉的初始化块类
private class PersonTwo(name: String) {
    var name: String? = null;

    init {
        this.name = name;
        println("ini")
    }
}

//声明属性与赋值 1在内部声明属性的时候赋值,在init块中赋值,属性在构造器上声明
private class PersonThree(var firstName: String, var lastName: String, var age: Int) {

    fun helloConstructor() {
        val buffer = StringBuffer();
        buffer.append(firstName)
                .append(lastName)
                .append(age)
    }
}

//如果构造函数有注解或可见性声明 constructor是必不可少的
private class PersonForth @Inject constructor(name: String) {

}

//二级够着函数 需要加constructor:
private class PersonFive {
    val mPersonOne: PersonOne;

    constructor(parent: PersonOne) {
        mPersonOne = parent
    }
}

//如果类有主构造函数，每个二级构造函数都要，或直接或间接通过另一个二级构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字：
private class PersonSix(val name: String) {

    constructor(name: String, parent: PersonOne) : this(name) {

    }
}

/**
 * 如果一个非抽象类没有声明构造函数(主构造函数或二级构造函数)，它会产生一个没有参数的构造函数。该构造函数的可见性是 public 。
 * 如果你不想你的类有公共的构造函数，你就得声明一个拥有非默认可见性的空主构造函数：
 */
private class PersonSeven private constructor() {

}


/**
 * todo 这里有点不明白.
 * 注意：在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。
 * 这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
 *
 */


//todo 创建类实例.
fun testCreateClassInstance() {
    val personOne = PersonOne("谢");
    val personFive = PersonFive(personOne);
}

//todo 类成员
/**
 * 1.构造函数和初始化代码块儿
 * 2.函数
 * 3.属性
 * 4.内部类
 * 5.对象声明
 */

//todo 继承
//Kotlin 中所有的类都有共同的父类 Any,他是一个没有父类声明的默认父类.
//Kotlin 中所有的类默认情况下都是final的能被继承 需要添加open关键字.
private class Example //隐式继承于 Any

//Any  不是Object 他除了equals(), hashCode(), toString() 没有任何成员
private open class Base(p: Int)

class Derived(p: Int) : Base(p)

/**
 * 如果类有主构造函数，则基类可以而且是必须在主构造函数中使用参数立即初始化。
 * 如果类没有主构造函数，则必须在每一个构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数做这件事。
 * 注意在这种情形中不同的二级构造函数可以调用基类不同的构造方法：
 */
private open class View(str: String)

private class MyView : View {

    constructor(str: String) : super(str) {

    }

    constructor(str: String, int: Int) : super(str) {

    }

}

// todo 复写方法
private open class BaseOne {
    open fun v() {

    }

    fun nv() {

    }
}

private class DerivedOne() : BaseOne() {

    override fun v() {

    }
}
//todo 复写 属性
/**
 * 复写属性与复写方法类似，在一个父类上声明的属性在子类上被重新声明，必须添加override，并且它们必须具有兼容的类型。
 * 每个被声明的属性都可以被一个带有初始化器的属性或带有getter方法的属性覆盖
 */
private open class Foo {
    open var x: Int get():Int {
        return x;
    } set(x: Int) {
        this.x = x
    }

    fun getAbcInt(): Int {
        return 0
    }
}

class Bar1 : Foo() {
    //    override val x: Int = 2;
    //var 复写val 可以反过来不可以
    override var x: Int = 2;
}

//
private interface FooOne {
    val count: Int
}

//使用主够着函数复写属性.
private class BarOne(override val count: Int) : FooOne {

}

//interface的的属性和方都是open的继承需要复写.
private class BarTwo() : FooOne {

    override var count: Int = 0;
}


//todo 复写规则
/**
 * 在 kotlin 中，实现继承通常遵循如下规则：
 * 如果一个类从它的直接父类继承了同一个成员的多个实现，那么它必须复写这个成员并且提供自己的实现(或许只是直接用了继承来的实现)。
 * 为表示使用父类中提供的方法我们用 super<Base>表示:
 */
private open class A {
    open fun f() {
        println("Class A method f")
    }

    fun a() {
        println("a")
    }
}

private interface B {
    fun f() {
        print("Interface B method f")
    }

    fun b() {
        println("b")
    }
}

private class C() : A(), B {

    override fun f() {
        super<A>.f() //调用A.f()
        super<B>.f() //调用B.f()
    }
}

//todo 抽象类
/**
 * 一个类或一些成员可能被声明成 abstract 。一个抽象方法在它的类中没有实现方法。记住我们不用给一个抽象类或函数添加 open 注解，它默认是带着的。
 */

private open class BaseTwo {
    open fun f() {

    }
}

private abstract class AbDerived : BaseTwo() {
    override abstract fun f()
}


// todo 伴随对象.  理解起来很奇怪
/**
 *
 */
private class MyClass {
    companion object Factory {

        fun create(): MyClass = MyClass()
    }
}

private class MyClassOne {
    companion object {
        fun sayHello() {
            println("hello companion obje")
        }
    }

    fun memberFun() {

    }
}

fun testCompanionObj() {
    val x = MyClass.create();
    val y = MyClassOne.Companion;
    y.sayHello()

}


//todo 密封类
/**
 * 密封类用于代表严格的类结构，值只能是有限集合中的某种类型，不可以是任何其它类型。
 * 这就相当于一个枚举类的扩展：枚举值集合的类型是严格限制的，但每个枚举常量只有一个实例，而密封类的子类可以有包含不同状态的多个实例。
 */

public sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val  e1: Expr, val e2: Expr) : Expr()

    object NotANumber : Expr()
}

/**
 * 使用密封类的最主要的的好处体现在你使用 when 表达式。可以确保声明可以覆盖到所有的情形，不需要再使用 else 情形。
 */
fun eval(expr: Expr): Double = when (expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
// the `else` clause is not required because we've covered all the cases
}




