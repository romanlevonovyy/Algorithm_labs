public class Beers6 {
    private static int choose(String[] lyrics) {
        int n = lyrics.length, m = lyrics[0].length();
        int[] lyric = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                lyric[i] = lyric[i] << 1;
                lyric[i] += (lyrics[i].charAt(j) == 'Y') ? 1 : 0;
            }
        int min = Integer.MAX_VALUE;
        loop: for (int i = 1; i < (1 << m); i++) {
            for (int j = 0; j < n; j++)
                if ((i & lyric[j]) == 0)
                    continue loop;
            min = Math.min(Integer.bitCount(i), min);
        }
        return min;
    }

    public static void main(String[] args) {
        String[] lyrics = new String[]{"YNN", "YNY", "YNY", "NYY", "NYY", "NYN"};
        System.out.println(choose(lyrics));
    }
}