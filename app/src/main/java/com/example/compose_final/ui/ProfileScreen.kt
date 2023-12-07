package com.example.compose_final.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.compose_final.R
import com.example.compose_final.ui.AppBar.TopBar
import com.example.compose_final.ui.theme.ComposefinalTheme

@Composable
fun ProfileScreen() {
    val navController = rememberNavController()
    TopBar(navController = navController)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            stringResource(id = R.string.myprofile),
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            modifier = Modifier.padding(16.dp)
        )
        Image(
            painterResource(R.drawable.foto_saya),
            contentDescription = null,
           modifier = Modifier
               .height(240.dp) // Mengatur tinggi gambar
               .width(240.dp) // Mengatur lebar gambar
               .clip(RoundedCornerShape(16.dp)), // Rounded shape dengan radius 16.dp
                contentScale = ContentScale.Crop,
        )
        Text(
            stringResource(id = R.string.full_name),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            "Mahasiswa Teknik Informatika",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            "Universitas Palangkaraya, Fakultas Teknik",
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 2.dp)
        )
        Text(
            stringResource(id = R.string.email_address),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    ComposefinalTheme {
        TopBar(navController = rememberNavController())
        ProfileScreen()
    }
}
