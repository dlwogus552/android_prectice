package org.ljh.myapp001.a01

class User {
    var name="hong"
    constructor(name:String){
        this.name=name
    }
    fun somefun(){
        println("name : $name")
    }
    class someClass{}
}
fun main(){
    val user1=User("Kim")
    user1.somefun()

    val s1 = Student(2,"park","AI")
    s1.some()

    val s2 = User2("lee",10)
    s2.some()

    val user3_1 = User03("kim")
    var user03=User03("lee",20)
    var user04=User03("Hong",20, "1234")

}