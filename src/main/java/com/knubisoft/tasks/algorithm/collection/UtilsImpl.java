package com.knubisoft.tasks.algorithm.collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ComparatorUtils;

import java.util.*;

public class UtilsImpl implements Utils{
    @Override
    public <K, V> Map<V, K> invertMap(Map<K, V> map) {
        if (map.isEmpty()){
            throw new RuntimeException();
        }
        Map<V,K> inverseMap = new HashMap<>();
        for (Map.Entry<K,V> entry : map.entrySet()){
            inverseMap.put(entry.getValue(),entry.getKey());
        }
        return inverseMap;
    }

    @Override
    public <E> List<E> union(List<? extends E> list1, List<? extends E> list2) {
        if (list1.isEmpty() && list2.isEmpty()){
            throw new RuntimeException();
        }
        List<E> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }

    @Override
    public boolean isEqualList(Collection<?> list1, Collection<?> list2) {
        if (list1.isEmpty() && list2.isEmpty()){
            throw new RuntimeException();
        }
        return CollectionUtils.containsAny(list1,list2);
    }

    @Override
    public <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map.isEmpty()) {
            throw new NullPointerException();
        }

        Map<K,V> synchronizedMap = Collections.synchronizedMap(map);
        Map<K,V> synchronizedMapResult = new HashMap<>();

        synchronized (synchronizedMap){
            for (K k : synchronizedMap.keySet()){
                synchronizedMapResult.put(k,synchronizedMap.get(k));
            }
        }
        return synchronizedMapResult;
    }

    @Override
    public <O> Collection disjunction(final Iterable<? extends O> a, final Iterable<? extends O> b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }
        return CollectionUtils.disjunction(Collections.singleton(a), Collections.singleton(b));
    }

    @Override
    public <O> Collection<O> subtract(Iterable<? extends O> a, Iterable<? extends O> b) {
        return CollectionUtils.subtract(Collections.singleton(a), Collections.singleton(b));
    }

    @Override
    public <E> Comparator<E> chainedComparator(Comparator<E>... comparators) {
        return ComparatorUtils.chainedComparator(comparators);
    }

    @Override
    public boolean isSubCollection(Collection<?> a, Collection<?> b) {
        return CollectionUtils.isSubCollection(a, b);
    }

    //

}
