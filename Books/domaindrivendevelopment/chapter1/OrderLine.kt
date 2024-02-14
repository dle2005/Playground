package domaindrivendevelopment.chapter1

data class OrderLine(
    val product: Product,               // 주문할 상품
    val price: Int,                     // 상품의 가격
    val quality: Int                    // 구매 개수
) {
    val amounts = calculateAmounts()    // 각 구매 항목의 구매 가격

    /**
     * 구매 가격 계산
     */
    private fun calculateAmounts() = price * quality
}