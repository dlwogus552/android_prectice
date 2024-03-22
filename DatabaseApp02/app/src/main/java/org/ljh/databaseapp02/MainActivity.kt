package org.ljh.databaseapp02

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.databaseapp.DBHelper
import org.ljh.databaseapp02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener{
            db=DBHelper(this).writableDatabase
            val name=binding.editTextText.text.toString()
            val phone=binding.editTextText2.text.toString()

            val values=ContentValues()
            values.put("name",name)
            values.put("phone",phone)
            db.insert("todo_tb",null,values)
            binding.textView.append("입력")
        }
        binding.btnSelect.setOnClickListener{
            val sql="select * from todo_tb"
            db=DBHelper(this).readableDatabase
            var cursor = db.rawQuery(sql,null)
            while (cursor.moveToNext()){
                var name = cursor.getString(1)
                var phone = cursor.getString(2)
                binding.textView.append("이름 : $name, 번호 : $phone")
            }
        }


    }
}