package com.luxoft.task;

import java.util.Set;

public class VowelSet implements Comparable<VowelSet>{
    public int count;
    public Set<Character> ls;

    public VowelSet(int count, Set<Character> ls){
        this.count = count;
        this.ls = ls;
    }

    public String toString(){
        return ls.toString() + "," + count;
    }

    @Override
    public int hashCode()
    {
        return count * ls.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof VowelSet)) {
            return false;
        }
        VowelSet vowelSet = (VowelSet) o;
        return vowelSet.count == this.count;
    }

    @Override
    public int compareTo(VowelSet m)
    {
        if(this.count == m.count){
            return 1;
        }
        return this.count - m.count;
    }
}
