/*
Наблюдатель — это поведенческий паттерн проектирования,
который создаёт механизм подписки,
позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
 */

data class Good(
    name: String
    price: Float
)

public interface Observer {
    public fun update()
}

interface IEventManager{
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class WholesaleStore: IEventManager{

    private var good: Good
    val observers = mutableListOf<IObserver>()

    public fun setNewGood(good: Good){
        this.good = good
        notifyObservers()
    }

    override fun notifyObservers() {
        for (observer in observers)
            observer.update(good)
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

}

class OrangegangStore(wholesaleStore: WholesaleStore): IObserver{

    private var wholesaleStore: WholesaleStore
    private val markup: Float
    init{
        this.wholesaleStore = wholesaleStore
        markup = 10.0f
    }
    private var good: Good

    override fun update(good: Good) {
        this.good = good
        good.price += markup
    }

}

class GreengangStore(wholesaleStore: WholesaleStore): IObserver{
    private var wholesaleStore: WholesaleStore
    private val markup: Float
    init{
        this.wholesaleStore = wholesaleStore
        markup = 15.0f
    }
    private var good: Good

    override fun update(good: Good) {
        this.good = good
        good.price += markup
    }

}
