package com.example.myarsitektur.view.uicontroller

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    navController: NavHostController,
    viewModel: SiswaViewModel
) {
    val uiState = viewModel.statusUI.collectAsState()
}