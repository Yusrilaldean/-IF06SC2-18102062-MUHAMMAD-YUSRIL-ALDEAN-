package com.yusrilaldean_18102062.pertemuan14.`interface`

import com.yusrilaldean_18102062.pertemuan14.model.Login
import com.yusrilaldean_18102062.pertemuan14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}