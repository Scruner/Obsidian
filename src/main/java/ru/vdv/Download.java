package ru.vdv;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {

  public static void main(String[] args) {
    String url = "https://yandex-images.clstorage.net/l1oA00319/fd6e55XRWs/8-pLpMucTcipnCEQpU2z0Erdb7nO3BBTqOIO5CrsyKWXlJ07eXHxRF1ofC0ue9Hn_kfCTtRapNUhhLldPEAJ_Ly-D-jQggLCqJwiHaxWutdB1WCxysgXUfC1Fed_q8r224eXOhEWhTItDlZGUwuqnb8UmxuFRu_EN-reUGcee77RznyC3qUU75q8YCyKRoLcdrBPsN2AEA2o3Fj3Wo675-qT-1gXBaMXDDZqQWAliL6hH5QJl1Kn3wPxxwVaI3mewfNUp8GfKdK3jHkEiXqW31i6YpvSuQsDqOFDxFmyqfDxtcRBBy68Jxo-V2xQHbmxgieTNoVxhPU61vk9bytLiOzja431uiLdlI5ZIZ1QjtJGvGKE-JI8IqvjR8l2npj9wJ77RT4sjzEjAGFHWxqRtYwHnD6rRILHBN7kAnw6eJ3I_XGj8roXzKmMXDyXU6H_Rbxvhc6JFTSyy3LEQYG20vSY_3gnIZEnLjlPUXMJp5qHPq8bt0ymxTbs2yB9B1mCyepaiuqcCuyIhUo8gkSt_mqmc4vghxMat9ZB632jkPDKju5pFD6lESgWd35eCKW6vB-vHplxqtwW2-8xQyNVm_XsTJPKjC_JqYJiJK5ZscdXpEq087UKB4fKcdJQirL_zqHvcQMinRgqPXBtfT2XsbIbpw2Pd47DBM_4BmM-dKDx20iH_acT5J-GaSqycZ3zQLRJsum_PjiF0Vv-dZSL0fu4z1oLKpQQFzRWTF09gIGkEZ05r0yi3izE4D98J1a07fFWh-GuO-aZhmUftU6jxkSRVbXRpgsDqehEynuxusfbm85nGQuiIj0EWmVsPJCUjwKDD5Vyh8cH5fMgZBhfiNz8ToHRpAjtj4JgIaFTuNdFiVGv2Z0OJaTpUMRLib3Jx77eWjgEjAAcIm1gTxqihYw_pz2CW67gJ8HuPl0ZToPA3XKx96Ioya6qaAScVbj9YZtOsd2fExyN4kDxY50";
    String fileName = "src/main/java/ru/vdv/dog.jpg";

    FileOutputStream fileOutputStream = null;
    BufferedInputStream bufferedInputStream = null;

    try {
      bufferedInputStream = new BufferedInputStream(new URL(url).openStream());
      fileOutputStream = new FileOutputStream(fileName);
      byte data[] = new byte[1024];
      int count;
      while ((count = bufferedInputStream.read(data, 0, 1024)) != -1) {
        fileOutputStream.write(data, 0, count);
        fileOutputStream.flush();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        try {
          bufferedInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            fileOutputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      } finally {
      }
    }
  }
}
