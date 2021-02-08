package com.yusrilaldean_18102062.pertemuan14

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.yusrilaldean_18102062.pertemuan14.model.Token
import com.yusrilaldean_18102062.pertemuan14.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        tokenPref = TokenPref(this)
        token = tokenPref.getToken()
        if (TextUtils.isEmpty(token.token)) {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()}
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_my_quotes, R.id.navigation_class_quotes, R.id.navigation_global_quotes
            )
        )
    }
}