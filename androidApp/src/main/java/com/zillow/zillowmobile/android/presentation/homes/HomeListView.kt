package com.zillow.zillowmobile.android.presentation.homes

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.zillow.zillowmobile.domain.Location
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun HomeListView(navController: NavHostController? = null, location: Location) {
    println(location)
    val homeListViewModel: HomeListViewModel = koinViewModel()
    val state = homeListViewModel.state.collectAsState()
    with(state.value) {
        if (data.isEmpty() && !isLoading && error == null) {
            homeListViewModel.fetchHomeList(location)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            error?.let {
                Text(text = it)
            }
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed(data) { index, home ->
                    if (index == 0)
                        Spacer(modifier = Modifier.padding(top = 16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                    ) {
                        Column() {
                            home.carouselPhotos?.let {
                                var photos = it.toMutableList()
                                home.imgSrc?.let { image ->
                                    photos.add(0, image)
                                }
                                HorizontalPager(pageCount = photos.size) { index ->
                                    GlideImage(
                                        model = photos[index],
                                        contentDescription = "",
                                        modifier = Modifier
                                            .height(160.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                            if (
                                (home.carouselPhotos == null || home.carouselPhotos?.isEmpty() == true)
                                && home.imgSrc != null
                            ) {
                                GlideImage(
                                    model = home.imgSrc,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(160.dp)
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                                home.price?.let {
                                    Text(
                                        text = it,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    home.beds?.let { Text(text = "$it beds") }
                                    home.baths?.let { Text(text = "$it ba") }
                                    home.statusText?.let { Text(text = "- $it") }
                                }
                                home.address?.let { Text(text = it) }
                                home.brokerName?.let {
                                    Text(
                                        text = it.uppercase(),
                                        fontSize = 12.sp,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                    if (index == data.lastIndex) {
                        Spacer(modifier = Modifier.padding(top = 16.dp))
                    }

                }
            }

            if (isLoading) {

                println("Loading")

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.6F)),
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }


    }


}