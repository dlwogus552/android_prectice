package org.ljh.databaseapp

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.databaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = openOrCreateDatabase("test_db", Context.MODE_PRIVATE, null)
        var tableName = binding.editText.text.toString()
        binding.btnCreateTable.setOnClickListener {
            try {
                val sql = """
                create table ${tableName} (
                _id integer primary key autoincrement,
                name not null,
                phone)
            """.trimIndent()
                db.execSQL(sql)
                binding.textView.append("${tableName}이 생성되었습니다.")
            }catch (e:Exception){e.printStackTrace()}
        }
        binding.btnInsert.setOnClickListener{
            val sql = "insert into $tableName (name,phone) values(?,?)"
            db.execSQL(sql, arrayOf("홍길동","010-1234-5678"))
            val values = ContentValues()
            values.put("name","ddd")
            values.put("phone","010-8765-4321")
            db.insert(tableName,null,values)

            binding.textView.append("\n데이터 저장")
        }
        binding.btnSelect.setOnClickListener{
            val sql = "select * from ${tableName}"
            val cursor=db.rawQuery(sql,null)
            while (cursor.moveToNext()){
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                binding.textView.append("\n이름 : $name, 번호 : $phone")
            }
        }
        binding.btnDelete.setOnClickListener{
            val sql = "delete from ${tableName} where _id=?"
            db.execSQL(sql, arrayOf(1))
            binding.textView.append("\n데이터 삭제")
        }
        binding.btnDrop.setOnClickListener{
            val sql = "drop table ${tableName}"
            db.execSQL(sql)
        }
        binding.btnUpdate.setOnClickListener{
            val sql = "update ${tableName} set name=?, phone=? where _id=?"
            db.execSQL(sql, arrayOf("hong","010-1111-2222",2))
            binding.textView.append("\n데이터 수정")

        }


    }
}