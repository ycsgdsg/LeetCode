package com.chaoyuan.LeetCode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/** * 读多写少的线程安全列表（基于 ReentrantReadWriteLock） * 核心：读锁共享（并发读），写锁排他（互斥写） */
public class ReadWriteLockList<T> {
    // 底层存储容器（非线程安全，依赖锁保证安全）
    private final List<T> list = new ArrayList<>();
    // 读写锁（默认非公平模式，性能更优；公平模式可避免写线程饥饿）
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(false);
    // 读锁（共享锁）
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    // 写锁（排他锁）
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    // 1. 读操作：获取元素（加读锁）
    public T get(int index) {
        readLock.lock(); // 加读锁（多个读线程可同时获取）
        try {
            if (index < 0 || index >= list.size()) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
            }
            return list.get(index);
        } finally {
            readLock.unlock();// 必须释放锁
        }
    }
    // 2. 读操作：获取列表大小（加读锁）
    public int size() {
        readLock.lock();
        try {
            return list.size();
        } finally {
            readLock.unlock();
        }
    }
    // 3. 写操作：添加元素（加写锁）
    public boolean add(T element) {
        if (element == null) throw new NullPointerException("Element cannot be null");
        writeLock.lock(); // 加写锁（仅一个线程可获取）
        try {
            return list.add(element);
        } finally {
            writeLock.unlock();
        }
    }
    // 4. 写操作：删除元素（加写锁）
    public T remove(int index) {
        writeLock.lock();
        try {
            if (index < 0 || index >= list.size()) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
            }
            return list.remove(index);
        } finally {
            writeLock.unlock();
        }
    }
    // 5. 写操作：修改元素（加写锁）
    public T set(int index, T element) {
        if (element == null) throw new NullPointerException("Element cannot be null");
        writeLock.lock();
        try {
            if (index < 0 || index >= list.size()) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
            }
            return list.set(index, element);
        } finally {
            writeLock.unlock();
        }
    }
    // 可选：批量添加（写操作，加写锁）
    public boolean addAll(List<? extends T> elements) {
        if (elements == null || elements.contains(null)) {
            throw new NullPointerException("Elements cannot be null");
        }
        writeLock.lock();
        try {
            return list.addAll(elements);
        } finally {
            writeLock.unlock();
        }
    }
}