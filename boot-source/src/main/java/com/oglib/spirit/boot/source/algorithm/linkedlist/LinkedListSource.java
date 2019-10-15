package com.oglib.spirit.boot.source.algorithm.linkedlist;

import java.util.*;

public class LinkedListSource<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedListSource(){

    }

    public LinkedListSource(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * LinkedList 为首次添加，则previous，next为null
     * @param e 入参
     */
    private void linkFirst(E e){
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if(null == f){
            last = newNode;
        }else {
            f.prev = newNode;
        }
        size ++;
        modCount ++;
    }

    /**
     * last
     * @param e
     */
    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if(null == l){
            first = newNode;
        }else {
            l.next = newNode;
        }
        size ++;
        modCount ++;
    }

    /**
     * Inserts element a brefore non-null Node succ
     * @param e
     * @param succ
     */
    void linkBefore(E e, Node<E> succ){
        final Node<E> pred    = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if(null == pred){
            first = newNode;
        }else {
            pred.next = newNode;
        }
        size ++;
        modCount ++;
    }

    /**
     * Unlinks non-null first node f
     * @param f
     * @return
     */
    private E unlinkFirst(Node<E> f){
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if(next == null){
            last = null;
        }else {
            next.prev = null;
        }
        size --;
        modCount ++;
        return element;
    }

    private E unlinkLast(Node<E> l){
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if(prev == null){
            first = null;
        }else {
            prev.next = null;
        }
        size --;
        modCount ++;
        return element;
    }

    E unlink(Node<E> x){
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if(null == prev){
            first = next;
        }else {
            prev.next = next;
            x.prev = null;
        }

        if(next == null){
            last = prev;
        }else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size --;
        modCount ++;

        return element;
    }



    /**
     * 节点
     * 双向列表
     * previous
     * next
     * @param <E>
     */
    private static class Node<E> {

        E item;

        Node<E> next;

        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }

    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {

        final Node<E> f = first;
        if(f == null){
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if(null == l){
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {

        final Node<E> f = first;
        if(null == f){
            throw new NoSuchElementException();
        }
        return f.item;
    }

    @Override
    public E getLast() {

        final Node<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        return l.item;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
