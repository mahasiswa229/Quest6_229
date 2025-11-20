package com.example.myarsitektur.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama), second = statusUiSiswa.nama),
        Pair(first = stringResource(id = R.string.gender), second = statusUiSiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUiSiswa.alamat)
    )
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.detail), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ){isiRuang ->

        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.padding(
                    all = dimensionResource(id = R.dimen.padding_medium)
                ),
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensionResource(id = R.dimen.padding_small)
                )
            )
        }

    }
}