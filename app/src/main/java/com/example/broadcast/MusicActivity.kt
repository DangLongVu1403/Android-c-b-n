package com.example.broadcast

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.broadcast.Adapter.Adapter_list_contact
import com.example.broadcast.Adapter.Adapter_list_music
import com.example.broadcast.databinding.ActivityMusicBinding
import com.example.broadcast.`interface`.RecyclerViewOnClick

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ds = mutableListOf<music>()
        ds.add(music("Mơ","Vũ Cát Tường","",))
        ds.add(music("thu","Vũ","",))
        ds.add(music("hạ","Tường","",))
        ds.add(music("xuân","a","",))
        ds.add(music("đông","av","",))
        ds.add(music("hi","Vnm","",))

        val adapter = Adapter_list_music(ds,object : RecyclerViewOnClick {
            override fun onClickItem(pos: Int){
                val music = ds[pos]
                val intent = Intent(this@MusicActivity, InformationMusicActivity::class.java )
                intent.putExtra("nameSong", music.nameSong)
                intent.putExtra("author", music.author)
                intent.putExtra("link", music.link)
                startActivity(intent)
            }
        })
        val listHistory = binding.rvMusic
        listHistory.adapter = adapter
        listHistory.layoutManager = LinearLayoutManager(this)
        listHistory.setHasFixedSize(true)
    }
}