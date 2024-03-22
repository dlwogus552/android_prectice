package org.ljh.myapp001.a01.a3
//데이터 전달목적으로 쓰임
data class DataClass(val name:String, val email:String, val age:Int){
    lateinit var address:String
    constructor(name:String, email:String, age:Int, address:String):this(name,email,age){
        this.address=address
    }
}
