package com.jack.quotesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson


class MainViewModel(val context: Context):ViewModel() {
    private var quotelist:Array<Quot> = emptyArray()
    private var index=0

    init {
        quotelist=loadquotefromAssets()
    }

    private fun loadquotefromAssets(): Array<Quot> {
        val inputStream =context.assets.open("quotes.json")
        val size :Int= inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson=Gson()
       return  gson.fromJson(json,Array<Quot>::class.java)

    }

    fun getQuote() =quotelist[index]

    fun nextQuote()= quotelist[++index]
    fun onPrevQuote()=quotelist[--index]

    }
