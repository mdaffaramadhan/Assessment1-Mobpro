package com.daffa0049.simplenoteapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.daffa0049.simplenoteapp2.ui.HomeScreen
import com.daffa0049.simplenoteapp2.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel = remember { NoteViewModel() }
            HomeScreen(
                noteViewModel = noteViewModel,
                onAddNoteClick = {
                    noteViewModel.addNote("Judul Baru", "Isi Catatan")
                }
            )
        }
    }
}
