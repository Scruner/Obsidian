package ru.vdv;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Download2 {

  public static void main(String[] args) {
    String url = "https://avatars.mds.yandex.net/i?id=2a0000017a154fd41e530eadc7ca12abbeb5-4470198-images-thumbs&n=13";
    String fileName = "src/main/java/ru/vdv/dog1.jpg";

    saveURL(url, fileName);
  }

  public static void saveURL(String url, String fileName) {

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

