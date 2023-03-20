class FileDownloader {

    interface CallBack {
        void avisar(String aviso);
    }
    public void downloadFile(String filePath,CallBack callBack) {
        // simular progreso de descarga
        for (int percentage = 0; percentage <= 100; percentage += 10) {

            // actualizar el progresso cada 10%
            callBack.avisar("Loading progress: " + percentage + "%");

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
        //fileDownloader.downloadFile();

        fileDownloader.downloadFile("http://.../myFile.txt", new FileDownloader.CallBack() {
            @Override
            public void avisar(String aviso) {
                System.out.println("Aviso : " + aviso);
            }
        });

    }
}