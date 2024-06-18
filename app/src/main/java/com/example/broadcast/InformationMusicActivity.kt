package com.example.broadcast

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcast.databinding.ActivityInformationMusicBinding

class InformationMusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationMusicBinding
    private var mediaPlayer: MediaPlayer? = null
    private var baiHat: music? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInformationMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val NameSong = intent.getStringExtra("nameSong")
        val Author = intent.getStringExtra("author")
        val Link = intent.getStringExtra("link")
        binding.nameSong.setText(NameSong)
        binding.author.setText(Author)

        baiHat?.let {

            val id = this.resources.getIdentifier("xyz", "raw", this.packageName)
            mediaPlayer = MediaPlayer.create(this, id)

            binding.btnPlayPause.setOnClickListener {
                mediaPlayer?.let { player ->
                    if (player.isPlaying) {
                        player.pause()
                        binding.btnPlayPause.text = "Play"
                    } else {
                        player.start()
                        binding.btnPlayPause.text = "Pause"
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}