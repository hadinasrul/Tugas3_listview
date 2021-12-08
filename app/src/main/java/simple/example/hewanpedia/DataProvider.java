package simple.example.hewanpedia;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import simple.example.hewanpedia.model.Game;
import simple.example.hewanpedia.model.Naga;
import simple.example.hewanpedia.model.Pedia;
import simple.example.hewanpedia.model.Unggas;

public class DataProvider {
    private static List<Pedia> pedias = new ArrayList<>();

    private static List<Unggas> initDataUnggas(Context ctx) {
        List<Unggas> unggases = new ArrayList<>();
        unggases.add(new Unggas("Angsa", "Cygnus",
                "Angsa adalah hewan terbesar dari golongan keluarga anatidae. Sekaligus salah satu burung terbesar yang bisa berenang dan juga bisa terbang.", R.drawable.angsa));
        unggases.add(new Unggas("Ayam", "Gallus",
                "Ayam adalah adalah unggas yang biasa dipelihara orang untuk dimanfaatkan untuk keperluan hidup pemeliharanya.", R.drawable.ayam));
        unggases.add(new Unggas("Kalkun", "meleagris",
                "Ayam kalkun adalah sebutan untuk dua spesies burung yang memiliki ukuran tubuh besar. Hewan ini termasuk dalam keluarga galliformes", R.drawable.kalkun));
        unggases.add(new Unggas("Puyuh", "Coturnix",
                " Burung puyuh memiliki ukuran tubuh menengan bahkan cenderung bertubuh kecil. Burung puyuh adalah hewan unggas daratan yang kecil namun memiliki perut yang gemuk.", R.drawable.puyuh));
        unggases.add(new Unggas("Bebek", "Anas",
                "Bebek adalah burung akuatik yang memilliki ukuran badan lebih kecil dari angsa. Bebek bisa hidup di darat maupun di air, akan tetapi bebek akan lebih banyak di temukan di perairan air tawar.", R.drawable.bebek));
        unggases.add(new Unggas("Pinguin", "Aptenodytes",
                "Penguin adalah hewan akuatik jenis burung yang tidak bisa terbang dan secara umum hidup di belahan Bumi selatan.", R.drawable.pinguin));
        return unggases;
    }

    private static List<Naga> initDataNaga(Context ctx) {
        List<Naga> nagas = new ArrayList<>();
        nagas.add(new Naga("Huang Long", "China",
                "Huang Long ketika terjaga, tidur dan bernapas menentukan siang dan malam, serta musim dan cuaca", R.drawable.uanglong));
        nagas.add(new Naga("Hydra", "Yunani",
                "Hydra digambarkan sebagai naga yang memiliki sembilan kepala. Konon jika salah satu kepalanya dipenggal, maka akan tumbuh kepala yang baru", R.drawable.hydra));
        nagas.add(new Naga("Dragon", "Eropa",
                "Diyakini naga ini berbetuk seperti kadal raksasa yang memiliki sayap dan mampu menyemburkan api dari mulutnya.", R.drawable.dragon));
        nagas.add(new Naga("Quetzalcoatl", "Aztek",
                "Quetzalcoatl (bacanya gimana sih ini -_-) diyakini sebagai Dewa Pencipta dan langit Aztek", R.drawable.quetzalcoatl));
        nagas.add(new Naga("Tiamat", "Babilonia",
                "Tiamat ini diyakini melahirkan para dewa generasi pertama.", R.drawable.tiamat));
        nagas.add(new Naga("Qilin", "China",
                "Makhluk ini dipercaya sebagai hewan suci dan pelindung dari bencana. Ia hanya menghukum orang-orang jahat dan tidak akan menginjak satu pun makhluk hidup. ", R.drawable.qilin));
        return nagas;
    }

    private static List<Game>initDataGame(Context ctx) {
        List<Game> games = new ArrayList<>();
        games.add(new Game("Gensin Impact", "miHoYo",
                "enshin Impact adalah permainan free-to-play action RPG dunia terbuka yang dikembangkan oleh miHoYo. Game ini dirilis pada tanggal 28 September 2020.", R.drawable.genshin));
        games.add(new Game("Blue Archive", "NEXON",
                "Blue Archive adalah game RPG untuk mobile yang dikembangkan oleh NetGames, anak perusahaan dari Nexon. Server Jepangnya sendiri sudah rilis sejak awal tahun ini. Blue Archive mengusung tema sekolah.", R.drawable.arsipbiru));
        games.add(new Game("Mobile Legen:Bang Bang", "MOONTON",
                "Mobile Legends merupakan game MOBA 5VS5 yang rilis pada 2016", R.drawable.mlbb));
        games.add(new Game("PUBGM", "Tencent Game",
                "PUBG Mobile merupakan gim battle royale yang dirancang oleh Brendan Greene. Secara resmi gim ini dirilis secara global pada bulan Maret 2018.", R.drawable.pubgm));
        games.add(new Game("Honkai: Star Trail", "miHoYo",
                "Honkai: Star Trail merupakan game yang akan dirilis mihoyo diawal tahun 2022, dan baru membuka beta test untuk game ini", R.drawable.startrail));
        games.add(new Game("Subway Surfers", "Kiloo Games dan Sybo Games",
                "Subway Surfers adalah permainan melarikan diri yang diusung oleh Kiloo Games dan Sybo Games yang dirilis pada tahun 2012.", R.drawable.subway));
        return games;
    }

    private static void initAllPedias(Context ctx) {
        pedias.addAll(initDataUnggas(ctx));
        pedias.addAll(initDataNaga(ctx));
        pedias.addAll(initDataGame(ctx));
    }

    public static List<Pedia> getAllPedia(Context ctx) {
        if (pedias.size() == 0) {
            initAllPedias(ctx);
        }
        return  pedias;
    }

    public static List<Pedia> getPediasByTipe(Context ctx, String jenis) {
        List<Pedia> pediasByType = new ArrayList<>();
        if (pedias.size() == 0) {
            initAllPedias(ctx);
        }
        for (Pedia h : pedias) {
            if (h.getJenis().equals(jenis)) {
                pediasByType.add(h);
            }
        }
        return pediasByType;
    }

}
