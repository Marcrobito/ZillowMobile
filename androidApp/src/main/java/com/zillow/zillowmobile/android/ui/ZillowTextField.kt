package com.zillow.zillowmobile.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val defaultModifier = Modifier
    .height(52.dp)
    .border(width = 1.dp, color = Color.Gray)
    .background(Color.White)

@Composable
fun ZillowTextField(
    modifier: Modifier = defaultModifier,
    placeholderText: String? = null,
    leadingIcon: (@Composable() () -> Unit)? = null,
    trailingIcon: (@Composable() () -> Unit)? = null,
    trailingIconPadding: Int = 8,
    value: String = "",
    onValueChange: (String) -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon?.let {
            it()
        }
        TextField(
            value = value, onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                //textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                //placeholderColor = MubiPalette.SubtleText
            ),
            placeholder = {
                placeholderText?.let {
                    val placeholder = if (it.length > 30) it.substring(0,27) + "..." else it
                    Text(text = placeholder)
                }
            }
        )
        trailingIcon?.let {
            it()
            Spacer(modifier = Modifier.padding(end = trailingIconPadding.dp))
        }
    }
}