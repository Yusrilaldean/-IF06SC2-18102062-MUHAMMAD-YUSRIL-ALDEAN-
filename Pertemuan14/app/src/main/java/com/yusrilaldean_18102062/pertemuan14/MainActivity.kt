package com.yusrilaldean_18102062.pertemuan14

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
<<<<<<< Updated upstream
=======
import android.view.Menu
import android.view.MenuItem
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
<<<<<<< Updated upstream
=======
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_my_quotes, R.id.navigation_class_quotes,
                R.id.navigation_global_quotes
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
>>>>>>> Stashed changes
        tokenPref = TokenPref(this)
        token = tokenPref.getToken()
        if (TextUtils.isEmpty(token.token)) {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
<<<<<<< Updated upstream
            finish()}
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_my_quotes, R.id.navigation_class_quotes, R.id.navigation_global_quotes
            )
        )
    }
=======
            finish()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.topbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                tokenPref.removeToken()
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

>>>>>>> Stashed changes
}