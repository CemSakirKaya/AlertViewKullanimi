package com.example.alertviewkullanm

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertviewkullanm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNormal.setOnClickListener(){
            val ad = AlertDialog.Builder(this@MainActivity)
            ad.setIcon(R.drawable.baseline_assist_walker_24)
            ad.setTitle("Uyarı")
            ad.setMessage("Message")
            ad.setPositiveButton("TAMAM"){ dialogInterface,i ->
                Toast.makeText(this@MainActivity,"Tamam tıklandı",Toast.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İPTAL"){ dialogInterface,i ->
                Toast.makeText(this@MainActivity,"İptal tıklandı",Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }

        binding.buttonOzel.setOnClickListener(){
            val tasarım= layoutInflater.inflate(R.layout.tasarim,null)
            val editTextAlert = tasarım.findViewById(R.id.editTextAlert) as EditText


            val ad = AlertDialog.Builder(this@MainActivity)
            ad.setIcon(R.drawable.baseline_assist_walker_24)
            ad.setTitle("Uyarı")
            ad.setMessage("Message")
            ad.setView(tasarım)
            ad.setPositiveButton("KAYDET"){ dialogInterface,i ->
                val alınanveri = editTextAlert.text.toString()
                Toast.makeText(this@MainActivity,"Alınan veri : $alınanveri alındı ",Toast.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İPTAL"){ dialogInterface,i ->
                Toast.makeText(this@MainActivity,"İptal tıklandı",Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }
    }
}