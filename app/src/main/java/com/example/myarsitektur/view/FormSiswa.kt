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
            OutlinedTextField(
                value = txtAlamat,

                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = {
                    txtAlamat = it
                }
            )
            Spacer(Modifier.height(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),

                enabled = txtNama.isNotEmpty() && txtAlamat.isNotEmpty() && txtGender.isNotEmpty(),
                onClick = {

                    val listData = mutableListOf(txtNama, txtGender, txtAlamat)
                    onSubmitButtonClicked(listData)
                }
            ) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}
