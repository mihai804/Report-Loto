package com.mcvector36.reportloto

import android.os.Bundle
import androidx.activity.addCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.mcvector36.reportloto.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {} //reclama

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigare_6din49, R.id.navigare_joker
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        incarcaReclama()

        onBackPressedDispatcher.addCallback(this) { finish()}

    }

    fun incarcaReclama(){
        mAdView = findViewById(R.id.adView) // reclama
        val adRequest = AdRequest.Builder().build() // reclama
        mAdView.loadAd(adRequest) //reclama

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)

        mAdView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Înlocuiți adView cu parent
                constraintSet.connect(R.id.nav_host_fragment_activity_main, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

                // Aplicați modificările
                constraintSet.applyTo(binding.root)
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                constraintSet.connect(R.id.nav_host_fragment_activity_main, ConstraintSet.TOP, R.id.adView, ConstraintSet.BOTTOM)
                constraintSet.applyTo(binding.root)
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }

    }

}