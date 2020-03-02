package com.example.androidanimations.ui.home

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidanimations.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var wifiAnimation: AnimationDrawable
    private lateinit var imageViewWifiAnim:ImageView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        imageViewWifiAnim=root.findViewById(R.id.imageViewWifiAnim)
        imageViewWifiAnim.apply {
            setBackgroundResource(R.drawable.wifi_animation)
            wifiAnimation = background as AnimationDrawable
        }

        imageViewWifiAnim.setOnClickListener { wifiAnimation.start() }
        return root
    }
}
