package com.yusrilaldean_18102062.pertemuan14.ui.myquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
<<<<<<< Updated upstream
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yusrilaldean_18102062.pertemuan14.R

class HomeViewModel : Fragment() {

    private lateinit var notificationsViewModel: MyQuotesFragment

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(MyQuotesFragment::class.java)
        val root = inflater.inflate(R.layout.fragment_my_quotes, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
=======
import androidx.lifecycle.*
import com.yusrilaldean_18102062.pertemuan14.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
>>>>>>> Stashed changes
}