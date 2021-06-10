package com.abdullahakcakil.abdullahakcakilodev.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.abdullahakcakil.abdullahakcakilodev.R
import com.abdullahakcakil.abdullahakcakilodev.dataui.UiHelper

class SlapshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slapsh)
        if (UiHelper.hasInternetConnection(this)) {
            loadSplashScreen()
        } else {
            UiHelper.customErrorDialog(this, "Lütfen internet bağlantınızı kontrol ediniz.")
        }
    }
    private fun loadSplashScreen(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            finish()
        },3000)
    }

}