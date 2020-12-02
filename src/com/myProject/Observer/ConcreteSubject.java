package com.myProject.Observer;
import com.myProject.Main.Console;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {

    private final ArrayList<Observer> observers;

    public ConcreteSubject(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) observers.remove(i);
    }

    @Override
    public void notifyObservers(String[] in, Console console) {
        for (Observer observer : observers)
            observer.update(in, console);
    }
}