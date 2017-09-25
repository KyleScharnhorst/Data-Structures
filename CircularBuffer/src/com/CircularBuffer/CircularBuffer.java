package com.CircularBuffer;

public class CircularBuffer {
    private char[] _buffer;
    public final int _buffer_size;

    public CircularBuffer(int buffer_size) {
        this._buffer_size = buffer_size;
    }

    public char[] readOutBuffer() {
        return new char[1];
    }

    public boolean writeToBuffer(char c) {
        return false;
    }

    private static class TestWriteWorker implements Runnable {
        CircularBuffer _buffer;
        public TestWriteWorker(CircularBuffer cb) {
            this._buffer = cb;
        }
        public void run() {

        }
    }

    private static class TestReadWorker implements Runnable {
        CircularBuffer _buffer;
        public TestReadWorker(CircularBuffer cb) {
            this._buffer = cb;
        }
        public void run() {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        //create circular buffer
        CircularBuffer cb = new CircularBuffer(100);

        //create threads that read and write the buffer.
        Thread write_thread = new Thread(new TestWriteWorker(cb));
        write_thread.start();
        Thread read_thread = new Thread(new TestReadWorker(cb));
        read_thread.start();

        //wait some amount of time
        Thread.sleep(10000);

        //interupt threads and exit
        write_thread.interrupt();
        read_thread.interrupt();
    }
}
