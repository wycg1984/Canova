package org.canova.api.records.reader;

import org.canova.api.conf.Configurable;
import org.canova.api.conf.Configuration;
import org.canova.api.split.InputSplit;
import org.canova.api.writable.Writable;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/**
 * Record reader
 * @author Adam Gibson
 */
public interface RecordReader extends Closeable,Serializable,Configurable {

    public final static String NAME_SPACE = RecordReader.class.getName();

    public final static String APPEND_LABEL = NAME_SPACE + ".appendlabe";
    public final static String LABELS = NAME_SPACE + ".labels";

    /**
     * Called once at initialization.
     * @param split the split that defines the range of records to read
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    void initialize(InputSplit split) throws IOException, InterruptedException;

    /**
     * Called once at initialization.
     * @param conf a configuration for initialization
     * @param split the split that defines the range of records to read
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    void initialize(Configuration conf,InputSplit split) throws IOException, InterruptedException;

    /**
     * Get the next record
     * @return
     */
    Collection<Writable> next();


    /**
     * Whether there are anymore records
     * @return
     */
    boolean hasNext();




}
