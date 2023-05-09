package com.zillow.zillowmobile.android.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zillow.zillowmobile.android.R
import com.zillow.zillowmobile.android.entities.mapToLocationSerializable
import com.zillow.zillowmobile.android.presentation.navigation.PROPERTY_LIST_ROUTE_STRING
import com.zillow.zillowmobile.android.ui.ZillowTextField
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchView(navController: NavHostController? = null) {
    val searchViewModel: SearchViewModel = koinViewModel()
    val state = searchViewModel.state.collectAsState()
    var query by remember { mutableStateOf("") }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2F)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.search_bg),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                ZillowTextField(
                    placeholderText = "Enter an address, neighborhood, city",
                    onValueChange = {
                        query = it
                        searchViewModel.searchLocation(query)
                    },
                    trailingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "")
                    },
                    value = query
                )
            }

        }

        with(state.value) {
            LazyColumn() {
                items(locations) { location ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                            .drawWithContent {
                                drawContent()
                                clipRect { // Not needed if you do not care about painting half stroke outside
                                    val strokeWidth = Stroke.DefaultMiter
                                    val y = size.height // - strokeWidth
                                    // if the whole line should be inside component
                                    drawLine(
                                        brush = SolidColor(Color(0xFF006AFF)),
                                        strokeWidth = strokeWidth,
                                        cap = StrokeCap.Square,
                                        start = Offset.Zero.copy(x = 40F, y = y),
                                        end = Offset(x = size.width - 40, y = y)
                                    )
                                }
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.LocationOn, contentDescription = "")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = location.name)
                        }
                        Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            modifier = Modifier.fillMaxSize(),
                            elevation = ButtonDefaults.elevation(0.dp),
                            onClick = {
                                val json = Json.encodeToString(location.mapToLocationSerializable())
                                navController?.let { nav ->
                                    println(json)
                                    nav.navigate("$PROPERTY_LIST_ROUTE_STRING/$json")
                                }
                            }) {}
                    }

                }
            }
        }


    }
}