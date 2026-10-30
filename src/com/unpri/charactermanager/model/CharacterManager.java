
package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola kumpulan objek Character.
 *
 * Menggunakan Composition karena CharacterManager
 * memiliki ArrayList yang menyimpan objek Character.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

    /**
     * Constructor untuk membuat manager dengan list kosong.
     */
    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    /**
     * Menambahkan karakter ke dalam daftar.
     *
     * Nama karakter yang sudah terdaftar akan ditolak.
     *
     * @param character karakter yang akan ditambahkan
     * @return true jika berhasil, false jika duplikat
     */
    public boolean addCharacter(Character character) {

        if (character == null) {
            System.out.println("Gagal: karakter tidak boleh null.");
            return false;
        }

        if (findByName(character.getName()) != null) {

            System.out.println(
                "Gagal: karakter dengan nama '" +
                character.getName() + "' sudah ada!"
            );

            return false;
        }

        characterList.add(character);

        System.out.println(
            "Karakter '" + character.getName() +
            "' berhasil ditambahkan."
        );

        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     *
     * @param name nama yang dicari
     * @return objek Character jika ditemukan, null jika tidak
     */
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character c : characterList) {

            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     *
     * @param name nama karakter yang akan dihapus
     * @return true jika berhasil dihapus
     */
    public boolean removeCharacter(String name) {

        Character target = findByName(name);

        if (target == null) {

            System.out.println(
                "Gagal hapus: karakter '" +
                name + "' tidak ditemukan."
            );

            return false;
        }

        characterList.remove(target);

        System.out.println(
            "Karakter '" + name + "' berhasil dihapus."
        );

        return true;
    }

    /**
     * Mengembalikan jumlah karakter yang tersimpan.
     *
     * @return jumlah karakter
     */
    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan salinan daftar karakter.
     *
     * Defensive copy digunakan agar pemanggil tidak
     * dapat mengubah struktur ArrayList internal.
     *
     * @return salinan ArrayList Character
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // ===============================
    // BAGIAN B - MINI CHALLENGE
    // ===============================

    /**
     * Menghitung rata-rata level seluruh karakter.
     *
     * @return rata-rata level atau 0.0 jika list kosong
     */
    public double getAverageLevel() {

        if (characterList.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     *
     * Menghasilkan ArrayList baru agar daftar internal
     * tidak dapat dimodifikasi oleh pemanggil.
     *
     * @param type tipe karakter yang dicari
     * @return ArrayList berisi karakter dengan tipe tersebut
     */
    public ArrayList<Character> findByType(CharacterType type) {

        if (type == null) {
            throw new IllegalArgumentException(
                "Tipe karakter tidak boleh null"
            );
        }

        ArrayList<Character> result = new ArrayList<>();

        for (Character c : characterList) {

            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    // ===============================
    // BAGIAN C - FITUR ANALITIK BARU
    // ===============================

    /**
     * Menghitung jumlah karakter berdasarkan tipe tertentu.
     *
     * Method ini tidak mengembalikan ArrayList asli,
     * sehingga struktur data internal tetap terlindungi.
     *
     * @param type tipe karakter yang ingin dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {

        if (type == null) {
            throw new IllegalArgumentException(
                "Tipe karakter tidak boleh null"
            );
        }

        int count = 0;

        for (Character c : characterList) {

            if (c.getType() == type) {
                count++;
            }
        }

        return count;
    }

}
