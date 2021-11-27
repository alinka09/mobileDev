/*
Декоратор — это структурный паттерн проектирования, который позволяет динамически добавлять объектам
новую функциональность, оборачивая их в полезные «обёртки».
 */


abstract class Coffee{
    abstract fun getPrice(): Float
}

class Espresso: Coffee{
    override fun getPrice(): Float{
        return 1.00f
    }
}

class Latte: Coffee{
    override fun getPrice(): Float{
        return 1.25f
    }
}

class BananaSyrup(coffee: Coffee): Coffee{
    private var coffee: Coffee
    init {
        this.coffee = coffee
    }

    override fun getPrice(): Float {
        return 0.2f + coffee.getPrice()
    }
}

class CaramelSyrup(coffee: Coffee): Coffee{
    private var coffee: Coffee
    init {
        this.coffee = coffee
    }
    override fun getPrice(): Float {
        return 0.15f + coffee.getPrice()
    }
}

coffee: Coffee = Latte()
coffee = BananaSyrup(coffee)
coffee.getPrice() // вернет 0.2 + 1.00 = 1.2