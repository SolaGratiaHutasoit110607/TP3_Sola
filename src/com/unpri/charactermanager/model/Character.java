package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {

    // ===== ATRIBUT (private - tidak bisa diakses langsung dari luar class) =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // ===== CONSTRUCTOR 1: untuk membuat karakter BARU =====
    // Dipakai saat user membuat karakter dari form (belum punya id dari database)
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    // ===== CONSTRUCTOR 2: untuk MEMUAT karakter dari database =====
    // Dipakai saat data sudah ada (id dan statistik sudah final dari DB)
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
    }

    // ===== HELPER PRIVATE: hanya dipakai internal class ini =====
    private int calculateBaseHP() {
        return 100 + (level * 10);   // contoh: level 5 -> HP = 150
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);     // contoh: level 5 -> Attack = 35
    }

    // ===== GETTER =====
    public int getId() { return id; }
    public String getName() { return name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public int getHitPoints() { return hitPoints; }
    public int getAttackPower() { return attackPower; }
    public int getMana() { return mana; }

    // ===== SETTER (dengan VALIDASI) =====
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.name = name;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null");
        }
        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();       // statistik dihitung ULANG setiap level berubah
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("Hit points tidak boleh negatif");
        }
        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException("Attack power tidak boleh negatif");
        }
        this.attackPower = attackPower;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }
        this.mana = mana;
    }

    // ===== METHOD BARU (Bagian B) =====
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== toString(): representasi teks object =====
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}';
    }
}