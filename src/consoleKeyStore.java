import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import java.util.Scanner;

/**
 * Created by wliu on 29/08/17.
 */
public class consoleKeyStore {

    private static ThreadLocal<Cipher[]> ciphersTL = new ThreadLocal<Cipher[]>() {
        @Override
        protected Cipher[] initialValue() {
            FileInputStream keyStoreStream = null;
            try {

                KeyStore keyStore = KeyStore.getInstance("JCEKS");
                keyStoreStream = new FileInputStream("secretKeystore");
                keyStore.load(keyStoreStream, "xWxYz520".toCharArray());
                Key encryptionKey = keyStore.getKey("authenticationKey", "5erYz59".toCharArray());
                byte[] keyMaterial = encryptionKey.getEncoded();
                SecretKeySpec key = new SecretKeySpec(keyMaterial, "DES");

                Cipher encryptCipher = Cipher.getInstance("DES");
                encryptCipher.init(Cipher.ENCRYPT_MODE, key);
                Cipher decryptCipher = Cipher.getInstance("DES");
                decryptCipher.init(Cipher.DECRYPT_MODE, key);
                return new Cipher[]{encryptCipher, decryptCipher};
            } catch (IOException ioex) {
                throw new RuntimeException("Error loading keystore file. " + ioex.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    if (keyStoreStream != null)
                        keyStoreStream.close();
                } catch (IOException ex) {
                    //do nothing
                }
            }
        }
    };

    public static class HexString {
        String hexString;

        public HexString(byte[] bytes) {
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                int current = 0xFF & bytes[i];

                if (current < 0x10)
                    hexString.append("0");

                hexString.append(Integer.toHexString(current));
            }

            setHexString(hexString.toString());
        }

        public HexString(String hexString) {
            if (!hexString.matches("[0-9a-f]+"))
                throw new NumberFormatException("Number is not a hex string");
            this.hexString = hexString;
        }

        public String getHexString() {
            return hexString;
        }

        public void setHexString(String hexString) {
            this.hexString = hexString;
        }

        public String toString() {
            return getHexString();
        }

        public int hashCode() {
            return getHexString().hashCode();
        }

        public boolean equals(Object obj) {
            return getHexString().equals(obj);
        }

        public byte[] getBytes() {
            byte result[] = new byte[hexString.length() / 2];
            for (int i = 0; i < result.length; i++) {
                String currentByte = hexString.substring(i * 2, (i * 2) + 2);
                result[i] = (byte) (0xFF & Integer.parseInt(currentByte, 16));
            }
            return result;
        }
    }

    public static String encrypt(String plainText) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher encryptCipher = ciphersTL.get()[0];
        byte encryptedBytes[] = encryptCipher.doFinal(plainText.getBytes("UTF-8"));
        return new HexString(encryptedBytes).toString();
    }


    public static void main(String [] args) throws BadPaddingException, IllegalBlockSizeException, IOException {
        for(int i=1; i<11; i++){
            String FILENAME = i+ ".txt";
            Scanner input = new Scanner(System.in);
            File file = new File(FILENAME);
            input = new Scanner(file);

            String outputFileName = "output-"+i+".txt";
            FileWriter fw = new FileWriter(outputFileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = line.replaceAll(",","");
                String result = line + " : " + encrypt(line);
                out.println(result);
            }
            input.close();
            out.close();
        }


    }


}
