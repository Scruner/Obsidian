package ru.vdv;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Download3 {

  public static void main(String[] args) {
    String url = "https://avatars.mds.yandex.net/i?id=a9553026630e6114b4b2b064fddbcd18-5233229-images-thumbs&n=13";
    String fileName = "src/main/java/ru/vdv/dog2.jpg";

    downloadFileFromURL(url, fileName);
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

  public static boolean downloadFileFromURL(String url, String fileName) {
    try (InputStream inputStream = URI.create(url).toURL().openStream()) {
      Files.copy(inputStream, Paths.get(fileName));
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}

