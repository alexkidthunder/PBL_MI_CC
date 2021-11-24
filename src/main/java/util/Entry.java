/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @authors Alexandre & Bianca
 */
public class Entry<K, V> implements Map.Entry<K, V> {

    private final K chave;
    private V valor;

    public Entry(K chave, V valor) {
        this(chave);
        this.valor = valor;
    }

    public Entry(K chave) {
        if (chave == null) {
            throw new IllegalArgumentException("Uma chave não pode ser nula");
        }
        this.chave = chave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entry)) {
            return false;
        }
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return chave.equals(entry.chave)
                && Objects.equals(valor, entry.valor);
    }

    @Override
    public int hashCode() {
        return this.chave.hashCode();
    }

    @Override
    public K getKey() {
        return this.chave;
    }

    @Override
    public V getValue() {
        return this.valor;
    }

    @Override
    public V setValue(V valor) {
        var valorAntigo = this.valor;
        this.valor = valor;
        return valorAntigo;
    }

}
