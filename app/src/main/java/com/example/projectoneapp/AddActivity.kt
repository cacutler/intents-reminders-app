package com.example.projectoneapp
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.projectoneapp.databinding.ActivityAddBinding
import android.widget.Toast
const val EXTRA_REMINDER_RESULT = "new_reminder_result"
class AddActivity: ComponentActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            setNewReminderResult(binding.editTextView.text.toString())
            val messageResId = R.string.added_toast
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
    }
    private fun setNewReminderResult(newReminderText: String) {
        val data = Intent().apply {
            putExtra(EXTRA_REMINDER_RESULT, newReminderText)
        }
        setResult(Activity.RESULT_OK, data)
    }
    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, AddActivity::class.java).apply {}
        }
    }
}