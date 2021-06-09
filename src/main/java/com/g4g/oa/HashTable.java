package com.g4g.oa;

import java.util.Objects;

/**
 *  Hashing with Open Addressing Algorithm and linear probing.
 */
public class HashTable implements Map {
    private final Entry[] table;
    private final int capacity;
    private int size = 0;
    private final DeletedEntry DELETED_ENTRY = new DeletedEntry();

    public HashTable(int size) {
        this.capacity = size;
        this.table = new Entry[size];
        for(int i = 0; i < this.capacity; i++)
            this.table[i] = null;
    }

    @Override
    public boolean put(Integer key, String value) {
        if (this.size == this.capacity) {
           return false;
        }
        int index = hash(key);
        while(this.table[index] != null
                && !(DELETED_ENTRY.equals(this.table[index]))
                && !this.table[index].getValue().equals(value))
            index = (index + 1) % this.capacity;
        if(this.table[index] != null && value.equals(this.table[index].getValue()))
            return false;
        else {
            this.table[index] = new Entry(key, value);
            this.size++;
            return true;
        }
    }

    @Override
    public Entry get(Integer key) {
        int index = search(key);
        if (key.equals(this.table[index].getKey())) {
            return this.table[index];
        }
        return null;
    }

    @Override
    public Entry remove(Integer key) {
        int index = search(key);
        if (key.equals(this.table[index].getKey())) {
            Entry entry = this.table[index];
            this.table[index] = DELETED_ENTRY;
            this.size--;
            return entry;
        }
        return null;
    }

    private int search(Integer key) {
        int index = hash(key);
        for(int i = 0; i < this.capacity; i++) {
            if (this.table[index] != null
                    &&  !(DELETED_ENTRY.equals(this.table[index]))
                    && !(this.table[index].getKey().equals(key)))
                index = (index + 1) % this.capacity;
        }
        return index;
    }

    private int hash(Integer key) {
        return key % this.capacity;
    }

     static class Entry {
        final Integer key;
        final String value;

        public Entry(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key.equals(entry.key) && value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    static class DeletedEntry extends Entry {
        public DeletedEntry() {
            super(null, null);
        }
    }
}

