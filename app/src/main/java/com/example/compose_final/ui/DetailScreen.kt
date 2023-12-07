package com.example.compose_final.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.compose_final.R
import com.example.compose_final.data.ListRepository
import com.example.compose_final.ui.AppBar.TopBar
import com.example.compose_final.ui.theme.ComposefinalTheme

@Composable
fun DetailScreen(
    charId: String,
    viewModel: ListHeroViewModel = viewModel(
        factory = ViewModelFactory(ListRepository())
    )
) {
    viewModel.searchById(charId)
    val detailHero by viewModel.detailHero.collectAsState()
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // TopBar berada di atas
        val navController = rememberNavController()
        TopBar(navController = navController)


        // Column utama dengan gambar, teks nama, dan deskripsi
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp), // Sesuaikan dengan tinggi TopBar
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bagian atas: Gambar
            val image = detailHero?.photoUrl
            Image(
                painter = rememberAsyncImagePainter(image.toString()),
                contentDescription = "",
                modifier = Modifier
                    .height(240.dp) // Mengatur tinggi gambar
                    .width(240.dp) // Mengatur lebar gambar
                    .clip(RoundedCornerShape(16.dp)), // Rounded shape dengan radius 16.dp
                contentScale = ContentScale.Crop,
            )

            // Spacer untuk memberikan ruang antara gambar dan teks nama
            Spacer(modifier = Modifier.height(16.dp))

            // Bagian tengah: Nama dalam kotak
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White) // Warna latar belakang kotak
                    .padding(8.dp), // Padding untuk kotak
                contentAlignment = Alignment.CenterStart
            ) {
                // Teks nama
                detailHero?.let {
                    Text(
                        text = it.name,
                        lineHeight = 40.sp,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black // Warna teks nama
                    )
                }
            }

            // Spacer untuk memberikan ruang antara teks nama dan deskripsi
            Spacer(modifier = Modifier.height(6.dp))

            // Bagian bawah: Deskripsi
            detailHero?.let {
                Text(
                    text = stringResource(R.string.description) + "${it.description}",
                    modifier = Modifier
                        .padding(top = 8.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    ComposefinalTheme {
        DetailScreen(charId = "1")

    }
}