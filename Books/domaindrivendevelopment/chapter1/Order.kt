package domaindrivendevelopment.chapter1

import domaindrivendevelopment.chapter1.enums.OrderState
import domaindrivendevelopment.chapter1.vo.Money
import java.util.UUID

data class Order(
    var orderLines: List<OrderLine>,
    var shippingInfo: ShippingInfo
) {
    private val orderNumber: String = UUID.randomUUID().toString()
    private var totalAmount: Money = Money(0)
    private var state: OrderState? = null

    init {
        setOderLines(orderLines)
    }

    private fun setOderLines(orderLines: List<OrderLine>) {
        verifyAtLeastOneOrMoreOrderLines(orderLines)
        calculateTotalAmounts()
    }

    private fun verifyAtLeastOneOrMoreOrderLines(orderLines: List<OrderLine>) {
        if (orderLines.isEmpty()) {
            throw IllegalArgumentException("no OderLine")
        }
    }

    private fun calculateTotalAmounts() {
        this.totalAmount = Money(this.orderLines.sumOf { it.amounts })
    }

    fun changeShipped() {

    }

    fun changeShippingInfo(newShippingInfo: ShippingInfo) {
        verifyNotYetShipped()
        this.shippingInfo = newShippingInfo
    }

    fun cancel() {
        verifyNotYetShipped()
        this.state = OrderState.CANCELED
    }

    private fun verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw IllegalArgumentException("already shipped")
        }
    }

    fun completePayment() {

    }
}