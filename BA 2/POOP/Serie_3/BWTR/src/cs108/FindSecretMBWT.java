package cs108;

public class FindSecretMBWT {
    public static void main(String[] args) {
        String m = "ssssrs;àtsessten .hmmfffm asnsltsLlll"
                + "ssrlhhhrrr   cl lmmb ll aaii  eaaouoeçstu uuu"
                + "eeeeeeee suuu ennu ceeeeeeeo a";
        Pair<Integer, String> mBWT = new Pair<>(17, m);

        String decodedMBWT = BurrowsWheelerTransform.backward(mBWT);

        System.out.println("mBWT secret message is : \"" + decodedMBWT + "\"");
    }
}
