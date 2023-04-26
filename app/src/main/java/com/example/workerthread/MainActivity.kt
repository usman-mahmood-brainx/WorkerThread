package com.example.workerthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.workerthread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var button: Button
//    private lateinit var textView: TextView

    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        button = findViewById(R.id.btnSubmit)
//        textView = findViewById(R.id.tvTaskStatus)

        binding.btnSubmit.setOnClickListener {
       
            // Perform a time-consuming operation on a worker thread
            binding.tvTaskStatus.text = "In Progress"
            Thread(Runnable {
                
                val result = performLongOperation()
                // Update the UI components on the Main UI Thread
                runOnUiThread {
                    binding.tvTaskStatus.text = result
                }
            }).start()
        }
    }

    private fun performLongOperation(): String {
        // Simulate a long operation
        Thread.sleep(5000)
        return "Done!"
    }
}