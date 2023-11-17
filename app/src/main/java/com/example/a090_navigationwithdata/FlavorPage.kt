package com.example.a090_navigationwithdata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlavorPage(
    flavorChoice : List<String>,
    onSelectionChanged : (String) -> Unit,
    onConfirmButtonClicked : (Int) -> Unit,
    onNextButtonClicked : () -> Unit,
    onCencelButtonClicked : () -> Unit,
    modifier : Modifier = Modifier
) {
    var textSelectedFlavor by remember { mutableStateOf("") }
    var textPurchaseQuantity by remember { mutableStateOf("") }
    Column (modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween) {
        Column (modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))){
            flavorChoice.forEach { item ->
                Row (modifier = Modifier.selectable(
                    selected = textSelectedFlavor == item,
                    onClick = {
                        textSelectedFlavor = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = textSelectedFlavor == item,
                        onClick = {
                            textSelectedFlavor = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),) {
                OutlinedTextField(
                    value = textPurchaseQuantity,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(150.dp),
                    label = {
                        Text(text = "Order Quantity")
                    },
                    onValueChange = {textPurchaseQuantity = it}
                )
                Button(
                    modifier = Modifier.weight(1f),
                    enabled = textPurchaseQuantity.isNotEmpty(),
                    onClick = {onConfirmButtonClicked(textPurchaseQuantity.toInt())}
                ) {
                    Text(stringResource(R.string.confirm))
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCencelButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.cancel))
                }
                Button(
                    modifier = Modifier.weight(1f),
                    enabled = textPurchaseQuantity.isNotEmpty(),
                    onClick = onNextButtonClicked
                ) {
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}