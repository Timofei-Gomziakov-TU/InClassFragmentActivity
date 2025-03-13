package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        val fragment = ImageDisplayFragment.newInstance(images = imageArray)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, fragment)
            .commit()
    }
}