package com.CircularBuffer;

import java.util.Random;

public class CircularBuffer {
    private char[] _buffer;
    public final int _buffer_size;
    private int _write_index = 0;
    private int _read_index = 0;

    public CircularBuffer(int buffer_size) {
        if(!IsPowerOfTwo(buffer_size)) {
            throw new IllegalArgumentException();
        }
        this._buffer_size = buffer_size;
        _buffer = new char[buffer_size];
    }

    private boolean IsPowerOfTwo(int i) {
        return (i & (i - 1)) == 0;
    }

//    private int GetReadableDataRange() {
//
//    }

    private int getTrueIndex(int i) {
        return i % _buffer_size;
    }

    public char[] readOutBuffer() {
        //char result = _buffer[];
        return new char[1];
    }

    public boolean writeToBuffer(char c) {
        return false;
    }

    private static class TestWriteWorker implements Runnable {
        String _alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random _random = new Random();
        CircularBuffer _buffer;
        public TestWriteWorker(CircularBuffer cb) {
            this._buffer = cb;
        }

        private char getRandomChar() {
            return _alphabet.charAt(_random.nextInt(_alphabet.length()));
        }

        public void run() {
            while(!Thread.interrupted()) {
                if(!_buffer.writeToBuffer(getRandomChar())){
                    Thread.yield();
                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }

    private static class TestReadWorker implements Runnable {
        CircularBuffer _buffer;
        public TestReadWorker(CircularBuffer cb) {
            this._buffer = cb;
        }

        public void run() {
            while(!Thread.interrupted()) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int buffer_size = 64;
        //create circular buffer
        CircularBuffer cb = new CircularBuffer(buffer_size);

        //create threads that read and write the buffer.
        Thread write_thread = new Thread(new TestWriteWorker(cb));
        write_thread.start();
        Thread read_thread = new Thread(new TestReadWorker(cb));
        read_thread.start();

        //wait some amount of time
        Thread.sleep(10000);

        //interrupt threads and exit
        write_thread.interrupt();
        read_thread.interrupt();
    }
}
