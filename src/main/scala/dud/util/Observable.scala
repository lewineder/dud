package dud.util

trait Observer {
    def update(e: Event): Unit
}

class Observable {
    var subscribers: Vector[Observer] = Vector()

    def add(s: Observer): Unit = subscribers = subscribers :+ s

    def remove(s: Observer): Unit = subscribers = subscribers.filterNot(o => o == s)

    //def notifyObservers: Unit = subscribers.foreach(o => o.update)
    def notifyObservers(e: Event) = subscribers.foreach(o => o.update(e))
}

enum Event:
    case FieldChanged