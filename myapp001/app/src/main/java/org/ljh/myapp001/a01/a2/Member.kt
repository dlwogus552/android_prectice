package org.ljh.myapp001.a01.a2

import org.ljh.myapp001.a01.a1.Person

class Member(name:String, age:Int,var id:String):Person(name,age) {
    override fun display() {
        super.display()
        println("name:$name, age:$age, id:$id")
    }
}