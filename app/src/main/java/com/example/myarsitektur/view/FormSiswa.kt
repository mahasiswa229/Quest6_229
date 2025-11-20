package com.example.myarsitektur.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ){isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            OutlinedTextField(
                value = txtNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    txtNama = it
                }
            )Text("Jenis Kelamin:")
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = txtGender == item,
                            onClick = {
                                txtGender = item
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = {
                                txtGender = item
                            }
                        )
                        Text(text = item)
                    }
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                color = MaterialTheme.colorScheme.secondary
            )
    }
}
