package org.xxh.kotlin.grammar.classandobject

import java.util.*

/**
 * Created by xiexinhong on 17/7/27.
 * todo 字段与属性
 */
fun main(args: Array<String>) {
    var aOne = AddressOne();
    aOne.mPropertyName = "string"
    println(aOne.mPropertyName)
}


//todo var 可读写,val 可读
class Address {
    var name: String = "name"
    var age = 1;
    var street: String? = null;
    //var city: String = null; // Error

    val NAME: String = "xiexinhong"
    val STREET: String? = null
}

/**
 * var <propertyName>: <PropertyType> [ = <property_initializer> ]
 *    <getter>
 *    <setter>
 */
class AddressOne {
    //todo 这里理解不透彻
    var mPropertyName: String?
        public set(str) {
            this.mPropertyName = str
        } public get() {
        return if (this.mPropertyName == null) this.mPropertyName else ""
    }

    var initialized = 1

    var size = 0;

    val isEmpty: Boolean get() = this.size == 0
    //val isEmpty get() = this.size == 0 //1.1版本支持类型推断.
}

//todo 备用字段 不明白这个用来干嘛, 感觉这个set 和 get fun设计得像一坨屎,现在还没看出来他的好处.
//在 kotlin 中类不可以有字段。然而当使用自定义的访问器时有时候需要备用字段。出于这些原因 kotlin 使用 field 关键词提供了自动备用字段，
class AddressTwo {
    var counter = 0 //初始化值会直接写入备用字段.
        set(value) {
            if (value >= 0)
                field = value
            //field 关键词只能用于属性的访问器.
        }

}

//todo 备用属性
private class AddressThree {
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
                return _table ?: throw AssertionError("Set to null by another thread")
            }
            return table;
        }
}

//todo 编译时常量
/**
 * 那些在编译时就能知道具体值的属性可以使用 const 修饰符标记为 编译时常量. 这种属性需要同时满足以下条件:
 * 在top-level声明的 或者 是一个object的成员(Top-level or member of an object)
 * 以String或基本类型进行初始化
 * 没有自定义getter
 */

private object AddressFour {
    const val SUBSYSTEM_DEPERCATED: String = "this subsystem is deprecated"

    @Deprecated(SUBSYSTEM_DEPERCATED)
    fun foo() {

    }
}

//todo 延迟初始化
private class AddressFive {
    /**
     * 这个修饰符只能够被用在类的 var 类型的可变属性定义中,不能用在构造方法中.
     * 并且属性不能有自定义的 getter 和 setter访问器.
     * 这个属性的类型必须是非空的,同样也不能为一个基本类型.
     * 在一个lateinit的属性初始化前访问他,会导致一个特定异常,告诉你访问的时候值还没有初始化.
     *
     */
    lateinit var mVale: String


    //    @SetUp fun setUp() {
    //        mVale = "abc"
    //    }
    //
    //    @Test fun test() {
    //    }

}


