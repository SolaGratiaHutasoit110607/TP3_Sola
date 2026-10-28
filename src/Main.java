import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // Membuat 3 object Character menggunakan constructor pertama
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);

        // Menampilkan ketiganya menggunakan toString()
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Demo level up
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");
        hero.setLevel(hero.getLevel() + 1);   // HP & Attack dihitung ulang otomatis
        System.out.println("After level up: " + hero);

        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // ===== Demo Bagian B: atribut mana & isAlive() =====
        System.out.println();
        System.out.println("=== Demo Mini-Challenge ===");
        Character healer = new Character("Selene", CharacterType.HEALER, 2);
        healer.setMana(80);
        System.out.println(healer);
        System.out.println(">> " + healer.getName() + " masih hidup? " + healer.isAlive());

        healer.setHitPoints(0);
        System.out.println(">> Setelah HP 0, masih hidup? " + healer.isAlive());

        try {
            healer.setMana(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(">> Error validasi: " + e.getMessage());
        }
    }
}