package org.ljh.myapp001.a01

class Student {
    var sno = 1
    var name:String = "Hong"
    var major:String = "컴공"

    constructor(sno:Int, name:String, major:String){
        this.sno = sno
        this.name = name
        this.major = major
    }
    fun some(){
        println("sno : $sno, name : $name, major : $major")
    }
}