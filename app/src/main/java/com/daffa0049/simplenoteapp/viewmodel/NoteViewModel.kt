package com.daffa0049.simplenoteapp.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Note(val id: Int, val title: String, val content: String)

class NoteViewModel : ViewModel() {
    private var nextId = 1
    var notes = mutableStateListOf<Note>()
        private set

    fun addNote(title: String, content: String) {
        val newNote = Note(nextId++, title, content)
        notes.add(newNote)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteNote(noteId: Int) {
        notes.removeIf { it.id == noteId }
    }

    fun editNote(noteId: Int, newTitle: String, newContent: String) {
        val index = notes.indexOfFirst { it.id == noteId }
        if (index != -1) {
            notes[index] = notes[index].copy(title = newTitle, content = newContent)
        }
    }
}
