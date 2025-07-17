package com.example.projectoneapp
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.projectoneapp.databinding.ActivityMainBinding
import androidx.activity.viewModels
class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val remindersViewModel: RemindersViewModel by viewModels()
    private val addLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val reminderText = result.data?.getStringExtra(EXTRA_REMINDER_RESULT)
            val newReminder = Reminder(reminderText)
            remindersViewModel.addReminder(newReminder)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener {view: View ->
            val intent = AddActivity.newIntent(this@MainActivity)
            addLauncher.launch(intent)
        }
        binding.completeButton.setOnClickListener {view: View ->
            remindersViewModel.completeReminder()
            updateReminder()
            val messageResId = R.string.completed_toast
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
        binding.nextButton.setOnClickListener {view: View ->
            remindersViewModel.moveToNext()
            updateReminder()
        }
        binding.previousButton.setOnClickListener {view: View ->
            remindersViewModel.moveToPrevious()
            updateReminder()
        }
        updateReminder()
    }
    private fun updateReminder() {
        binding.reminderTextView.text = remindersViewModel.currentReminderText
    }
}