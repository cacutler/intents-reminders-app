package com.example.projectoneapp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import layout.Reminder
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class RemindersViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val reminderBank = mutableListOf<Reminder>(
        Reminder("Default Reminder")
    )
    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % reminderBank.size
    }
    fun moveToPrevious() {
        if (currentIndex == 0) {
            currentIndex = reminderBank.size - 1
        } else {
            currentIndex -= 1
        }
    }
    fun addReminder(newReminder: Reminder) {
        reminderBank.add(reminderBank.size, newReminder)
    }
    fun completeReminder() {
        reminderBank.removeAt(currentIndex)
    }
    val currentReminderText: String
        get() = reminderBank[currentIndex].textValue!!
}