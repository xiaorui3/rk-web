package lanqiaomoni;

public class main8 {
    public static void main(String[] args) {
        String str="VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG" +
                "SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF" +
                "ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA" +
                "BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL" +
                "YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH" +
                "ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU" +
                "XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR" +
                "ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG" +
                "MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA" +
                "VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF" +
                "GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC" +
                "EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK" +
                "PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW" +
                "CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP" +
                "RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS" +
                "PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR" +
                "JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL" +
                "YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP" +
                "HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN" +
                "DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF" +
                "LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW" +
                "CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ" +
                "IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI" +
                "ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB" +
                "HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP" +
                "FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS" +
                "VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ" +
                "BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR" +
                "RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY" +
                "ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX";
        char [][] c=new char[30][50];
        int c1=0,c2=50;
        for(int i=0;i<30;i++){
            int t=0;
            for(int j=0;j<50;j++){
                c[i][j]=str.substring(c1,c2).charAt(t++);
            }
            t=0;
            c1=c1+50;
            c2=c2+50;
        }
        for(int i=0;i<30;i++){
            for(int j=0;j<50;j++){
               // System.out.print(c[i][j]+" ");
            }// System.out.println();
        }
        int sum=0;
        for(int i=0;i<30;i++){
            for(int j=0;j<50;j++){
                int a=c[i][j];
                for(int thang=j+1;thang<50;thang++){
                    if(a<c[i][thang]){//同一行
                        sum++;
                    }
                }
                for(int tlie=i+1;tlie<30;tlie++){
                    if(a<c[tlie][j]){//同一列
                        sum++;
                    }
                }
                for(int a1=i+1,a2=j+1;a1<30&&a2<50;a1++,a2++){
                    if(a<c[a1][a2]){
                        sum++;
                    }
                }
                for(int a1=i+1,a2=j-1;a1<30&&a2>=0;a1++,a2--){
                    if(a<c[a1][a2]){
                        sum++;
                    }
                }
                for(int a1=i-1,a2=j+1;a1>=0&&a2<50;a1--,a2++){
                    if(a<c[a1][a2]){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
