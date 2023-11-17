package com.example.a090_navigationwithdata.ui

import androidx.lifecycle.ViewModel
import com.example.a090_navigationwithdata.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI : StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setContact(orderUIState: OrderUIState) {
        _stateUI.value = _stateUI.value.copy(
            nama = orderUIState.nama,
            alamat = orderUIState.alamat,
            tlp = orderUIState.tlp
        )
    }

    fun setKuantitas(kuantitasEs : Int) {
        _stateUI.update { currentState ->
            currentState.copy(
                kuantitas = kuantitasEs,
                harga = calculatePrice(kuantitas = kuantitasEs)
            )
        }
    }

    fun setRasa (selectedRasa : String) {
        _stateUI.update { currentState ->
            currentState.copy(
                rasaa = selectedRasa
            )
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    fun resetContact() {
        _stateUI.value = OrderUIState()
    }

    private fun calculatePrice (kuantitas : Int = _stateUI.value.kuantitas) : String {
        val priceCalculation = kuantitas * HARGA_PER_CUP
        return NumberFormat.getNumberInstance().format(priceCalculation)
    }

}