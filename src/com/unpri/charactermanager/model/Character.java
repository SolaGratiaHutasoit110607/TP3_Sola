
package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 *
 * Menerapkan prinsip Encapsulation dengan menjadikan seluruh atribut
 * sebagai private dan menyediakan getter serta setter.
 */
public class Character {

    // Atribut instance
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Atribut static untuk menghitung seluruh objek Character
    private static int totalCharacterCreated = 0;

    /**
     * Constructor untuk membuat karakter baru.
     *
     * HP dan attack power dihitung otomatis berdasarkan level.
     */
    public Character(String name, CharacterType type, int level) {

        setName(name);
        setType(type);
        setLevel(level);

        this.mana = 0;

        totalCharacterCreated++;
    }

    /**
     * Constructor untuk memuat karakter dari database.
     *
     * Statistik karakter menggunakan nilai yang diberikan.
     */
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {

        setName(name);
        setType(type);
        setLevel(level);

        if (hitPoints < 0 || attackPower < 0) {
            throw new IllegalArgumentException(
                "Statistik karakter tidak boleh negatif"
            );
        }

        this.id = id;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Helper private

    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    /**
     * Mengembalikan jumlah seluruh objek Character
     * yang telah dibuat selama program berjalan.
     */
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Setter dengan validasi

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong"
            );
        }

        this.name = name;
    }

    public void setType(CharacterType type) {

        if (type == null) {
            throw new IllegalArgumentException(
                "Tipe karakter tidak boleh null"
            );
        }

        this.type = type;
    }

    public void setLevel(int level) {

        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1"
            );
        }

        this.level = level;

        // Menghitung ulang statistik berdasarkan level
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {

        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                "Hit points tidak boleh negatif"
            );
        }

        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {

        if (attackPower < 0) {
            throw new IllegalArgumentException(
                "Attack power tidak boleh negatif"
            );
        }

        this.attackPower = attackPower;
    }

    public void setMana(int mana) {

        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    // Method tambahan

    /**
     * Memeriksa apakah karakter masih hidup.
     *
     * @return true jika HP lebih dari 0
     */
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // toString

    @Override
    public String toString() {

        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hp=" + hitPoints +
                ", atk=" + attackPower +
                ", mana=" + mana +
                '}';
    }

    // equals

    /**
     * Membandingkan dua karakter berdasarkan nama.
     * Perbandingan nama bersifat case-sensitive.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(this.name, other.name);
    }

    /**
     * Menghasilkan hash code berdasarkan nama karakter.
     * Konsisten dengan implementasi equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
