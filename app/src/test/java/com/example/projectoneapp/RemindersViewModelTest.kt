package com.example.projectoneapp
import androidx.lifecycle.SavedStateHandle
import layout.Reminder
import org.junit.Assert.assertEquals
import org.junit.Test
class RemindersViewModelTest {
    @Test
    fun providesDefaultReminder() {
        val savedStateHandle = SavedStateHandle()
        val remindersViewModel = RemindersViewModel(savedStateHandle)
        assertEquals("Default Reminder", remindersViewModel.currentReminderText)
    }
    @Test
    fun addsReminder() {
        val savedStateHandle = SavedStateHandle()
        val remindersViewModel = RemindersViewModel(savedStateHandle)
        assertEquals("Default Reminder", remindersViewModel.currentReminderText)
        val newReminder = Reminder("Test Reminder")
        remindersViewModel.addReminder(newReminder)
        remindersViewModel.moveToNext()
        assertEquals("Test Reminder", remindersViewModel.currentReminderText)
    }
    @Test
    fun wrapsAround() {
        val savedStateHandle = SavedStateHandle()
        val remindersViewModel = RemindersViewModel(savedStateHandle)
        assertEquals("Default Reminder", remindersViewModel.currentReminderText)
        val newReminder = Reminder("Test Reminder")
        remindersViewModel.addReminder(newReminder)
        remindersViewModel.moveToNext()
        assertEquals("Test Reminder", remindersViewModel.currentReminderText)
        remindersViewModel.moveToNext()
        assertEquals("Default Reminder", remindersViewModel.currentReminderText)
    }
    @Test
    fun completesReminder() {
        val savedStateHandle = SavedStateHandle()
        val remindersViewModel = RemindersViewModel(savedStateHandle)
        assertEquals("Default Reminder", remindersViewModel.currentReminderText)
        val newReminder = Reminder("Test Reminder")
        remindersViewModel.addReminder(newReminder)
        remindersViewModel.moveToNext()
        assertEquals("Test Reminder", remindersViewModel.currentReminderText)
        remindersViewModel.moveToNext()
        remindersViewModel.completeReminder()
        assertEquals("Test Reminder", remindersViewModel.currentReminderText)
    }
}