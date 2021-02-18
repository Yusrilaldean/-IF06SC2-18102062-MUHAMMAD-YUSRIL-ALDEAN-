package com.yusrilaldean_18102062.pertemuan14.ui.login

<<<<<<< Updated upstream
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
=======
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.yusrilaldean_18102062.pertemuan14.CoroutineContextProvider
import com.yusrilaldean_18102062.pertemuan14.MainActivity
import com.yusrilaldean_18102062.pertemuan14.R
import com.yusrilaldean_18102062.pertemuan14.TokenPref
import com.yusrilaldean_18102062.pertemuan14.`interface`.MainView
import com.yusrilaldean_18102062.pertemuan14.api.MainPresenter
import com.yusrilaldean_18102062.pertemuan14.databinding.ActivityLoginBinding
import com.yusrilaldean_18102062.pertemuan14.model.Login
import com.yusrilaldean_18102062.pertemuan14.model.Quote
import com.yusrilaldean_18102062.pertemuan14.model.Token

class LoginActivity : AppCompatActivity(), View.OnClickListener, MainView {
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityLoginBinding
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSign.setOnClickListener(this)
        presenter = MainPresenter(this, CoroutineContextProvider())
        tokenPref = TokenPref(this)
        token = tokenPref.getToken()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSign -> {
                presenter.login(
                    binding.inputNim.text.toString(),
                    binding.inputPassword.text.toString()
                )
            }
        }
    }


    override fun showMessage(messsage: String) {
        Toast.makeText(this, messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
    }
    override fun resultLogin(data: Login) {
        if (!TextUtils.isEmpty(data.token)) {
            token.token = data.token
            tokenPref.setToken(token)
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
>>>>>>> Stashed changes
    }
}