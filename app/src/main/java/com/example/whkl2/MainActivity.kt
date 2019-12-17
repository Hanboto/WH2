package com.example.whkl2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val url  = mutableListOf<String>()
    private var count: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextBtnClick: Button = findViewById(R.id.nextBtn)
        val previewBtnClick = findViewById<Button>(R.id.previewBtn)
        val imageView: ImageView = findViewById(R.id.imageView)
        addDataToUrl()
        nextBtnClick.setOnClickListener {
            previewBtnClick.visibility=View.VISIBLE
            if (count<url.lastIndex){
                loadImage(count++)
            }else{
                nextBtnClick.visibility=View.INVISIBLE
            }
        }
        previewBtnClick.setOnClickListener {
           nextBtnClick.visibility= View.VISIBLE
            if (count>0){
                loadImage(count--)
            }else{
                previewBtnClick.visibility=View.INVISIBLE
            }

        }
    }

    private fun loadImage(i: Int){
        Picasso.get()
            .load(url[i])
            .into(imageView)
    }
    private fun addDataToUrl(){
        url.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRFqDFjhxo8VYWO0vWnvr0fFbYMHt_syduVHgSD18E77p47hIUHA&s")
        url.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3R6WbE4bqmddWm9FbG1zVpqJXvvt2cbc5yOuI09iHp0qS16AL6Q&s")
        url.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_lJue5iQRE1-2dgrvoIAMakebhDJIFM7sfO-QsO5modqtjJjL&s")
        url.add("https://scontent-lga3-1.cdninstagram.com/v/t51.2885-15/e35/70499574_2458843344402497_1937488288072061243_n.jpg?_nc_ht=scontent-lga3-1.cdninstagram.com&_nc_cat=105&oh=50ee5ac12bfd0969d24a1dd1bf599c6c&oe=5E1A4FAD&ig_cache_key=MjEzNjQzMTUyMDY1MzYxMzU1Nw%3D%3D.2")
        url.add("https://scontent-yyz1-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/s640x640/72097765_127501748703759_5019149837845104450_n.jpg?_nc_ht=scontent-yyz1-1.cdninstagram.com&_nc_cat=103&oh=a88feb80c297e9ae429728941898a144&oe=5E83D76D")

    }


}
