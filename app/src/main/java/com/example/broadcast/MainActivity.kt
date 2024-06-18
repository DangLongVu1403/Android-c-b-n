package com.example.broadcast

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcast.DB.MyDB
import com.example.broadcast.databinding.ActivityMainBinding
import kotlinx.coroutines.processNextEventInCurrentThread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email: String = binding.editTextTextEmailAddress.text.toString()
        val pass: String = binding.editTextTextPassword.text.toString()
        if(email == "dangvu@gmail.com" && pass == "123456"){
            val intent = Intent(this@MainActivity, ListContact::class.java)
            startActivity(intent)
        }
        binding.btn.setOnClickListener {
            val intent = Intent(this@MainActivity, ListContact::class.java)
            startActivity(intent)
        }
        binding.textView2.setOnClickListener {
            val intent = Intent(this@MainActivity, map::class.java)
            startActivity(intent)
        }
        val sharedPref = this.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        binding.editTextTextEmailAddress.setText(sharedPref.getString("email","example@gmail.com"))
        binding.editTextTextPassword.setText(sharedPref.getString("pass",""))
        binding.save.setOnClickListener {
            val editor = sharedPref.edit()
            editor.putString("email", email)
            editor.putString("pass", pass)
            editor.apply()
        }
//        var helper = MyDB(applicationContext)
//        val db = helper.readableDatabase
//        var rs = db.rawQuery("SELECT * FROM Users",null)
//        if (rs.moveToFirst()){
//            Toast.makeText(applicationContext,rs.getString(1), Toast.LENGTH_LONG).show()
//        }
//        val ds = mutableListOf<Taikhoan>()
//        ds.add(Taikhoan("Long Vũ","0326590404","LongVu","123456"))
//        ds.add(Taikhoan("Phan Tuấn","0981197564","Phan Tuan","12345"))
//        ds.add(Taikhoan("a","x","a","123"))
//        ds.add(Taikhoan("v","x","b","1"))
//        ds.add(Taikhoan("c","c","c","c"))
//        binding.btn.setOnClickListener{
//            val userName = binding.editTextTextEmailAddress.text.toString().trim()
//            val passWord = binding.editTextTextPassword.text.toString().trim()
//
//            val success = ds.find {  it.userName == userName && it.passWord == passWord }
//            if (success != null) {
//                Toast.makeText(applicationContext, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
//                Toast.makeText(applicationContext, "Họ tên: ${success.hoTen}", Toast.LENGTH_SHORT).show()
//                Toast.makeText(applicationContext, "Số điện thoại: ${success.soDienThoai}", Toast.LENGTH_SHORT).show()
//            }
//            val failusername = ds.find {  it.userName == userName}
//            if (failusername == null) {
//                Toast.makeText(applicationContext, "Không có tài khoản", Toast.LENGTH_SHORT).show()
//            }else{
//                val failpassword = ds.find {it.passWord == passWord }
//                if (failpassword == null) {
//                    Toast.makeText(applicationContext, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onStart()",Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"onRestart()",Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume()",Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"onPause()",Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop()",Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onDestroy()",Toast.LENGTH_LONG).show()
        Log.d("destroy", "onDestroy() ")
    }
}