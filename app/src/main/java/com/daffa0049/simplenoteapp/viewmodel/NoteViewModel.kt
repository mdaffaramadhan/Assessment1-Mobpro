package com.daffa0049.simplenoteapp2.viewmodel

import androidx.lifecycle.ViewModel
import com.daffa0049.simplenoteapp2.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class NoteViewModel : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    fun addNote(title: String, content: String) {
        val newNote = Note(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content
        )
        _notes.value += newNote
    }
}
