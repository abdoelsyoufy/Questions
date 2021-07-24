package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.second.*
import java.util.*

class Second : AppCompatActivity() {
     private var questions:Array<String>?=null
     private var answers:Array<String>?=null
     private var counter:Int = 0
    private var TtoSpeach:TextToSpeech?=null
    private var langResult:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) 
        setContentView(R.layout.second)

        TtoSpeach = TextToSpeech(this,object :TextToSpeech.OnInitListener{
            override fun onInit(status: Int) {
               langResult =  TtoSpeach!!.setLanguage(Locale.ENGLISH)
            }

        })

        questions = resources.getStringArray(R.array.Questions)
        answers = resources.getStringArray(R.array.Answers)
        val size:Int = answers!!.size


        second_tv_questionsSize.text = "/" + size.toString()
        second_tv_counter.text = (counter+1).toString()

        second_tv_question.text = questions!![counter]

        second_btn_back.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (counter>0)
                {
                    counter--
                    second_tv_question.text = questions!![counter]
                    second_tv_counter.text = (counter+1).toString()
                    second_tv_answer.text = resources.getString(R.string.press_a_button_for_answer)


                }
            }

        })

        second_btn_next.setOnClickListener{
            if (counter<size -1)
            {
                counter++
                second_tv_question.text = questions!![counter]
                second_tv_counter.text = (counter+1).toString()
                second_tv_answer.text = resources.getString(R.string.press_a_button_for_answer)

            }
        }

         second_btn_answer.setOnClickListener{
             second_tv_answer.text = answers!![counter]
         }

        second_btn_voice.setOnClickListener{
            if(langResult== TextToSpeech.LANG_NOT_SUPPORTED || langResult == TextToSpeech.LANG_MISSING_DATA)
            {
                Toast.makeText(this@Second , "Error",Toast.LENGTH_LONG).show()
            }
            else
            {

                TtoSpeach!!.speak(second_tv_question.text,TextToSpeech.QUEUE_FLUSH,null,null)
            }
        }
    }
}