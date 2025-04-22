import java.util.Scanner;

public class BiletFiyat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan bilgiler alınır
        System.out.print("Mesafeyi giriniz (KM): ");
        int mesafe = scanner.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        int yas = scanner.nextInt();

        System.out.print("Yolculuk Tipini giriniz (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt();

        // Geçerli veri kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
        } else {
            double birimFiyat = 0.10;
            double normalTutar = mesafe * birimFiyat;
            double indirimliTutar = normalTutar;

            // Yaş indirimi
            if (yas < 12) {
                indirimliTutar *= 0.5; // %50 indirim
            } else if (yas >= 12 && yas <= 24) {
                indirimliTutar *= 0.9; // %10 indirim
            } else if (yas > 65) {
                indirimliTutar *= 0.7; // %30 indirim
            }

            // Yolculuk tipi indirimi
            if (yolculukTipi == 2) {
                indirimliTutar *= 0.8; // %20 indirim
                indirimliTutar *= 2;   // Gidiş-Dönüş için 2 kat fiyat
            }

            System.out.println("Toplam Bilet Fiyatı: " + indirimliTutar + " TL");
        }

        scanner.close();
    }
}
