 package com.example.test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.front.*
import java.lang.NullPointerException

class Front : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.front)


         front_btn_questions.setOnClickListener(object :View.OnClickListener{
             override fun onClick(v: View?) {


                 startActivity(Intent("testapp.secondpage.action"))
             }

         })

        front_btn_rateApp.setOnClickListener{

            try {
                val uri = Uri.parse("market://details?id $packageName")
                val  goToMarket = Intent(Intent.ACTION_VIEW)
                goToMarket.data = uri
                startActivity(goToMarket)
            }
            catch (ex:NullPointerException)
            {
                val uri = Uri.parse("http://play.google.com/store/apps/detalis?id $packageName")
                val  goToMarket = Intent(Intent.ACTION_VIEW)
                goToMarket.data = uri
                startActivity(goToMarket)            }
        }




    }
}