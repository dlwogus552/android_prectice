package org.ljh.myapp001.a01.a1

open class Person(protected var name: String,protected var age: Int) {
    init {
        this.name=name
        this.age=age
    }
    open fun display(){
        println("name:$name,age:$age")
    }
}

class Student(name:String, age: Int, var major:String):Person(name,age){
    override fun display() {
        println("name:$name,age:$age,major:$major")
    }
}

class Employee(name:String, age: Int, var dept:String, var sal:Int):Person(name,age){
    override fun display(){
        super.display()
        println("sal:$sal,deplt:$dept")
    }
}