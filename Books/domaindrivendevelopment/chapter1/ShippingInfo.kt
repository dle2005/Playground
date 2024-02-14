package domaindrivendevelopment.chapter1

import domaindrivendevelopment.chapter1.vo.Address
import domaindrivendevelopment.chapter1.vo.Receiver

data class ShippingInfo(
    val receiver: Receiver,
    val address: Address
) {
}