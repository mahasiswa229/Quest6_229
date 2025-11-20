package com.example.myarsitektur.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myarsitektur.R

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
            )
            Text("Jenis Kelamin:")
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
