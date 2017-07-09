package net.claztec.appkotlin.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.claztec.appkotlin.R

/**
 * Created by derek on 09/07/2017.
 */
class MainFragment : Fragment() {

    private val etNumberOne by lazy {
        view?.findViewById<EditText>(R.id.number_one) as EditText
    }

    private val etNumberTwo by lazy {
        view?.findViewById<EditText>(R.id.number_two) as EditText
    }


    companion object {
        fun getInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view?.findViewById<TextView>(R.id.text) as TextView
        val button = view?.findViewById<Button>(R.id.button) as Button
        button.setOnClickListener {
            textView.text = getSum().toString()
        }
    }

    private fun getSum(): Int {
        val one = try {
            etNumberOne.text.toString().toInt()
        } catch (e: Exception) {
            0
        }

        val two = when {
            etNumberTwo.text.isEmpty() -> 0
            else -> etNumberTwo.text.toString().toInt()
        }

        return one + two
    }
}