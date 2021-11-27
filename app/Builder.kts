/*
Строитель — это порождающий паттерн проектирования, который позволяет создавать сложные объекты
пошагово. Строитель даёт возможность использовать один и тот же код строительства для получения
разных представлений объектов.
 */

interface Builder{
    fun reset()
    fun setProcessor(name: String)
    fun setDisplay(name: String)
    fun setVideocard(name: String)
}

class Computer{
    public var processor: String
    public var display: String
    public var videocard: String
}

class ComputerBuilder: Builder{
    private var computer: Computer

    override fun reset() {
        computer = Computer()
    }

    override fun setDisplay(name: String) {
       computer.display = name
    }

    override fun setProcessor(name: String) {
        computer.processor = name
    }

    override fun setVideocard(name: String) {
        computer.videocard = name
    }

    fun getResult(): Computer {
        return computer
    }

}
class Director() {
    fun constructGameComputer (builder: Builder) {
        builder.reset()
        builder.setVideocard("NVIDIA RTX 3080")
        builder.setProcessor("AMD")
        builder.setDisplay("IPS")
    }

    fun constructOfficeComputer (builder: Builder) {
        builder.reset()
        builder.setVideocard("Intel Iris Graphics")
        builder.setProcessor("Intel Core i3")
        builder.setDisplay("TN")
    }
}

var director = Director()
var computerBuilder = ComputerBuilder()
director.constructGameComputer(computerBuilder)
var computer = computerBuilder.getResult()