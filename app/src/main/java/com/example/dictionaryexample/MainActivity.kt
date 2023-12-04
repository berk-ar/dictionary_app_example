package com.example.dictionaryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dictionaryexample.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val kelime = binding.searchEt.text.toString()
            getKelimeler(kelime)
        }
    }

    private fun kelimelerUi(response: KelimeRes) {
        binding.kelimeTv.text = response.word
        binding.kelimeOkuTv.text = response.phonetic
    }

    private fun getKelimeler(kelime: String) {
        GlobalScope.launch {
            val resp = RetrofitInstance.dictionaryApi.getKelimeler(kelime)
            runOnUiThread {
                resp.body()?.first()?.let {
                    kelimelerUi(it)
                }
            }
        }
    }
}