package com.example.actividadfullstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividadfullstack.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var binding: ActivityMainBinding
private lateinit var adapter: Adapter
private val mortyimages = mutableListOf<String>()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
    adapter = Adapter(mortyimages)
    binding.rvinicio.layoutManager = LinearLayoutManager(this)
        binding.rvinicio.adapter= adapter

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/character/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun visualizar(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getData("https://rickandmortyapi.com/api/character")
            val result = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val image:List<String> = result?.images
                    mortyimages.clear()
                    mortyimages.addAll(image)

                }
            }
        }
    }
}