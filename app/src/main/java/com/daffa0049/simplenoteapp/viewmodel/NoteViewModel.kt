package com.daffa0049.simplenoteapp2.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.daffa0049.simplenoteapp2.model.Note

class NoteViewModel : ViewModel() {
    private var nextId = 1
    var notes = mutableStateListOf<Note>()
        private set

    fun addNote(title: String, content: String) {
        val newNote = Note(nextId++, title, content)
        notes.add(newNote)
    }
}
