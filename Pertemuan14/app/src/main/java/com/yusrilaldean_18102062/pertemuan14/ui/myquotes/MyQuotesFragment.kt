package com.yusrilaldean_18102062.pertemuan14.ui.myquotes

<<<<<<< Updated upstream
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyQuotesFragment : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
=======
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusrilaldean_18102062.pertemuan14.CoroutineContextProvider
import com.yusrilaldean_18102062.pertemuan14.QuoteAdapter
import com.yusrilaldean_18102062.pertemuan14.R
import com.yusrilaldean_18102062.pertemuan14.TokenPref
import com.yusrilaldean_18102062.pertemuan14.`interface`.MainView
import com.yusrilaldean_18102062.pertemuan14.api.MainPresenter
import com.yusrilaldean_18102062.pertemuan14.databinding.FragmentMyQuotesBinding
import com.yusrilaldean_18102062.pertemuan14.helper.REQUEST_ADD
import com.yusrilaldean_18102062.pertemuan14.model.Login
import com.yusrilaldean_18102062.pertemuan14.model.Quote
import com.yusrilaldean_18102062.pertemuan14.model.Token
import com.yusrilaldean_18102062.pertemuan14.ui.QuoteAddUpdateActivity
import kotlinx.android.synthetic.main.fragment_my_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class MyQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter


    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_my_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMyQuotesBinding.bind(view)
        binding.recyclerviewMyQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewMyQuotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getMyQuotes(token.token)
        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getMyQuotes(token.token)
            binding.fab.setOnClickListener {
                val intent = Intent(requireActivity(),
                    QuoteAddUpdateActivity::class.java)
                startActivityForResult(intent, REQUEST_ADD)
            }

        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getMyQuotes(token.token)
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }

>>>>>>> Stashed changes
}