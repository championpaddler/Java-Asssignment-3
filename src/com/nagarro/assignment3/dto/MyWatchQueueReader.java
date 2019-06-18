package com.nagarro.assignment3.dto;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


import com.nagarro.assignment3.constants.*;

public class MyWatchQueueReader implements Runnable {

        /** the watchService that is passed in from above */
        private WatchService myWatcher;
        public MyWatchQueueReader(WatchService myWatcher) {
            this.myWatcher = myWatcher;
        }

        /**
         * In order to implement a file watcher, we loop forever
         * ensuring requesting to take the next item from the file
         * watchers queue.
         */
        @Override
        public void run() {
            try {
                // get the first event before looping
                WatchKey key = myWatcher.take();
                while(key != null) {
                    // we have a polled event, now we traverse it and
                    // receive all the states from it
                    for (WatchEvent event : key.pollEvents()) {
                        System.out.printf("Received %s event for file: %s\n",
                                          event.kind(), event.context() );
                    }
                    key.reset();
                    key = myWatcher.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stopping thread");
        }
    }
