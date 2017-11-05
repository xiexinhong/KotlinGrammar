package org.xxh.kotlin.grammar.classandobject

/**
 * Created by xiexinhong on 17/7/28.
 * todo 可见性修饰词
 * 那些东西具有可见性 类，对象，接口，构造函数，属性以及它们的 setter 方法都可以有可见性修饰词。( getter与对应的属性拥有相同的可见性)
 *
 * 可见性修饰词 private,protected,internal(同一个模块module中可见),以及 public 。默认的修饰符是 public
 */

//包

//如果你复写了一个protected成员并且没有指定可见性，那么该复写的成员具有protected可见性

//todo 类和接口
private open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // 默认是public

    protected class Nested {
        public val e: Int = 5
    }
}

private class Subclass : Outer() {
    // a不可见
    // b,c和d是可见的
    // 内部类和e都是可见的

    override val b = 5   // 'b' i具有protected可见性
}

private class Unrelated(o: Outer) {
    // o.a, o.b 不可见
    // o.c and o.d 可见 (same module)
    // Outer.Nested 不可见, and Nested::e 也不可见
}

//构造函数
private class TmpC