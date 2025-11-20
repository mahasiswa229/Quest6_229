package com.example.myarsitektur.view

import android.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
   var txtNama by rememberSaveable { mutableStateOf(value = "")}
    var txtAlamat by remember { mutableStateOf(value = "")}
    var txtGender by remember { mutableStateOf(value = "")}
    val listData :  MutableList<String> = mutableListOf(txtNama,txtGender,txtAlamat)

    Scaffold (modifier = Modifier,
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.),color = Color.White)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.holo_blue_dark))

}