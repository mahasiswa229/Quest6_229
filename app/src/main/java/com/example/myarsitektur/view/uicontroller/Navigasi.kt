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

    Scaffold {isiRuang ->

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        )
        {
            composable(route = Navigasi.Formulir.name) {

                val konteks = LocalContext.current

                FormSiswa(
                    pilihanJK = JenisK.map { id ->
                        konteks.resources.getString(id)
                    },
                    onSubmitButtonClicked = { siswa ->
                        viewModel.setSiswa(siswa)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            
    }
}