package org.ljh.myapp001.a01.a1

import org.ljh.myapp001.a01.a2.Member

fun main() {

    var s1 = Student("kim",20,"ai")
    s1.display()
    var m1 = Member("lee",20,"test")
    m1.display()
    var e1 = Employee("hong",23,"영업",300)
    e1.display()
}