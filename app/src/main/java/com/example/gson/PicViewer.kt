package com.example.gson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class PicViewer : AppCompatActivity() {
    var link: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_viewer)

        val intent: Intent = getIntent()
        val message: String = intent.getStringExtra("link").toString()
        val image: ImageView = findViewById(R.id.imageView3)
        link = message

        Glide.with(this).load(link).into(image)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.heart) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", link);
            setResult(RESULT_OK, intent);
            finish();

            return true
        }
        return super.onOptionsItemSelected(item)
    }
}