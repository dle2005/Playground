package domaindrivendevelopment.chapter1.enums

enum class OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED,
    ;
}