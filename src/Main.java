
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println(
            "========================================"
        );
        System.out.println(
            "     CHARACTER MANAGER v1.0"
        );
        System.out.println(
            "========================================"
        );

        CharacterManager manager = new CharacterManager();

        // ====================================
        // 1. MENAMBAHKAN KARAKTER
        // ====================================

        System.out.println("\n--- PENAMBAHAN KARAKTER ---");

        manager.addCharacter(
            new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 4)
        );

        manager.addCharacter(
            new Character("Gandalf", CharacterType.MAGE, 6)
        );

        // ====================================
        // 2. MENGUJI DUPLIKAT
        // ====================================

        System.out.println("\n--- PENGUJIAN DUPLIKAT ---");

        manager.addCharacter(
            new Character("Arjuna", CharacterType.HEALER, 1)
        );

        System.out.println(
            "Total karakter: " +
            manager.getTotalCharacters()
        );

        // ====================================
        // 3. MENGUJI FIND BY NAME
        // ====================================

        System.out.println("\n--- PENCARIAN KARAKTER ---");

        Character hasil = manager.findByName("Merlin");

        if (hasil != null) {
            System.out.println("Karakter ditemukan:");
            System.out.println(hasil);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        Character tidakAda = manager.findByName("Zeus");

        if (tidakAda == null) {
            System.out.println(
                "Zeus tidak ditemukan (sesuai harapan)."
            );
        }

        // ====================================
        // 4. MENGUJI REMOVE CHARACTER
        // ====================================

        System.out.println("\n--- PENGHAPUSAN KARAKTER ---");

        manager.removeCharacter("Athena");

        System.out.println(
            "Total setelah penghapusan: " +
            manager.getTotalCharacters()
        );

        // ====================================
        // 5. MENAMPILKAN SELURUH KARAKTER
        // ====================================

        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // ====================================
        // 6. MINI CHALLENGE: AVERAGE LEVEL
        // ====================================

        System.out.println("\n--- RATA-RATA LEVEL ---");

        System.out.println(
            "Rata-rata level: " +
            manager.getAverageLevel()
        );

        // Menguji kondisi list kosong
        CharacterManager emptyManager = new CharacterManager();

        System.out.println(
            "Rata-rata level list kosong: " +
            emptyManager.getAverageLevel()
        );

        // ====================================
        // 7. MINI CHALLENGE: FIND BY TYPE
        // ====================================

        System.out.println("\n--- PENCARIAN BERDASARKAN TIPE ---");

        ArrayList<Character> daftarMage =
            manager.findByType(CharacterType.MAGE);

        System.out.println("Daftar karakter MAGE:");

        for (Character c : daftarMage) {
            System.out.println(c);
        }

        // ====================================
        // 8. FITUR ANALITIK: COUNT BY TYPE
        // ====================================

        System.out.println("\n--- ANALITIK KARAKTER ---");

        System.out.println(
            "Jumlah Warrior: " +
            manager.countByType(CharacterType.WARRIOR)
        );

        System.out.println(
            "Jumlah Mage: " +
            manager.countByType(CharacterType.MAGE)
        );

        System.out.println(
            "Jumlah Archer: " +
            manager.countByType(CharacterType.ARCHER)
        );

        System.out.println(
            "Jumlah Healer: " +
            manager.countByType(CharacterType.HEALER)
        );

        // ====================================
        // 9. PENGUJIAN EQUALS
        // ====================================

        System.out.println("\n--- PENGUJIAN EQUALS ---");

        Character c1 =
            new Character("Arjuna", CharacterType.WARRIOR, 5);

        Character c2 =
            new Character("Arjuna", CharacterType.MAGE, 2);

        System.out.println(
            "c1.equals(c2): " + c1.equals(c2)
        );

        System.out.println(
            "Nama sama dianggap sama meskipun tipe berbeda."
        );

        // ====================================
        // 10. PENGUJIAN REFERENCE
        // ====================================

        System.out.println("\n--- PENGUJIAN REFERENCE ---");

        Character a =
            new Character("Ragnar", CharacterType.WARRIOR, 5);

        Character b = a;

        b.setLevel(8);

        System.out.println(
            "Level a setelah b.setLevel(8): " +
            a.getLevel()
        );

        System.out.println(
            "Apakah a == b? " + (a == b)
        );

        // Membuat objek independen
        Character independent =
            new Character(
                a.getName(),
                a.getType(),
                a.getLevel()
            );

        independent.setLevel(2);

        System.out.println(
            "Level a: " + a.getLevel()
        );

        System.out.println(
            "Level independent: " +
            independent.getLevel()
        );

        System.out.println(
            "Apakah a == independent? " +
            (a == independent)
        );

        // ====================================
        // 11. PENGUJIAN DEFENSIVE COPY
        // ====================================

        System.out.println("\n--- PENGUJIAN DEFENSIVE COPY ---");

        ArrayList<Character> salinan =
            manager.getAllCharacters();

        System.out.println(
            "Total list asli sebelum perubahan: " +
            manager.getTotalCharacters()
        );

        salinan.clear();

        System.out.println(
            "Jumlah elemen salinan setelah clear: " +
            salinan.size()
        );

        System.out.println(
            "Total list asli setelah clear: " +
            manager.getTotalCharacters()
        );

        // ====================================
        // 12. PENGUJIAN STATIC
        // ====================================

        System.out.println("\n--- TOTAL OBJECT CREATED ---");

        System.out.println(
            "Total objek Character yang dibuat: " +
            Character.getTotalCharacterCreated()
        );

        System.out.println(
            "\n========== PROGRAM SELESAI =========="
        );
    }
}
