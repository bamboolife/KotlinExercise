package com.sundy.test.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sundy.test.R
import com.sundy.test.delegates.User

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var number: Int = 10;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val user= User(mapOf("name" to "John Doe","age" to 25))
        user.nameNot="firsr"
        user.nameNot="second"
        println(user.lazyValue)

        stringMapper("3333") {
            Log.i("log_index", "onCreateView: ")
        }
        return root
    }

    val answerString: String = if (number == 10) {
        "i hava the anser"
    } else if (number > 3) {
        "The anser is close"
    } else {
        "the ansetr elser me"
    }

    val answerSting2: String = when {
        number == 42 -> "i hava the anser"
        number > 34 -> "The anser is close"
        else -> "the ansetr elser me"
    }
    /**
     * 功能描述:
     * @date 3:33 PM 2021/7/3
     * @param []
     * @return
     */
    fun generateAnserString():String{
        val answerString=if (number>10){
            "I have the answer"
        }else{
            "The answer eludes me"
        }
        return answerString;
    }

    fun generateAnserSting3():String{
        return if (number>10){
            "I have the answer"
        }else{
            "The answer eludes me"
        }
    }

    fun generateAnswerString4():String=if (number>10){
        "I have the answer"
    }else{
        "The answer eludes me"
    }

    //匿名函数
    val stringLengthFunc:(String)->Int={
            input->input.length
    }
    //高阶函数
    fun  stringMapper(str:String,mapper: (String)->Int):Int{
        return mapper(str)
    }
}