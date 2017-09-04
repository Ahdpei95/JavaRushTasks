package com.javarush.task.task14.task1413;

/*6. В класс Computer добавь приватное поле keyboard типа Keyboard.
        7. В класс Computer добавь приватное поле mouse типа Mouse.
        8. В класс Computer добавь приватное поле monitor типа Monitor.
        9. Создай конструктор с тремя параметрами в классе Computer используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).*/
public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
