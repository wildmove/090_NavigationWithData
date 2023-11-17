package com.example.a090_navigationwithdata.ui.komponen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.a090_navigationwithdata.R

@Composable
fun PriceFormatLabel(subtotal: String, modifier: Modifier = Modifier){
    Text(
        text = stringResource(R.string.subtotal, subtotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}