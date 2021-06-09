package com.g4g.oa;

import com.g4g.oa.HashTable.Entry;

public interface Map {
    boolean put(Integer key, String value);

    Entry get(Integer key);

    Entry remove(Integer key);
}
