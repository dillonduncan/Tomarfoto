package com.example.tomarfoto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tomarfoto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFoto.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
   private val startForResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
     result:ActivityResult->
       if (result.resultCode == Activity.RESULT_OK){
           val intent = result.data
           val imagenBitMap= intent?.extras?.get("data") as Bitmap
           binding.ivFoto.setImageBitmap(imagenBitMap)
       }
   }

}