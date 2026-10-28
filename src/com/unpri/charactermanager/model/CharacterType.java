package com.unpri.charactermanager.model;

/**
 * Enum yang mendefinisikan jenis-jenis karakter dalam aplikasi.
 * Menggunakan enum (bukan String) agar nilai selalu valid & type-safe.
 */
public enum CharacterType {
    WARRIOR,    // karakter pejuang
    MAGE,       // karakter penyihir
    ARCHER,     // karakter pemanah
    HEALER      // karakter penyembuh
}