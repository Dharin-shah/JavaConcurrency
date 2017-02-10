package com.privateprojects.concurrency.threadsafe.blockingQueueExample2;

/**
 * Created by Dharin on 2/10/2017.
 */
public class Message {
        /*inherently thread safe, just delegate thread safety of this class to message (String)*/
        private String message;

        public Message(String message){
            this.message = message;
        }

        /*THREADSAFE PUBLISHING*/
        public String getMessage(){
            return message;
        }
}

