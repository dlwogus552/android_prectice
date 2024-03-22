package org.ljh.myapp001.a4

fun main() {
    var map = mapOf<String,Int>(Pair("kim",80),"lee" to 85)
    println(map.get("kim"))
    println(map.get("lee"))
    println(map.keys)
    println(map.values)
//    map.put 안됨
//    map.set 안딤

    var map1 = mutableMapOf<String, Int>()
    map1["kim"]=85
    map1["lee"]=80
    map1.put("park",85)
    map1.set("hong",80)
    map1.set("kim",70)
    map1["lee"]=70

    println(map1.toString())

}