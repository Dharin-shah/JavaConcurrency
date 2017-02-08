package com.privateprojects.concurrency.threadsafe.blockingQueueExample;

import com.sun.media.jfxmedia.track.Track;
import org.omg.IOP.Encoding;
import java.nio.ByteBuffer;
import java.util.Stack;

/*FAKE FILE SYSTEM*/


/**
 * Created by Dharin on 2/8/2017.
 */
public class File extends Entry{

    private ByteBuffer byteBuffer[];
    private Encoding encoding;

    Entry[] listFiles(){
        return new Entry[]{this};
    }

}



