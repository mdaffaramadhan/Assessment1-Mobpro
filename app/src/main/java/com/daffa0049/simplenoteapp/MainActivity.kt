package com.daffa0049.simplenoteapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.daffa0049.simplenoteapp2.ui.HomeScreen
import com.daffa0049.simplenoteapp2.ui.screens.AddNoteScreen
import com.daffa0049.simplenoteapp2.ui.screens.NoteDetailScreen
import com.daffa0049.simplenoteapp2.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel: NoteViewModel = viewModel()
            NoteApp(noteViewModel)
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                navController = navController,
                noteViewModel = noteViewModel
            )
        }
        composable("add_note") {
            AddNoteScreen(
                navController = navController,
                noteViewModel = noteViewModel
            )
        }
        composable("note_detail/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") ?: ""
            NoteDetailScreen(navController, noteViewModel, noteId)
        }
    }
}
