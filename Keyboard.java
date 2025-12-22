class Keyboard {
    private boolean[] bukvi;
    private boolean[] zifri;
    private boolean shift;

    public Keyboard() {
        bukvi = new boolean[26];
        zifri = new boolean[10];
        shift = true;

        for (int i = 0; i<26; i++)
            bukvi[i] = true;
        for (int i=0; i<10; i++)
            zifri[i] = true;
    }

    public String BrokenKeys() {
        String r="";
        for (int i = 0; i <26; i++) {
            if (bukvi[i]==false)
                r+=(char) ('a' + i) + ", ";
        }
        for (int i = 0; i < 10; i++) {
            if (zifri[i]==false)
                r += (char) ('0' + i) + ", ";
        }
        if (shift==false)
            r+= "SHIFT,";
        if (r.length() == 0)
            return "Все клавиши работают";
        return r;
    }

    public void Breakk(char x) {
        if (x >='a' && x <='z')
            bukvi[x-'a'] = false;
        else if (x>= 'A' && x <= 'Z')
            bukvi[x-'A'] = false;
        else if (x >= '0' && x <= '9')
            zifri[x-'0'] = false;
        else if (x == '*')
            shift = false;
    }

    public boolean Printt(char x) {
        if (x >= 'a' && x <= 'z')
            return bukvi[x - 'a'];
        else if (x >= 'A' && x <= 'Z') {
            if (shift == false)
                return false;
            else if (bukvi[x -'A'] == false)
                return false;
        return true;
        }
        else if (x >= '0' && x <= '9')
            return zifri[x-'0'];
        return true;
    }

    public void Repair(char x) {
        if (x >= 'a' && x <= 'z')
            bukvi[x - 'a'] = true;
        else if (x >='A' && x <= 'Z')
            bukvi[x-'A'] = true;
        else if (x >= '0' && x <= '9')
            zifri[x - '0'] = true;
        else if (x == '*')
            shift = true;
    }

    public boolean PrintWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Printt(word.charAt(i))==false)
                return false;
        }
        return true;
    }

    public boolean Bukvibr() {
        for (int i = 0; i < 26; i++) {
            if (bukvi[i]==false)
                return true;
        }
        return false;
    }

    public boolean ZifriAllBr() {
        for (int i = 0; i < 10; i++) {
            if (zifri[i]==true)
                return false;
        }
        return true;
    }

    public String KlWord(String word) {
        String r="";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c>='a' && c <= 'z') {
                if (bukvi[c-'a']==false)
                    r+=c + ", ";
            }
            else if (c >= 'A' && c <= 'Z') {
                if (bukvi[c-'A']==false)
                    r += (char)(c+32) + ", ";
                if (shift==false)
                    r += "SHIFT, ";
            }
            else if (c>='0' && c <= '9') {
                if (zifri[c - '0']==false)
                    r+=c + ", ";
            }
        }
        if (r.length() == 0)
            return "Все клавиши есть";
        return r;
    }

    public int WordText(String text) {
        String[] words = text.split(" ");
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            boolean canPrint = PrintWord(w);
            if (canPrint == true)
                k ++;
        }
        return k;
    }

    public void AnWord(String word) {
        for (int i = 0; i<word.length();i++) {
            char c = word.charAt(i);
            if (Printt(c)==true)
                System.out.print(c);
            else {
                Breakk(c);
                System.out.print("[" + c + "-broken]");
            }
        }
        System.out.println();
    }

    public void BosstanPolomka(String x, boolean y) {
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (y==true)
                Repair(c);
            else
                Breakk(c);
        }
    }

}
