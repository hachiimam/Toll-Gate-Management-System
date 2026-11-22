/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PraUAS;
import java.util.Scanner;
/**
 *
 * @author imam
 */
public class TuBes_KelompokAXELION_DDP2026 {
   public static void main(String[] args) {
       
        Scanner baca = new Scanner(System.in);

        int menu;
        int golongan;
        int masuk;
        int keluar;
        int pengali;
        int harga;
        int totalTarif;
        int pembayaran;
        int kembalian;
        String pilihan = "t";
        String nomorKendaraan;
        String[] gerbang = {
            "Pangkalpinang",
            "Sungailiat",
            "Koba",
            "Mentok"
        };
        int[][] tarif = {
            {0, 10000, 15000, 20000},
            {10000, 0, 12000, 18000},
            {15000, 12000, 0, 10000},
            {20000, 18000, 10000, 0}
        };

        do {
            System.out.println("======================================");
            System.out.println("     TOLL GATE MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Transaksi Kendaraan");
            System.out.println("2. Informasi Golongan Kendaraan");
            System.out.println("3. Informasi Tarif Tol");
            System.out.println("4. Keluar");
            System.out.println("======================================");
            System.out.print("Pilih menu: ");
            menu = baca.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\n=== TRANSAKSI KENDARAAN ===");
                    baca.nextLine();
                    
                    System.out.print("Nomor kendaraan: ");
                    nomorKendaraan = baca.nextLine();
                    System.out.println("\nGolongan Kendaraan:");
                    System.out.println("1. Golongan I");
                    System.out.println("2. Golongan II");
                    System.out.println("3. Golongan III");
                    System.out.print("Pilih golongan: ");
                    golongan = baca.nextInt();

                    System.out.println("\nDaftar Gerbang Tol:");
                    for (int i = 0; i < gerbang.length; i++) {
                        System.out.println((i + 1) + ". " + gerbang[i]);
                    }
                    System.out.print("Gerbang masuk: ");
                    masuk = baca.nextInt();

                    System.out.print("Gerbang keluar: ");
                    keluar = baca.nextInt();

                    if (golongan < 1 || golongan > 3) {
                        System.out.println("Golongan kendaraan tidak valid!");
                    } else if (masuk < 1 || masuk > 4 ||
                               keluar < 1 || keluar > 4) {
                        System.out.println("Gerbang tidak valid!");
                    } else if (masuk == keluar) {
                        System.out.println("Gerbang masuk dan keluar tidak boleh sama!");
                    } else {
                        switch (golongan) {
                            case 1:
                                pengali = 1;
                                break;
                            case 2:
                                pengali = 2;
                                break;
                            default:
                                pengali = 3;
                                break;
                        }
                        
                        harga = tarif[masuk - 1][keluar - 1];
                        totalTarif = harga * pengali;

                        System.out.println("\n=== RINCIAN PEMBAYARAN ===");
                        System.out.println("Nomor kendaraan : " + nomorKendaraan);
                        System.out.println("Golongan        : " + golongan);
                        System.out.println("Gerbang masuk   : " + gerbang[masuk - 1]);
                        System.out.println("Gerbang keluar  : " + gerbang[keluar - 1]);
                        System.out.println("Tarif dasar     : Rp" + harga);
                        System.out.println("Total tarif     : Rp" + totalTarif);
                        System.out.print("\nMasukkan pembayaran: Rp");
                        pembayaran = baca.nextInt();

                        if (pembayaran < totalTarif) {
                            System.out.println("Pembayaran tidak mencukupi!");
                            System.out.println("Kekurangan: Rp" +
                                    (totalTarif - pembayaran));
                        } else {
                            kembalian = pembayaran - totalTarif;

                            System.out.println("\n=== TRANSAKSI BERHASIL ===");
                            System.out.println("Total pembayaran : Rp" + pembayaran);
                            System.out.println("Kembalian        : Rp" + kembalian);
                            System.out.println("Silakan melanjutkan perjalanan.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n=== INFORMASI GOLONGAN KENDARAAN ===");
                    System.out.println("Golongan I   : Sedan, jip, pick-up, bus kecil");
                    System.out.println("Golongan II  : Kendaraan dengan 2 gandar");
                    System.out.println("Golongan III : Kendaraan dengan 3 gandar");

                    System.out.println("\nPengali Tarif:");
                    System.out.println("Golongan I   : 1x tarif dasar");
                    System.out.println("Golongan II  : 2x tarif dasar");
                    System.out.println("Golongan III : 3x tarif dasar");
                    break;

                case 3:
                    System.out.println("\n=== INFORMASI TARIF TOL ===");
                    System.out.printf("%-18s","Gerbang");

                    for (int i = 0; i < gerbang.length; i++) {
                        System.out.printf("%-16s", gerbang[i]);
                    }
                    System.out.println();
                    for (int i = 0; i < tarif.length; i++) {
                        System.out.printf("%-18s", gerbang[i]);

                        for (int j = 0; j < tarif[i].length; j++) {
                            System.out.printf("%-16s", tarif[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println("\nKeterangan: Tarif di atas merupakan tarif dasar Golongan I.");
                    break;

                case 4:
                    pilihan = "y";
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia!");
                    break;
            }

            if (menu != 4) {
                System.out.println();
                System.out.println("Apakah anda ingin keluar ? (y/t)");
                pilihan = baca.next();
                System.out.println();
            }

        } while (!pilihan.equalsIgnoreCase("y"));
        System.out.println();
        System.out.println("Program selesai");
        System.out.println("Terima Kasih Sudah Menggunakan");
        System.out.println("Toll Gate Management System");

        baca.close();
    }
}
